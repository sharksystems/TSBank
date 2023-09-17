package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ManagerAddCustomerPage extends BasePage<ManagerAddCustomerPage> {

    public final By firstNameField = By.xpath("//input[@ng-model='fName']");
    public final By lastNameField = By.xpath("//input[@ng-model='lName']");
    public final By postCodeField = By.xpath("//input[@ng-model='postCd']");
    public final By addCustomerSubmitBtn = By.xpath("//button[@type='submit' and contains(text(), 'Add Customer')]");
    public final By firstNameFieldLabel = By.xpath("//label[contains(text(), 'First Name :')]");
    public final By lastNameFieldLabel = By.xpath("//label[contains(text(), 'Last Name :')]");
    public final By postCodeFieldLabel = By.xpath("//label[contains(text(), 'Post Code :')]");


    ManagerMainPage managerMainPage = new ManagerMainPage();

    public ManagerAddCustomerPage openAddCustomerPage() {
        managerMainPage.clickAddCustomerBtn();
        return this;
    }

    public ManagerAddCustomerPage enterCustomerFirstName(String name) {
        $(firstNameField).shouldBe(Condition.enabled).sendKeys(name);
        return this;
    }

    public ManagerAddCustomerPage enterCustomerLastName(String name) {
        $(lastNameField).shouldBe(Condition.enabled).sendKeys(name);
        return this;
    }

    public ManagerAddCustomerPage enterRandomCustomerPostCode(String name) {
        $(postCodeField).shouldBe(Condition.enabled).sendKeys(name);
        return this;
    }

    public ManagerAddCustomerPage clickCustomerSubmitBtn() {
        $(addCustomerSubmitBtn).shouldBe(Condition.enabled).click();
        return this;
    }

    public ManagerAddCustomerPage assertManagerCreateCustomerElementsVisible () {
        //prerequisites: at manager add customer page
        assertTrue($(firstNameField).shouldBe(visible).isDisplayed(), "first name input not found");
        assertTrue($(lastNameField).shouldBe(visible).isDisplayed(), "last name input not found");
        assertTrue($(postCodeField).shouldBe(visible).isDisplayed(), "postcode input not found");
        assertTrue($(addCustomerSubmitBtn).shouldBe(visible).isDisplayed(), "add customer btn not found");
        assertTrue($(firstNameFieldLabel).shouldBe(visible).isDisplayed(), "first name label not found");
        assertTrue($(lastNameFieldLabel).shouldBe(visible).isDisplayed(), "last name label not found");
        assertTrue($(postCodeFieldLabel).shouldBe(visible).isDisplayed(), "post code label not found");
        return this;
    }
}
