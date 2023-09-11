package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ManagerMainPage extends BasePage<ManagerMainPage> {

    public static final By addCustomerBtn = new By.ByXPath("//button[@ng-click='addCust()']");
    public static final By openAccountBtn = new By.ByXPath("//button[@ng-click='openAccount()']");
    public static final By showCustomersBtn = new By.ByXPath("//button[@ng-click='showCust()']");

    public void clickCustomersBtn () {
        $(showCustomersBtn).shouldBe(enabled).click();
    }
    public void clickOpenAccountBtn () {
        $(openAccountBtn).shouldBe(enabled).click();
    }
    public void clickAddCustomerBtn () {
        $(addCustomerBtn).shouldBe(enabled).click();
    }



}
