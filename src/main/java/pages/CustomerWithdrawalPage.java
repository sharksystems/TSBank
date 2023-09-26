package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CustomerWithdrawalPage extends CustomerPageElements {

    private final By withdrawalInputLabel = By.xpath("//label[text() = 'Amount to be Withdrawn :']");
    private final By withdrawalInput = By.xpath("//label[text() = 'Amount to be Withdrawn :']/following-sibling::input");
    private final By withdrawBtn = By.xpath("//button[contains(text(), 'Withdraw') and @type='submit']");
    private final By withdrawalSuccessfulMsg = By.xpath("//span[contains(text(), 'Transaction successful')]");
    private final By withdrawalFailMsg = By.xpath("//span[contains(text(), 'Transaction Failed. You can not withdraw amount more than the balance.')]");


    public CustomerWithdrawalPage openTransactionsPage () {
        clickTransactionsBtn();
        return this;
    }
    public CustomerWithdrawalPage openDepositPage() {
        clickDepositBtn();
        return this;
    }
    public CustomerWithdrawalPage openWithdrawalPage() {
        clickWithdrawalBtn();
        return this;
    }

    public void clickWithdrawBtn () {
        $(withdrawBtn).shouldBe(enabled).click();
    }

    public CustomerWithdrawalPage enterWithdrawalAmount (String amount) {
        $(withdrawalInput).shouldBe(enabled).clear();
        $(withdrawalInput).shouldBe(enabled).sendKeys(amount);
        clickWithdrawBtn();
        System.out.println("Withdrawal of "+amount+" made");
        return this;
    }
    public CustomerWithdrawalPage assertNoSuccessfulWithdrawal () {
        assertFalse($(withdrawalSuccessfulMsg).shouldNotBe(visible).isDisplayed());
        return this;
    }
    public CustomerWithdrawalPage assertWithdrawalFailMsg () {
        assertTrue($(withdrawalFailMsg).shouldBe(visible).isDisplayed());
        return this;
    }
}
