package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public abstract class ManagerPageElements extends BasePage {

    private final By addCustomerBtn = new By.ByXPath("//button[@ng-click='addCust()']");
    private final By openAccountBtn = new By.ByXPath("//button[@ng-click='openAccount()']");
    private final By showCustomersBtn = new By.ByXPath("//button[@ng-click='showCust()']");

    public void clickCustomersBtn() {
        $(showCustomersBtn).shouldBe(enabled).click();
    }
    public void clickOpenAccountBtn() {
        $(openAccountBtn).shouldBe(enabled).click();
    }
    public void clickAddCustomerBtn() {
        $(addCustomerBtn).shouldBe(enabled).click();
    }
}
