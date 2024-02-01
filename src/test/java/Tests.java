import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import constatns.Accounts;
import constatns.URL;
import org.junit.Before;
import pageobjects.LoginPage;


public class Tests {


    @Before
    public void setUp(){

    }

    @org.junit.Test
    public void LoginTest(){
//        LoginPage loginPage = new LoginPage(driver);
//        Configuration.browser = "firefox";
        Selenide.open(URL.MAIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin(Accounts.ADMIN_EMAIL);
        loginPage.setPassword(Accounts.ADMIN_PASSWORD);
        loginPage.clickLoginButton();
    }

}
