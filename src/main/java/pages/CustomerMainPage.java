package pages;


import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class CustomerMainPage extends BasePage<CustomerMainPage> {

    public final By customerTransactionsBtn = By.xpath("//button[@ng-click='transactions()']");
    public final By customerDepositBtn = By.xpath("//button[@ng-click='deposit()']");
    public final By customerWithdrawalBtn = By.xpath("//button[@ng-click='withdrawl()']");
    public final By customerAccountSelect = By.xpath("//select[@id='accountSelect']");
    public final By customerAccountNumber = By.xpath("//strong[@class='ng-binding'][1]");
    public final By customerAccountBalance = By.xpath("//strong[@class='ng-binding'][2]");
    public final By customerAccountCurrency = By.xpath("//strong[@class='ng-binding'][3]");

    public void clickTransactionsBtn() {
        $(customerTransactionsBtn).shouldBe(enabled).click();
    }
    public void clickDepositBtn() {
        $(customerDepositBtn).shouldBe(enabled).click();
    }
    public void clickWithdrawalBtn() {
        $(customerWithdrawalBtn).shouldBe(enabled).click();
    }

    public CustomerMainPage selectCustomerAccount(String name) {
        $(customerAccountSelect).shouldBe(enabled).selectOptionContainingText(name);
        return this;
    }

    public CustomerMainPage assertCustomerMainPageElementsVisible () {
        //preconditions: at customer main page, customer has an existing account with any currency
        assertTrue($(customerTransactionsBtn).shouldBe(visible).isDisplayed(), "customer transactions btn not found");
        assertTrue($(customerDepositBtn).shouldBe(visible).isDisplayed(), "customer deposit btn not found");
        assertTrue($(customerWithdrawalBtn).shouldBe(visible).isDisplayed(), "customer withdrawal btn not found");
        assertTrue($(customerAccountSelect).shouldBe(visible).isDisplayed(), "customer account select not found");
        assertTrue($(customerAccountNumber).shouldBe(visible).isDisplayed(), "customer account № not found");
        assertTrue($(customerAccountBalance).shouldBe(visible).isDisplayed(), "customer balance not found");
        assertTrue($(customerAccountCurrency).shouldBe(visible).isDisplayed(), "customer account currency not found");
        return this;
    }
}

