package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CustomerDepositPage extends CustomerPageElements {

    private final By depositInputLabel = By.xpath("//label[text() = 'Amount to be Deposited :']");
    private final By depositInput = By.xpath("//label[text() = 'Amount to be Deposited :']/following-sibling::input");
    private final By depositBtn = By.xpath("//button[contains(text(), 'Deposit') and @type='submit']");

    public void clickDepositSubmitBtn () {
        $(depositBtn).shouldBe(enabled).click();
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
