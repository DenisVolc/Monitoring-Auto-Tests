package loginpage;

import com.codeborne.selenide.Selenide;
import constatns.Accounts;
import constatns.URL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParmLoginTest {
    private String login;
    private String password;
    private boolean isRememberMe; //чекбокс оставаться в системе
    private boolean isSidePanel;//боковая панель
    private short result;
//        SUCCESS, //0 - успешный вход
//        WRONG_PASSWORD,    // 1 - неправильынй пароль
//        EMPTY_PASSWORD,// 2 - пустой пароль
//        WRONG_ACCOUNT,// 3 - неправильный аккаунт
//        EMPTY_ACCOUNT,// 4 - пустой аккаунт
    // 5 - неверный формат

    public ParmLoginTest(String login, String password, boolean rememberMe, boolean sidePanel, short result ) {
        this.login = login;
        this.password = password;
        this.isRememberMe = rememberMe;
        this.isSidePanel = sidePanel;
        this.result = result;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][]loginCombinations(){
        return new Object[][]{
                {Accounts.ADMIN_EMAIL,Accounts.ADMIN_PASSWORD,true,true,0},//1
                {Accounts.ADMIN_EMAIL,Accounts.WRONG_PASSWORD,false,false,1},//2
                {Accounts.ADMIN_EMAIL,Accounts.SYMBOLS_PASSWORD,true,false,1},//3
                {Accounts.ADMIN_EMAIL,Accounts.EMPTY_PASSWORD,false,false,2},//4
                {Accounts.ANOTHER_EMAIL,Accounts.WRONG_PASSWORD,true,false,3},//5
                {Accounts.ANOTHER_EMAIL,Accounts.SYMBOLS_PASSWORD,true,false,3},//6
                {Accounts.ANOTHER_EMAIL,Accounts.EMPTY_PASSWORD,true,false,3},//7
                {Accounts.ANOTHER_EMAIL,Accounts.ADMIN_PASSWORD,false,true,3},//8
                {Accounts.WRONG_EMAIL,Accounts.SYMBOLS_PASSWORD,true,false,3},//9
                {Accounts.WRONG_EMAIL,Accounts.EMPTY_PASSWORD,true,true,3},//10
                {Accounts.WRONG_EMAIL,Accounts.ADMIN_PASSWORD,true,true,3},//11
                {Accounts.WRONG_EMAIL,Accounts.WRONG_PASSWORD,false,true,3},//12
                {Accounts.EMPTY_EMAIL,Accounts.EMPTY_PASSWORD,false,true,4},//13
                {Accounts.EMPTY_EMAIL,Accounts.ADMIN_PASSWORD,false,false,4},//14
                {Accounts.EMPTY_EMAIL,Accounts.WRONG_PASSWORD,true,true,4},//15
                {Accounts.EMPTY_EMAIL,Accounts.SYMBOLS_PASSWORD,false,true,4},//16
                {Accounts.INCORRECT_EMAIL,Accounts.ADMIN_PASSWORD,false,true,5},//17
                {Accounts.INCORRECT_EMAIL,Accounts.ADMIN_PASSWORD,true,false,5},//18
                {Accounts.INCORRECT_EMAIL,Accounts.WRONG_PASSWORD,true,true,5},//19
                {Accounts.INCORRECT_EMAIL,Accounts.SYMBOLS_PASSWORD,false,true,5},//20
                {Accounts.INCORRECT_EMAIL,Accounts.EMPTY_PASSWORD,true,false,5},//21
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
        System.out.println(result);
    }
}
