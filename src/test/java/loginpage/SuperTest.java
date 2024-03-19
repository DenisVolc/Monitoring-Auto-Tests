package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.URL;
import pageobjects.LoginPage;

public class SuperTest {
    protected LoginPage loginPage = new LoginPage();

    protected void doBefore(){
//        System.out.println("Expected: " + email);
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
    }
}
