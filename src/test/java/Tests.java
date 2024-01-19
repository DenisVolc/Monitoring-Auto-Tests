import com.codeborne.selenide.Selenide;
import constatns.Accounts;
import constatns.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.LoginPage;

//import static com.codeborne.selenide.Selenide.open;

public class Tests {
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @org.junit.Test
    public void LoginTest(){
        Selenide.open(URL.MAIN_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin(Accounts.ADMIN_EMAIL);
        loginPage.setPassword(Accounts.ADMIN_PASSWORD);
        loginPage.clickLoginButton();
    }

}
