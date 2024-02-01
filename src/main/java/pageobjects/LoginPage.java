package pageobjects;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class LoginPage   {
    private SelenideElement loginInput = $(byId("user_email"));// поле ввода логина

    private SelenideElement passwordInput = $(byId("user_password"));// поле ввода пароля

    private SelenideElement rememberMeCheckbox =  $(byId("user_remember_me"));; // чек-бокс "Оставаться в системе"

    private SelenideElement loginButton = $(byXpath("//button[contains(text(),'Войти')]"));// Кнопка "Войти ->"

    private SelenideElement sandwichButton = $(byCssSelector("button[class='px-2 text-[#ffffff] fixed left-3 bottom-4 z-50']")); // Кнопка-бутерброд в нижнем левом углу

    private SelenideElement sidebar = $(byId("sidebar")); // Синяя полоса слева с лого компании


    public void setLogin(String login){//ввод имэила
        loginInput.sendKeys(login);
    }
    public  void setPassword(String password){//ввод пароля
        passwordInput.sendKeys(password);
    }
    public  void clickRememberMeCheckbox(){//нажать чекбокс "Оставаться в системе"
        rememberMeCheckbox.click();
    }
    public  void clickLoginButton(){//нажать кнопку "Войти"
        loginButton.click();
    }
    public  void clickSandwichButton(){//нажать кнопку-бутерброд
        sandwichButton.click();
    }
    public  boolean isSidebarIsDisplayed(){
        return sidebar.isDisplayed();
    }
}
