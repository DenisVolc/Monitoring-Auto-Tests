package loginpage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import constatns.Accounts;
import constatns.URL;
import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;


public class Tests {
    @Test
    public void LoginTest(){
        String login = Accounts.ADMIN_EMAIL;
        String password = Accounts.ADMIN_PASSWORD;
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin(login); // ввожу логин
        loginPage.setPassword(password); // ввожу пароль
        loginPage.clickLoginButton(); // нажимаю кнопку войти
        HomePage homePage = new HomePage();
        assertEquals(login, homePage.getAccountName()); // сравниваю что отображаемый логи совпадает с введеным
    }

}
