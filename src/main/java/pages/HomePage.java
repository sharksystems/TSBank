package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage<HomePage> {

    public static final By customerLoginBtn = By.xpath("//div/button[@ng-click='customer()']");
    public static final By managerLoginBtn = By.xpath("//div/button[@ng-click='manager()']");

    public HomePage openCustomerLoginBtn() {
        $(customerLoginBtn).shouldBe(enabled).click();
        return this;
    }
    public HomePage openManagerLoginBtn() {
        $(managerLoginBtn).shouldBe(enabled).click();
        return this;
    }
}
