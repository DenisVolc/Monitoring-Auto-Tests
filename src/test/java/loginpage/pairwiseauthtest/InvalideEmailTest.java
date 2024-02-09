package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.Email;
import constatns.Password;
import constatns.URL;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.LoginPage;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class InvalideEmailTest {
    private String login;
    private String password;
    private boolean isRememberMe; //чекбокс оставаться в системе
    private boolean isSidePanel;//боковая панель
    private int number;


    public InvalideEmailTest(int number, String login, String password, boolean rememberMe, boolean sidePanel) {
        this.number = number;
        this.login = login;
        this.password = password;
        this.isRememberMe = rememberMe;
        this.isSidePanel = sidePanel;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {0,Email.INVALID,Password.ADMIN,false,true},//17//todo навестись на подсказку
                {1,Email.INVALID,Password.ADMIN,true,false},//18
                {2,Email.INVALID,Password.WRONG,true,true},//19
                {3,Email.INVALID,Password.SYMBOLS,false,true},//20
                {4,Email.INVALID,Password.EMPTY,true,false},//21
        };
    }
    @Test
    public void Test(){
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin(login); // ввожу логин
        loginPage.setPassword(password); // ввожу пароль
        if(isRememberMe){loginPage.clickRememberMeCheckbox();}
        if(isSidePanel){loginPage.clickSandwichButton();}
        loginPage.clickLoginButton(); // нажимаю кнопку войти
        boolean result = !loginPage.isWrongLoginPasswordDisplayed();
        assertTrue(result);
    }
    @After
    public void Close(){Selenide.closeWindow();}

}
