package pageobjects;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement accountName = $(byCssSelector("li[class='text-[0.8125rem] leading-6 pr-3 pl-2 text-sm font-medium text-gray-500']")); //имя пользователя

    public String getAccountName(){
        return (accountName.getText());
    }
}
