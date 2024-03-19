package loginpage.emailtest;

import com.codeborne.selenide.Selenide;
import constatns.Password;
import constatns.URL;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import loginpage.SuperTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NegativLoginParmTest extends SuperTest {

    @Parameterized.Parameter
    public String email;

    private int number;


//    public NegativLoginParmTest(String email) {
//        this.email = email;
//    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {"adminmail.ru"}, //alert
                {"admin@.ru"},//alert
                {"admin@mailru"},//неверный логин
                {"admin@mail."},//alert
                {"ad min@mail.ru",},//alert
                {"admin!@#$%^&*()\"№;:?+_-=/|{}[].mail.ru"},//alert#$%^&*()"№;:?+_=/|{}[]<>,`~
                {"admin!#$%^&*()\"№;:?+_-=/|{}[].@mail.ru"},//alert
                {"админ@mail.ru"},//alert
                {"админmail.ru"},//alert
                {"админ@.ru"},//alert
                {"админ@mailru"},//alert
                {"админ@mail."},//alert
                {"ад мин@mail.ru"},//alert
                {"АдМин@mail.ru"},//alert
                {"а.д_м-и.н@mail.ru"},//alert
                {"админ!@#$%^&*()\"№;:?+_-=/|{}[].<>,`~@mail.ru"},//alert
                {".админ@mail.ru"},//alert
                {"админ.@mail.ru"},//
        };
    }
    @Before
    public void Before(){
        System.out.println("Expected: " + email);
        doBefore();
//        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
    }
    @Test
//    @DisplayName("Негативная проверка неправильным логином: {email}")
    @Description("Негативная проверка неправильным логином")
    public void Test(){
        loginPage.login(email, Password.ADMIN);
        boolean result = !loginPage.isWrongLoginPasswordDisplayed();
        assertTrue(result);
    }
    @After
    public void Close(){
        Selenide.closeWindow();
    }

}
