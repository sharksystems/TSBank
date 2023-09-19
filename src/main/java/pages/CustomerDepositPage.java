package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CustomerDepositPage extends CustomerPageElements {


    private final By depositInputLabel = By.xpath("//label[text() = 'Amount to be Deposited :']");
    private final By depositInput = By.xpath("//label[text() = 'Amount to be Deposited :']/following-sibling::input");
    private final By depositBtn = By.xpath("//button[contains(text(), 'Deposit') and @type='submit']");
    private final By depositSuccessfulMsg = By.xpath("//span[contains(text(), 'Deposit Successful')]");

    public void clickDepositSubmitBtn () {
        $(depositBtn).shouldBe(enabled).click();
    }

    public CustomerDepositPage assertNoSuccessfulDeposit () {
        Assert.assertFalse($(depositSuccessfulMsg).shouldNotBe(visible).isDisplayed());
        return this;
    }

    public CustomerDepositPage openTransactionsPage () {
        clickTransactionsBtn();
        return this;
    }
    public CustomerDepositPage openWithdrawalPage() {
        clickWithdrawalBtn();
        return this;
    }
    public CustomerDepositPage openDepositPage() {
        clickDepositBtn();
        return this;
    }

    public CustomerDepositPage enterDepositAmount (String amount) {
        $(depositInput).shouldBe(enabled).sendKeys(amount);
        clickDepositSubmitBtn();
        System.out.println("Deposit of "+amount+" made");
        return this;
    }
}
