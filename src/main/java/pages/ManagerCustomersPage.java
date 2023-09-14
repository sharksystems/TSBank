package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class ManagerCustomersPage extends BasePage<ManagerCustomersPage> {

    ManagerMainPage managerMainPage = new ManagerMainPage();

    public ManagerCustomersPage openCustomerPage () {
        managerMainPage.clickCustomersBtn();
        return this;
    }

    public ManagerCustomersPage assertCreatedCustomerName(String name) {
        assertTrue($x(format("//td[contains(text(), '%s')]", name)).shouldBe(Condition.visible).isDisplayed(), name + " not found on customers page");
        return this;
    }

    public ManagerCustomersPage assertCreatedCustomerPostCode(String postCode) {
        assertTrue($x(format("//td[contains(text(), '%s')]", postCode)).isDisplayed(), postCode + " not found on customers page");
        return this;
    }

    public ManagerCustomersPage assertCreatedCustomerAccountCode(String accountId) {
        assertTrue($x(format("//td[contains(span, '%s')]", accountId)).isDisplayed(), accountId + " not found on customers page");
        return this;
    }
}