package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class CustomerTransactionsPage extends BasePage<CustomerTransactionsPage> {

    public final By backBtn = By.xpath("//button[@ng-click='back()']");
    public final By resetBtn = By.xpath("//button[@ng-click='reset()']");
    public final By sortDateTimeBtn = By.xpath("//a[contains(text(), 'Date-Time')]");
    public final By sortAmountBtnBtn = By.xpath("//a[contains(text(), 'Amount')]");
    public final By sortTransactionTypeBtn = By.xpath("//a[contains(text(), 'Transaction Type')]");
    public final By scrollToTopBtn = By.xpath("//button[@ng-click='scrollTop()']");
    public final By scrollDownBtn = By.xpath("//button[@ng-click='scrollRight()']");
    public final By scrollUpBtn = By.xpath("//button[@ng-click='scrollLeft()']");

    public void clickBackBtn() {$(backBtn).shouldBe(enabled).click();}
    public void clickResetBtn() {$(resetBtn).shouldBe(enabled).click();}

    public CustomerTransactionsPage assertCustomerDepositByAmount (String amount) {
        assertTrue($x(format("//td[starts-with(text(), 'Credit')]/preceding-sibling::td[starts-with(text(), '%s')]", amount)).shouldBe(visible).isDisplayed(), "Deposit not found");
        return this;
    }
    public CustomerTransactionsPage assertCustomerWithdrawalByAmount (String amount) {
        assertTrue($x(format("//td[starts-with(text(), 'Debit')]/preceding-sibling::td[starts-with(text(), '%s')]", amount)).shouldBe(visible).isDisplayed(), "Withdrawal not found");
        return this;
    }
    public CustomerTransactionsPage assertCustomerTransactionsElementsVisible () {
        //preconditions: at customer transaction page, customer has enough transactions created for scroll btns to be displayed
        assertTrue($(backBtn).shouldBe(visible).isDisplayed(), "back btn not found");
        assertTrue($(resetBtn).shouldBe(visible).isDisplayed(), "reset btn not found");
        assertTrue($(sortDateTimeBtn).shouldBe(visible).isDisplayed(), "sort by time/date btn not found");
        assertTrue($(sortAmountBtnBtn).shouldBe(visible).isDisplayed(), "sort by amount btn not found");
        assertTrue($(sortTransactionTypeBtn).shouldBe(visible).isDisplayed(), "sort by transaction type btn not found");
        assertTrue($(scrollToTopBtn).shouldBe(visible).isDisplayed(), "scroll to top btn not found");
        assertTrue($(scrollDownBtn).shouldBe(visible).isDisplayed(), "scroll down btn not found");
        assertTrue($(scrollUpBtn).shouldBe(visible).isDisplayed(), "scroll up btn not found");
        return this;
    }

}
