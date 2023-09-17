package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class ManagerCustomersPage extends BasePage<ManagerCustomersPage> {

    ManagerMainPage managerMainPage = new ManagerMainPage();

    public final By customersSearch = By.xpath("//input[@ng-model='searchCustomer']");
    public final By sortByFirstNameBtn = By.xpath("//a[contains(text(), 'First Name')]");
    public final By sortByLastNameBtn = By.xpath("//a[contains(text(), 'Last Name')]");
    public final By sortByPostCodeBtn = By.xpath("//a[contains(text(), 'Post Code')]");
    public final By accountNumberHeading = By.xpath("//td[contains(text(), 'Account Number')]");
    public final By deleteCustomerHeading = By.xpath("//td[contains(text(), 'Delete Customer')]");

    public ManagerCustomersPage openCustomerPage ()  {
        managerMainPage.clickCustomersBtn();
        return this;
    }

    public ManagerCustomersPage assertCustomerByFirstName(String firstName) {
        assertTrue($x(format("//td[contains(text(), '%s')]", firstName)).shouldBe(Condition.visible).isDisplayed(), firstName + " not found on customers page");
        return this;
    }
    public ManagerCustomersPage assertCustomerByLastName(String lastName) {
        assertTrue($x(format("//td[contains(text(), '%s')]", lastName)).shouldBe(Condition.visible).isDisplayed(), lastName + " not found on customers page");
        return this;
    }

    public ManagerCustomersPage assertCustomerByPostCode(String postCode) {
        assertTrue($x(format("//td[contains(text(), '%s')]", postCode)).isDisplayed(), postCode + " not found on customers page");
        return this;
    }

    public ManagerCustomersPage assertCustomerByAccountID(String accountId) {
        assertTrue($x(format("//td[contains(span, '%s')]", accountId)).isDisplayed(), accountId + " not found on customers page");
        return this;
    }

    public ManagerCustomersPage deleteCustomerByFirstName(String name) {
        $x(format("//td[contains(text(), '%s')]//following-sibling::td/button[@ng-click='deleteCust(cust)']", name)).shouldBe(enabled).click();
        return this;
    }

    public ManagerCustomersPage assertCustomersPageElementsVisible () {
        assertTrue($(customersSearch).shouldBe(visible).isDisplayed(), "customers search field not found");
        assertTrue($(sortByFirstNameBtn).shouldBe(visible).isDisplayed(), "sort by first name btn not found");
        assertTrue($(sortByLastNameBtn).shouldBe(visible).isDisplayed(), "sort by last name btn not found");
        assertTrue($(sortByPostCodeBtn).shouldBe(visible).isDisplayed(), "sort by post code btn not found");
        assertTrue($(accountNumberHeading).shouldBe(visible).isDisplayed(), "account № heading not found");
        assertTrue($(deleteCustomerHeading).shouldBe(visible).isDisplayed(), "delete customer heading not found");
        assertCustomerByFirstName("Ron");
        assertCustomerByLastName("Weasly");
        assertCustomerByPostCode("E55555");
        assertCustomerByAccountID("1007");
        assertTrue($x("//td[contains(text(), 'Ron')]//following-sibling::td/button[@ng-click='deleteCust(cust)']").shouldBe(visible).isDisplayed(),"delete btn not found");
        return this;
    }
}