package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ManagerAddCustomerPage extends BasePage<ManagerAddCustomerPage> {

    public static final By firstNameField = By.xpath("//input[@ng-model='fName']");
    public static final By lastNameField = By.xpath("//input[@ng-model='lName']");
    public static final By postCodeField = By.xpath("//input[@ng-model='postCd']");
    public static final By addCustomerSubmitBtn = By.xpath("//button[@type='submit' and contains(text(), 'Add Customer')]");

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
}
