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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class EmptyPswdAccTest {
    private String login;
    private String password;
    private boolean isRememberMe; //чекбокс оставаться в системе
    private boolean isSidePanel;//боковая панель
    private int number;


    public EmptyPswdAccTest(int number, String login, String password, boolean rememberMe, boolean sidePanel ) {
        this.number = number;
        this.login = login;
        this.password = password;
        this.isRememberMe = rememberMe;
        this.isSidePanel = sidePanel;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {0,Email.ADMIN,Password.EMPTY,false,false},//4//todo навестись на подсказку
                {1,Email.ANOTHER,Password.EMPTY,true,false},//7
                {2,Email.WRONG,Password.EMPTY,true,true},//10
                {3,Email.EMPTY,Password.EMPTY,false,true},//13
                {4,Email.EMPTY,Password.ADMIN,false,false},//14
                {5,Email.EMPTY,Password.WRONG,true,true},//15
                {6,Email.EMPTY,Password.SYMBOLS,false,true},//16
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
