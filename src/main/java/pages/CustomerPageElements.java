package pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CustomerPageElements extends BasePage {

    private final By customerTransactionsBtn = By.xpath("//button[@ng-click='transactions()']");
    private final By customerDepositBtn = By.xpath("//button[@ng-click='deposit()']");
    private final By customerWithdrawalBtn = By.xpath("//button[@ng-click='withdrawl()']");
    private final By customerAccountSelect = By.xpath("//select[@id='accountSelect']");
    private final By customerAccountNumber = By.xpath("//strong[@class='ng-binding'][1]");
    private final By customerAccountBalance = By.xpath("//strong[@class='ng-binding'][2]");
    private final By customerAccountCurrency = By.xpath("//strong[@class='ng-binding'][3]");

    public void clickTransactionsBtn() {
        $(customerTransactionsBtn).shouldBe(enabled).click();
    }
    public void clickDepositBtn() {
        $(customerDepositBtn).shouldBe(enabled).click();
    }
    public void clickWithdrawalBtn() {
        $(customerWithdrawalBtn).shouldBe(enabled).click();
    }

    public CustomerPageElements selectCustomerAccount(String name) {
        $(customerAccountSelect).shouldBe(enabled).selectOptionContainingText(name);
        return this;
    }
}

