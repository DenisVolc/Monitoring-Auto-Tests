package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage   {

    WebDriver driver;
    String checkout;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
//    @FindBy(how = How.XX, using = "YYY") // Comment
//    private SelenideElement DDD;

    @FindBy(how = How.ID, using = "user_email") // поле ввода логина
    private static SelenideElement loginInput;
    @FindBy(how = How.ID, using = "user_password") // поле ввода пароля
    private static SelenideElement passwordInput;
    @FindBy(how = How.ID, using = "user_remember_me") // чек-бокс "Оставаться в системе"
    private static SelenideElement rememberMeCheckbox;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Войти')]") // Кнопка "Войти ->"
    private static SelenideElement loginButton;
    @FindBy(how = How.CLASS_NAME, using = "px-2 text-[#ffffff] fixed left-3 bottom-4 z-50") // Кнопка-бутерброд в нижнем левом углу
    private static SelenideElement sandwichButton;
    @FindBy(how = How.ID, using = "sidebar") // Синяя полоса слева с лого компании
    private static SelenideElement sidebar;


    public static void setLogin(String login){//ввод имэила
        loginInput.sendKeys(login);
    }
    public static void setPassword(String password){//ввод пароля
        passwordInput.sendKeys(password);
    }
    public static void clickRememberMeCheckbox(){//нажать чекбокс "Оставаться в системе"
        rememberMeCheckbox.click();
    }
    public static void clickLoginButton(){//нажать кнопку "Войти"
        loginButton.click();
    }
    public static void clickSandwichButton(){//нажать кнопку-бутерброд
        sandwichButton.click();
    }
    public static boolean isSidebarIsDisplayed(){
        return sidebar.isDisplayed();
    }

}
