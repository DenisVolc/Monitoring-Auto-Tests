package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.Email;
import constatns.Password;
import constatns.URL;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParmLoginTest {
    private String login;
    private String password;
    private boolean isRememberMe; //чекбокс оставаться в системе
    private boolean isSidePanel;//боковая панель
//    private int result;
////        SUCCESS, //0 - успешный вход
////        WRONG_PASSWORD,    // 1 - неправильынй пароль
////        EMPTY_PASSWORD,// 2 - пустой пароль
////        WRONG_ACCOUNT,// 3 - неправильный аккаунт
////        EMPTY_ACCOUNT,// 4 - пустой аккаунт
//    // 5 - неверный формат
        private enum Result {
        SUCCESS, //0 - успешный вход
        WRONG_PASSWORD,    // 1 - неправильынй пароль
        EMPTY_PASSWORD,// 2 - пустой пароль
        WRONG_ACCOUNT,// 3 - неправильный аккаунт
        INCORRECT_EMAIL,// 4 - пустой аккаунт
    // 5 - неверный формат
    }
        private Result statusEnum;


    public ParmLoginTest(String login, String password, boolean rememberMe, boolean sidePanel, Result statusEnum ) {
        this.login = login;
        this.password = password;
        this.isRememberMe = rememberMe;
        this.isSidePanel = sidePanel;
        this.statusEnum = statusEnum;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {Email.ADMIN,Password.ADMIN,true,true,Result.SUCCESS},//1
                {Email.ADMIN,Password.WRONG,false,false,Result.WRONG_PASSWORD},//2
                {Email.ADMIN,Password.SYMBOLS,true,false,Result.WRONG_PASSWORD},//3
                {Email.ADMIN,Password.EMPTY,false,false,Result.EMPTY_PASSWORD},//4
                {Email.ANOTHER,Password.WRONG,true,false,Result.WRONG_ACCOUNT},//5
                {Email.ANOTHER,Password.SYMBOLS,true,false,Result.WRONG_ACCOUNT},//6
                {Email.ANOTHER,Password.EMPTY,true,false,Result.WRONG_ACCOUNT},//7
                {Email.ANOTHER,Password.ADMIN,false,true,Result.WRONG_ACCOUNT},//8
                {Email.WRONG,Password.SYMBOLS,true,false,Result.WRONG_ACCOUNT},//9
                {Email.WRONG,Password.EMPTY,true,true,Result.WRONG_ACCOUNT},//10
                {Email.WRONG,Password.ADMIN,true,true,Result.WRONG_ACCOUNT},//11
                {Email.WRONG,Password.WRONG,false,true,Result.WRONG_ACCOUNT},//12
                {Email.EMPTY,Password.EMPTY,false,true,Result.WRONG_ACCOUNT},//13
                {Email.EMPTY,Password.ADMIN,false,false,Result.WRONG_ACCOUNT},//14
                {Email.EMPTY,Password.WRONG,true,true,Result.WRONG_ACCOUNT},//15
                {Email.EMPTY,Password.SYMBOLS,false,true,Result.WRONG_ACCOUNT},//16
                {Email.INCORRECT,Password.ADMIN,false,true,Result.INCORRECT_EMAIL},//17
                {Email.INCORRECT,Password.ADMIN,true,false,Result.INCORRECT_EMAIL},//18
                {Email.INCORRECT,Password.WRONG,true,true,Result.INCORRECT_EMAIL},//19
                {Email.INCORRECT,Password.SYMBOLS,false,true,Result.INCORRECT_EMAIL},//20
                {Email.INCORRECT,Password.EMPTY,true,false,Result.INCORRECT_EMAIL},//21
        };
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
//        HomePage homePage = new HomePage();
//        assertEquals(login, homePage.getAccountName()); // сравниваю что отображаемый логи совпадает с введеным
        System.out.println(statusEnum);
    }
    @After
    public void Close(){Selenide.closeWindow();}

}
