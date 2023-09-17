package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class CustomerDepositPage extends BasePage<CustomerDepositPage> {

    public final By depositInputLabel = By.xpath("//label[text() = 'Amount to be Deposited :']");
    public final By depositInput = By.xpath("//label[text() = 'Amount to be Deposited :']/following-sibling::input");
    public final By depositBtn = By.xpath("//button[contains(text(), 'Deposit') and @type='submit']");

    public void clickDepositBtn () {
        $(depositBtn).shouldBe(enabled).click();
    }

    public CustomerDepositPage enterDepositAmount (String amount) {
        $(depositInput).shouldBe(enabled).sendKeys(amount);
        clickDepositBtn();
        System.out.println("Deposit of "+amount+" made");
        return this;
    }
    public CustomerDepositPage assertCustomerDepositElementsVisible () {
        assertTrue($(depositInputLabel).shouldBe(visible).isDisplayed(),"deposit input label not found");
        assertTrue($(depositInput).shouldBe(visible).isDisplayed(),"deposit input not found");
        assertTrue($(depositBtn).shouldBe(visible).isDisplayed(),"deposit btn not found");
        return this;
    }
}
