package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CustomerDepositPage extends BasePage<CustomerDepositPage> {

    By depositInput = By.xpath("//label[text() = 'Amount to be Deposited :']/following-sibling::input");
    By depositBtn = By.xpath("//button[contains(text(), 'Deposit') and @type='submit']");

    public void clickDepositBtn () {
        $(depositBtn).shouldBe(enabled).click();
    }
    public CustomerDepositPage enterDepositAmount (String amount) {
        $(depositInput).shouldBe(enabled).sendKeys(amount);
        clickDepositBtn();
        System.out.println("Deposit of "+amount+" made");
        return this;
    }
}
