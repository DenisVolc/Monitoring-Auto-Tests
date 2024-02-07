package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.Password;
import constatns.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class NegativLoginTestParm {
    private String email;

    private int number;


    public NegativLoginTestParm(String email) {
        this.email = email;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {"adminmail.ru"},
                {"admin@.ru"},
                {"admin@mailru"},
                {"admin@mail."},
                {"ad min@mail.ru",},
                {"admin!@#$%^&*()\"№;:?+_-=/|{}[].<>,`~@mail.ru"},//
                {".admin@mail.ru"},
                {"admin.@mail.ru"},
                {"админ@mail.ru"},
                {"админmail.ru"},
                {"админ@.ru"},
                {"админ@mailru"},
                {"админ@mail."},
                {"ад мин@mail.ru"},
                {"АдМин@mail.ru"},
                {"а.д_м-и.н@mail.ru"},
                {"админ!@#$%^&*()\"№;:?+_-=/|{}[].<>,`~@mail.ru"},//
                {".админ@mail.ru"},
                {"админ.@mail.ru"},
        };
    }
    @Before
    public void Before(){
        System.out.println("Expected: " + email);
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
    }
    @Test
    public void Test(){
        LoginPage loginPage = new LoginPage();
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        loginPage.login(email, Password.ADMIN);
        System.out.println("Не реализована обратотка всплывашек");
        assertTrue(loginPage.isWrongLoginPasswordDisplayed());// проверяю появется ли всплывашка о неверном пароле или аккаунте
    }
    @After
    public void Close(){
        Selenide.closeWindow();
    }

}
