package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CustomerDepositPage extends BasePage<CustomerDepositPage> {

    By depositInput = By.xpath("//input[@ng-model='amount']");
    By depositBtn = By.xpath("//button[contains(text(), 'Withdraw') and @type='submit']");

    public CustomerDepositPage enterDepositAmount (String amount) {
        $(depositInput).shouldBe(enabled).sendKeys(amount);
        return this;
    }
    public void clickDepositBtn () {
        $(depositBtn).shouldBe(enabled).click();
    }
}
