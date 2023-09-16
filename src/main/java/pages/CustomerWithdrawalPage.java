package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CustomerWithdrawalPage extends BasePage<CustomerWithdrawalPage> {

    By withdrawalInput = By.xpath("//label[text() = 'Amount to be Withdrawn :']/following-sibling::input");
    By withdrawBtn = By.xpath("//button[contains(text(), 'Withdraw') and @type='submit']");

    public void clickWithdrawBtn () {
        $(withdrawBtn).shouldBe(enabled).click();
    }
    public CustomerWithdrawalPage enterWithdrawalAmount (String amount) {
        $(withdrawalInput).shouldBe(enabled).sendKeys(amount);
        clickWithdrawBtn();
        System.out.println("Withdrawal of "+amount+" made");
        return this;
    }
}
