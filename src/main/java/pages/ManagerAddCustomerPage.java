package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ManagerAddCustomerPage extends ManagerPageElements {

    private final By firstNameField = By.xpath("//input[@ng-model='fName']");
    private final By lastNameField = By.xpath("//input[@ng-model='lName']");
    private final By postCodeField = By.xpath("//input[@ng-model='postCd']");
    private final By addCustomerSubmitBtn = By.xpath("//button[@type='submit' and contains(text(), 'Add Customer')]");
    private final By firstNameFieldLabel = By.xpath("//label[contains(text(), 'First Name :')]");
    private final By lastNameFieldLabel = By.xpath("//label[contains(text(), 'Last Name :')]");
    private final By postCodeFieldLabel = By.xpath("//label[contains(text(), 'Post Code :')]");

    public ManagerAddCustomerPage openAddCustomerPage() {
        clickAddCustomerBtn();
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
        confirm();
        return this;
    }
}
