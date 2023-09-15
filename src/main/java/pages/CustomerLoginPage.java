package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CustomerLoginPage extends BasePage<CustomerLoginPage> {

    By customerNameSelectField = By.xpath("//select[@id='userSelect']");
    By customerLoginBtn = By.xpath("//select[@id='userSelect']");

    public void clickCustomerLoginBtn() {
        $(customerLoginBtn).shouldBe(visible).click();
    }

    public CustomerLoginPage chooseCustomerName(String name) {
        $(customerNameSelectField).selectOptionContainingText(name);
        return this;
    }
}
