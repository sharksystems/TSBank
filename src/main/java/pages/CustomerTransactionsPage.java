package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class CustomerTransactionsPage extends CustomerPageElements {

    private final By backBtn = By.xpath("//button[@ng-click='back()']");
    private final By resetBtn = By.xpath("//button[@ng-click='reset()']");
    private final By sortDateTimeBtn = By.xpath("//a[contains(text(), 'Date-Time')]");
    private final By sortAmountBtnBtn = By.xpath("//a[contains(text(), 'Amount')]");
    private final By sortTransactionTypeBtn = By.xpath("//a[contains(text(), 'Transaction Type')]");
    private final By scrollToTopBtn = By.xpath("//button[@ng-click='scrollTop()']");
    private final By scrollDownBtn = By.xpath("//button[@ng-click='scrollRight()']");
    private final By scrollUpBtn = By.xpath("//button[@ng-click='scrollLeft()']");

    public CustomerTransactionsPage openTransactionsPage () {
        clickTransactionsBtn();
        return this;
    }
    public CustomerTransactionsPage openDepositPage() {
        clickDepositBtn();
        return this;
    }
    public CustomerTransactionsPage openWithdrawalPage() {
        clickWithdrawalBtn();
        return this;
    }
    public CustomerTransactionsPage clickBackBtn() {$(backBtn).shouldBe(enabled).click(); return this;}
    public CustomerTransactionsPage clickResetBtn() {$(resetBtn).shouldBe(enabled).click(); return this;}

    public CustomerTransactionsPage assertCustomerDepositByAmount (String amount) {
        assertTrue($x(format("//td[starts-with(text(), 'Credit')]/preceding-sibling::td[starts-with(text(), '%s')]", amount)).shouldBe(visible).isDisplayed(), "Deposit not found");
        return this;
    }
    public CustomerTransactionsPage assertCustomerWithdrawalByAmount (String amount) {
        assertTrue($x(format("//td[starts-with(text(), 'Debit')]/preceding-sibling::td[starts-with(text(), '%s')]", amount)).shouldBe(visible).isDisplayed(), "Withdrawal not found");
        return this;
    }
}
