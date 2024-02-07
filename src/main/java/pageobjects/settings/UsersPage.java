package pageobjects.settings;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

//https://tetramonitoring.ros.chat:4001/monitoring/users
public class UsersPage {
    public static final SelenideElement EMAIL_INPUT = $(byCssSelector("#user_email"));//ввод нового имеила
    public static final SelenideElement PASSWORD_INPUT = $(byCssSelector("#user_password"));//ввод нового пароля
    public static final SelenideElement CREATE_BUTTON = $(byXpath("//span[@class='inline-flex items-center']"));//кнопка создать
    public static final SelenideElement USERS_BUTTON = $(byXpath("//a[contains(text(),'Пользователи')]"));
}


