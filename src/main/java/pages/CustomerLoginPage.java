package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CustomerLoginPage extends BasePage<CustomerLoginPage> {

    By customerNameSelectField = By.xpath("//select[@id='userSelect']");
    By customerLoginBtn = By.xpath("//button[@type='submit']");

    public void clickCustomerLoginBtn() {
        $(customerLoginBtn).shouldBe(enabled).click();
    }

    public CustomerLoginPage chooseCustomerName(String name) {
        $(customerNameSelectField).shouldBe(enabled).selectOptionContainingText(name);
        return this;
    }
}
