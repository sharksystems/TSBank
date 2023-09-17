package pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class CustomerWithdrawalPage extends BasePage<CustomerWithdrawalPage> {

    public final By withdrawalInputLabel = By.xpath("//label[text() = 'Amount to be Withdrawn :']");
    public final By withdrawalInput = By.xpath("//label[text() = 'Amount to be Withdrawn :']/following-sibling::input");
    public final By withdrawBtn = By.xpath("//button[contains(text(), 'Withdraw') and @type='submit']");

    public void clickWithdrawBtn () {
        $(withdrawBtn).shouldBe(enabled).click();
    }
    public CustomerWithdrawalPage enterWithdrawalAmount (String amount) {
        $(withdrawalInput).shouldBe(enabled).sendKeys(amount);
        clickWithdrawBtn();
        System.out.println("Withdrawal of "+amount+" made");
        return this;
    }
    public CustomerWithdrawalPage assertCustomerWithdrawalElementsVisible () {
        assertTrue($(withdrawalInputLabel).shouldBe(visible).isDisplayed(),"withdrawal label not found");
        assertTrue($(withdrawalInput).shouldBe(visible).isDisplayed(),"withdrawal input not found");
        assertTrue($(withdrawBtn).shouldBe(visible).isDisplayed(),"withdrawal btn not found");
        return this;
    }
}
