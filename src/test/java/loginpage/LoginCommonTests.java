package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.Email;
import constatns.Password;
import constatns.URL;
import org.junit.Before;
import org.junit.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.junit.Assert.*;


public class LoginCommonTests {

    @Before
    public void Setup(){
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы

    }
    @Test
    public void LoginPairwiseTest(){
        String email = Email.ADMIN;
        String password = Password.ADMIN;
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin(email); // ввожу логин
        loginPage.setPassword(password); // ввожу пароль
        loginPage.clickRememberMeCheckbox();
        loginPage.clickSandwichButton();
        loginPage.clickLoginButton();
        HomePage homePage = new HomePage();
        assertEquals(email, homePage.getAccountName()); // сравниваю что отображаемый логи совпадает с введеным
    }
    @Test
    public void ShowSideBarTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.clickSandwichButton();
        loginPage.clickSandwichButton();
        assertTrue(loginPage.isSidebarDisplayed());
    }

    @Test
    public void HideSideBarTest(){
        LoginPage loginPage = new LoginPage();
        loginPage.clickSandwichButton();
        assertFalse(loginPage.isSidebarDisplayed());
    }

}
