import com.codeborne.selenide.Selenide;
import constatns.Accounts;
import constatns.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.LoginPage;

//import static com.codeborne.selenide.Selenide.open;

public class Tests {
    WebDriver driver;

    @Before
    public void setUp(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

    }

    @org.junit.Test
    public void LoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        Selenide.open(URL.MAIN_URL);//TODO прописать параметр  --allowed-ips
        loginPage.setLogin(Accounts.ADMIN_EMAIL);
        loginPage.setPassword(Accounts.ADMIN_PASSWORD);
        loginPage.clickLoginButton();
    }

}
