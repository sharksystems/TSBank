package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private final By customerLoginBtn = By.xpath("//div/button[@ng-click='customer()']");
    private final By managerLoginBtn = By.xpath("//div/button[@ng-click='manager()']");

    public HomePage clickCustomerLoginBtn() {
        $(customerLoginBtn).shouldBe(enabled).click();
        return this;
    }
    public HomePage clickManagerLoginBtn() {
        $(managerLoginBtn).shouldBe(enabled).click();
        return this;
    }
}
