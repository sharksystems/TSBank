package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class ManagerCustomersPage extends ManagerPageElements {

    private final By customersSearch = By.xpath("//input[@ng-model='searchCustomer']");
    private final By sortByFirstNameBtn = By.xpath("//a[contains(text(), 'First Name')]");
    private final By sortByLastNameBtn = By.xpath("//a[contains(text(), 'Last Name')]");
    private final By sortByPostCodeBtn = By.xpath("//a[contains(text(), 'Post Code')]");
    private final By accountNumberHeading = By.xpath("//td[contains(text(), 'Account Number')]");
    private final By deleteCustomerHeading = By.xpath("//td[contains(text(), 'Delete Customer')]");

    public ManagerCustomersPage openCustomersPage ()  {
        clickCustomersBtn();
        return this;
    }

    public ManagerCustomersPage assertCustomerByFirstName(String firstName) {
        assertTrue($x(format("//td[contains(text(), '%s')]", firstName)).shouldBe(Condition.visible).isDisplayed(), firstName + " not found on customers page");
        return this;
    }
    public ManagerCustomersPage assertCustomerByLastName(String lastName) {
        assertTrue($x(format("//td[contains(text(), '%s')]", lastName)).isDisplayed(), lastName + " not found on customers page");
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
    //td[contains(text(), '%s')]//following-sibling::td/button[@ng-click='deleteCust(cust)']
    public ManagerCustomersPage deleteCustomerByFirstAndLastName(String name, String lastname) {
        $x(format("//tr[td[contains(text(), '%s')] and td[contains(text(), '%s')]]//button", name, lastname)).shouldBe(enabled).click();
        return this;
    }
    public boolean isCustomersSearchVisible () {
        return ($(customersSearch).is(enabled));
    }
}