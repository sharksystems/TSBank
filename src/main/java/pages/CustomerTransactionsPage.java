package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

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
}
