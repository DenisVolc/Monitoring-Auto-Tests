package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.Email;
import constatns.Password;
import constatns.URL;
import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;


public class Tests {
    @Test
    public void LoginTest(){
        String email = Email.ADMIN;
        String password = Password.ADMIN;
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);
        HomePage homePage = new HomePage();
        assertEquals(email, homePage.getAccountName()); // сравниваю что отображаемый логи совпадает с введеным
    }

}
