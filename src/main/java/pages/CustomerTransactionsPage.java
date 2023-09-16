package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class CustomerTransactionsPage extends BasePage<CustomerTransactionsPage> {

    By backBtn = By.xpath("//button[@ng-click='back()']");
    By resetBtn = By.xpath("//button[@ng-click='reset()']");
    By sortDateTimeBtn = By.xpath("//a[contains(text(), 'Date-Time')]");
    By sortAmountBtnBtn = By.xpath("//a[contains(text(), 'Amount')]");
    By sortTransactionTypeBtn = By.xpath("//a[contains(text(), 'Transaction Type')]");
    By scrollToTopBtn = By.xpath("//button[@ng-click='scrollTop()']");
    By scrollDownBtn = By.xpath("//button[@ng-click='scrollRight()']");
    By scrollUpBtn = By.xpath("//button[@ng-click='scrollLeft()']");

    public void clickBackBtn() {$(backBtn).shouldBe(enabled).click();}
    public void clickResetBtn() {$(resetBtn).shouldBe(enabled).click();}
    public void clickSortDateTimeBtn() {$(sortDateTimeBtn).shouldBe(enabled).click();}
    public void clickScrollToTopBtn() {$(scrollToTopBtn).shouldBe(enabled).click();}
    public void clickScrollDownBtn() {$(scrollDownBtn).shouldBe(enabled).click();}
    public void clickScrollUpBtn() {$(scrollUpBtn).shouldBe(enabled).click();}

    public CustomerTransactionsPage assertCustomerDepositByAmount (String amount) {
        assertTrue($x(format("//td[starts-with(text(), 'Credit')]/preceding-sibling::td[starts-with(text(), '%s')]", amount)).shouldBe(visible).isDisplayed(), "Deposit not found");
        return this;
    }
    public CustomerTransactionsPage assertCustomerWithdrawalByAmount (String amount) {
        assertTrue($x(format("//td[starts-with(text(), 'Debit')]/preceding-sibling::td[starts-with(text(), '%s')]", amount)).shouldBe(visible).isDisplayed(), "Withdrawal not found");
        return this;
    }

}
