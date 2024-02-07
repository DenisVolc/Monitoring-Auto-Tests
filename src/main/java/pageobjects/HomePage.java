package pageobjects;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement accountName = $(byCssSelector("li[class='text-[0.8125rem] leading-6 pr-3 pl-2 text-sm font-medium text-gray-500']")); //имя пользователя

    public static final SelenideElement NODES = $(byXpath("//a[contains(@href,'/nodes')]")); //Узлы
    public static final SelenideElement NODES_DETAILS = $(byXpath("//a[contains(@href,'/cells')]")); //Узлы детально
    public static final SelenideElement STATISTIC = $(byXpath("//a[contains(@href,'/statistic')]")); //Статистика
    public static final  SelenideElement JOURNALS = $(byXpath("//a[contains(@href,'/journals?sort_by=dt&sort_order=desc')]")); //Журналы


    private SelenideElement issi = $(byXpath("//a[contains(@href,'/issi')]")); //Абоненты
    private SelenideElement groups = $(byXpath("//a[contains(@href,'/groups')]")); //Группы
    private SelenideElement gates = $(byXpath("//a[contains(@href,'/gates')]")); //Шлюзы
    private SelenideElement profiles = $(byXpath("//a[contains(@href,'/profiles')]")); //Прифили


    private SelenideElement inventory = $(byXpath("//a[contains(@href,'/inventory')]")); //Инвентаризация
    public static final SelenideElement SETTINGS = $(byCssSelector("body > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > div:nth-child(4) > div:nth-child(3) > a:nth-child(2)")); //
    private SelenideElement about = $(byXpath("//a[@href='/about']")); //
    public static final SelenideElement EXIT = $(byCssSelector("body > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > div:nth-child(4) > div:nth-child(5) > a:nth-child(2)")); //


    public String getAccountName(){
        return (accountName.getText());
    }
//    public void clickNodes (){
//        NODES.click();
////    }
//    public void clickNodesDetails(){
//        NODES_DETAILS.click();
//    }
//    public void clickStatistic() {
//        STATISTIC.click();
//    }
//    public void clickJournals() {
//        JOURNALS.click();
//    }
//    public void clickIssi (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//    public void click (){
//        .click();
//    }
//
}
