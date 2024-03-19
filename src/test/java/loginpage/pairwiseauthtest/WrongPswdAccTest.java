package loginpage.pairwiseauthtest;

import com.codeborne.selenide.Selenide;
import constatns.Email;
import constatns.Password;
import constatns.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class WrongPswdAccTest {
    private String login;
    private String password;
    private boolean isRememberMe; //чекбокс оставаться в системе
    private boolean isSidePanel;//боковая панель
    private int number;


    public WrongPswdAccTest(int number, String login, String password, boolean rememberMe, boolean sidePanel) {
        this.number = number;
        this.login = login;
        this.password = password;
        this.isRememberMe = rememberMe;
        this.isSidePanel = sidePanel;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {0,Email.ADMIN,Password.WRONG,false,false},//2
                {1,Email.ADMIN,Password.SYMBOLS,true,false},//3
                {2,Email.ANOTHER,Password.WRONG,true,false},//5//todo создать второго пользоавтеля в БД
                {3,Email.ANOTHER,Password.SYMBOLS,true,false},//6
                {4,Email.ANOTHER,Password.ADMIN,false,true},//8
                {5,Email.WRONG,Password.SYMBOLS,true,false},//9
                {6,Email.WRONG,Password.ADMIN,true,true},//11
                {7,Email.WRONG,Password.WRONG,false,true},//12
        };
    }
    @Test
    public void Test() {
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin(login); // ввожу логин
        loginPage.setPassword(password); // ввожу пароль
        if (isRememberMe) {
            loginPage.clickRememberMeCheckbox();
        }
        if (isSidePanel) {
            loginPage.clickSandwichButton();
        }
        loginPage.clickLoginButton(); // нажимаю кнопку войти
        assertTrue(loginPage.isWrongLoginPasswordDisplayed());// проверяю появется ли всплывашка о неверном пароле или аккаунте
    }
    @After
    public void Close(){Selenide.closeWindow();}

}
