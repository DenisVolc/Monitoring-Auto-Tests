package loginpage.emailtest;

import com.codeborne.selenide.Selenide;
import constatns.Email;
import constatns.Password;
import constatns.URL;
import loginpage.SuperTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.settings.UsersPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PositivLoginParmTest extends SuperTest {
    private String email;

    private int number;


    public PositivLoginParmTest(String email) {

        this.email = email;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {"AdMin@mail.ru"},
                {"a.d_m-i.n@mail.ru"},//позитивная проверка
        };
    }
    @Before
    public void Before(){
        System.out.println("Expected: " + email);
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        loginPage.login(Email.ADMIN, Password.ADMIN);
        HomePage.SETTINGS.click();
        UsersPage.USERS_BUTTON.click();
        UsersPage.EMAIL_INPUT.sendKeys(email);
        UsersPage.PASSWORD_INPUT.sendKeys(Password.ADMIN);
        UsersPage.CREATE_BUTTON.click();
        Selenide.closeWindow();
    }
    @Test
    public void Test(){
        LoginPage loginPage = new LoginPage();
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        loginPage.login(email, Password.ADMIN);
        HomePage homePage = new HomePage();
        assertEquals(email, homePage.getAccountName()); // сравниваю что отображаемый логи совпадает с введеным
    }
    @After
    public void Close(){
        HomePage.EXIT.click(); //открываю нужную страницы
        LoginPage loginPage = new LoginPage();
        loginPage.login(Email.ADMIN, Password.ADMIN);
        HomePage.SETTINGS.click();
        UsersPage.USERS_BUTTON.click();
        $(byXpath("//td[normalize-space()='" + email + "']/parent::tr//button")).click();//кнопка "удалить" у пользователя с именем email
        Selenide.switchTo().alert().accept();
        Selenide.closeWindow();
    }

}
