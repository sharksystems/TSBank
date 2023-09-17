package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class HomePage extends BasePage<HomePage> {

    public final By customerLoginBtn = By.xpath("//div/button[@ng-click='customer()']");
    public final By managerLoginBtn = By.xpath("//div/button[@ng-click='manager()']");

    public HomePage openCustomerLoginBtn() {
        $(customerLoginBtn).shouldBe(enabled).click();
        return this;
    }
    public HomePage openManagerLoginBtn() {
        $(managerLoginBtn).shouldBe(enabled).click();
        return this;
    }
    public HomePage assertHomePageElementsVisible () {
        assertTrue($(customerLoginBtn).shouldBe(visible).isDisplayed(), "customer btn not found");
        assertTrue($(managerLoginBtn).shouldBe(visible).isDisplayed(), "manager btn not found");
        return this;
    }
}
