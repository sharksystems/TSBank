package pages;


import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CustomerMainPage extends BasePage<CustomerMainPage> {

    By customerTransactionsBtn = By.xpath("//button[@ng-click='transactions()']");
    By customerDepositBtn = By.xpath("//button[@ng-click='deposit()']");
    By customerWithdrawalBtn = By.xpath("//button[@ng-click='withdrawl()']");
    By customerAccountSelect = By.xpath("//select[@id='accountSelect']");

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
}

