package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.Email;
import constatns.Password;
import constatns.URL;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AuthTestParm {
    private String login;
    private String password;
    private boolean isRememberMe; //чекбокс оставаться в системе
    private boolean isSidePanel;//боковая панель
    private enum Result {
        SUCCESS, //0 - успешный вход
        WRONG_PASSWORD_OR_ACCOUNT,    // 1 - неправильынй пароль
        EMPTY_PASSWORD_OR_ACCOUNT,// 2 - пустой пароль
        WRONG_ACCOUNT,// 3 - неправильный аккаунт
        INCORRECT_EMAIL,// 4 - пустой аккаунт
        E// 5 - неверный формат
    }
    private Result expected;
    private int number;


    public AuthTestParm(int number, String login, String password, boolean rememberMe, boolean sidePanel, Result statusEnum ) {
        this.number = number;
        this.login = login;
        this.password = password;
        this.isRememberMe = rememberMe;
        this.isSidePanel = sidePanel;
        expected = statusEnum;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {0,Email.ADMIN,Password.ADMIN,true,true,Result.SUCCESS},//1
                {1,Email.ADMIN,Password.WRONG,false,false,Result.WRONG_PASSWORD_OR_ACCOUNT},//2
                {2,Email.ADMIN,Password.SYMBOLS,true,false,Result.WRONG_PASSWORD_OR_ACCOUNT},//3
                {3,Email.ADMIN,Password.EMPTY,false,false,Result.EMPTY_PASSWORD_OR_ACCOUNT},//4//todo навестись на подсказку
                {4,Email.ANOTHER,Password.WRONG,true,false,Result.WRONG_PASSWORD_OR_ACCOUNT},//5//todo создать второго пользоавтеля в БД
                {5,Email.ANOTHER,Password.SYMBOLS,true,false,Result.WRONG_PASSWORD_OR_ACCOUNT},//6
                {6,Email.ANOTHER,Password.EMPTY,true,false,Result.EMPTY_PASSWORD_OR_ACCOUNT},//7
                {7,Email.ANOTHER,Password.ADMIN,false,true,Result.WRONG_PASSWORD_OR_ACCOUNT},//8
                {8,Email.WRONG,Password.SYMBOLS,true,false,Result.WRONG_PASSWORD_OR_ACCOUNT},//9
                {9,Email.WRONG,Password.EMPTY,true,true,Result.EMPTY_PASSWORD_OR_ACCOUNT},//10
                {10,Email.WRONG,Password.ADMIN,true,true,Result.WRONG_PASSWORD_OR_ACCOUNT},//11
                {11,Email.WRONG,Password.WRONG,false,true,Result.WRONG_PASSWORD_OR_ACCOUNT},//12
                {12,Email.EMPTY,Password.EMPTY,false,true,Result.EMPTY_PASSWORD_OR_ACCOUNT},//13
                {13,Email.EMPTY,Password.ADMIN,false,false,Result.EMPTY_PASSWORD_OR_ACCOUNT},//14
                {14,Email.EMPTY,Password.WRONG,true,true,Result.EMPTY_PASSWORD_OR_ACCOUNT},//15
                {15,Email.EMPTY,Password.SYMBOLS,false,true,Result.EMPTY_PASSWORD_OR_ACCOUNT},//16
                {16,Email.INCORRECT,Password.ADMIN,false,true,Result.INCORRECT_EMAIL},//17//todo навестись на подсказку
                {17,Email.INCORRECT,Password.ADMIN,true,false,Result.INCORRECT_EMAIL},//18
                {18,Email.INCORRECT,Password.WRONG,true,true,Result.INCORRECT_EMAIL},//19
                {19,Email.INCORRECT,Password.SYMBOLS,false,true,Result.INCORRECT_EMAIL},//20
                {20,Email.INCORRECT,Password.EMPTY,true,false,Result.INCORRECT_EMAIL},//21
        };
    }
    @Before
    public void Before(){
        System.out.println(number +". expected: " +expected);
    }
    @Test
    public void Test(){
        Selenide.open(URL.MAIN_URL); //открываю нужную страницы
        LoginPage loginPage = new LoginPage();
        loginPage.setLogin(login); // ввожу логин
        loginPage.setPassword(password); // ввожу пароль
        if(isRememberMe){loginPage.clickRememberMeCheckbox();}
        if(isSidePanel){loginPage.clickSandwichButton();}
        loginPage.clickLoginButton(); // нажимаю кнопку войти

        if (expected == Result.SUCCESS){
            HomePage homePage = new HomePage();
            assertEquals(login, homePage.getAccountName()); // сравниваю что отображаемый логи совпадает с введеным
        }

        if (expected == Result.WRONG_PASSWORD_OR_ACCOUNT){
            assertTrue(loginPage.isWrongLoginPasswordDisplayed());// проверяю появется ли всплывашка о неверном пароле или аккаунте
        }
        if(expected == Result.EMPTY_PASSWORD_OR_ACCOUNT){
            System.out.println("Не реализовано");
            assertTrue(false);
        }
        if(expected == Result.INCORRECT_EMAIL){
            System.out.println("assertTrue(false)");
            assertTrue(false);
        }
    }
    @After
    public void Close(){Selenide.closeWindow();}

}
