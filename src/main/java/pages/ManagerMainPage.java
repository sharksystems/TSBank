package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ManagerMainPage extends BasePage<ManagerMainPage> {

    public final By addCustomerBtn = new By.ByXPath("//button[@ng-click='addCust()']");
    public final By openAccountBtn = new By.ByXPath("//button[@ng-click='openAccount()']");
    public final By showCustomersBtn = new By.ByXPath("//button[@ng-click='showCust()']");

    public void clickCustomersBtn() {
        $(showCustomersBtn).shouldBe(enabled).click();
    }
    public void clickOpenAccountBtn() {
        $(openAccountBtn).shouldBe(enabled).click();
    }
    public void clickAddCustomerBtn() {$(addCustomerBtn).shouldBe(enabled).click();}

    public ManagerMainPage assertManagerMainPageElementsVisible () {
        assertTrue($(addCustomerBtn).shouldBe(visible).isDisplayed(),"add customer btn (main page) not found");
        assertTrue($(openAccountBtn).shouldBe(visible).isDisplayed(),"open account btn not found");
        assertTrue($(showCustomersBtn).shouldBe(visible).isDisplayed(),"show customers btn not found");
        return this;
    }
}
