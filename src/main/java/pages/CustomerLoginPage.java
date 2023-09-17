package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class CustomerLoginPage extends BasePage<CustomerLoginPage> {

    public final By customerNameSelectLabel = By.xpath("//select[@id='userSelect']/preceding-sibling::label");
    public final By customerNameSelectField = By.xpath("//select[@id='userSelect']");
    public final By customerLoginBtn = By.xpath("//button[@type='submit']");

    public void clickCustomerLoginBtn() {
        $(customerLoginBtn).shouldBe(enabled).click();
    }

    public CustomerLoginPage chooseCustomerName(String name) {
        $(customerNameSelectField).shouldBe(enabled).selectOptionContainingText(name);
        return this;
    }
    public CustomerLoginPage assertCustomerLoginElementsVisible () {
        chooseCustomerName("Ron Weasly");
        assertTrue($(customerNameSelectLabel).shouldBe(visible).isDisplayed(), "customer login select label not found");
        assertTrue($(customerNameSelectField).shouldBe(visible).isDisplayed(), "customer login select label not found");
        assertTrue($(customerLoginBtn).shouldBe(visible).isDisplayed(), "customer login select label not found");
        return this;
    }
}
