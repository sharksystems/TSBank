package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CustomerWithdrawalPage extends BasePage<CustomerWithdrawalPage> {

    By withdrawalInput = By.xpath("//input[@ng-model='amount']");
    By withdrawBtn = By.xpath("//button[contains(text(), 'Deposit') and @type='submit']");

    public CustomerWithdrawalPage enterWithdrawalAmount (String amount) {
        $(withdrawalInput).shouldBe(enabled).sendKeys(amount);
        return this;
    }
    public void clickWithdrawBtn () {
        $(withdrawBtn).shouldBe(enabled).click();
    }
}
