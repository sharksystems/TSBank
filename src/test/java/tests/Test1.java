package tests;

import org.testng.annotations.Test;
import pages.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;
import static pages.HomePage.customerLoginBtn;
import static pages.HomePage.managerLoginBtn;
import static pages.MainHeadPage.*;

public class Test1 extends base.TestInit {

    @Test
    public void checkCustomerTransactions () {

        new HomePage().openCustomerLoginBtn();

        new CustomerLoginPage().chooseCustomerName("Ron Weasly").clickCustomerLoginBtn();

        CustomerMainPage customerMainPage = new CustomerMainPage();
        customerMainPage.clickDepositBtn();

        new CustomerDepositPage().enterDepositAmount("4");

        customerMainPage.clickWithdrawalBtn();
        new CustomerWithdrawalPage()
                .enterWithdrawalAmount("3")
                .enterWithdrawalAmount("1");

        sleep(5000);
        customerMainPage.clickTransactionsBtn();
        new CustomerTransactionsPage()
                .assertCustomerDepositByAmount("4")
                .assertCustomerWithdrawalByAmount("3")
                .assertCustomerWithdrawalByAmount("1")
                .clickResetBtn();
    }

    @Test
    public void checkManagerCustomerCreation() {

        var randomFirstName = faker.name().firstName();
        var randomLastName = faker.name().lastName();
        var randomPostCode = faker.address().zipCode();

        new HomePage().openManagerLoginBtn();

        new ManagerAddCustomerPage()
                .openAddCustomerPage()
                .enterCustomerFirstName(randomFirstName)
                .enterCustomerLastName(randomLastName)
                .enterRandomCustomerPostCode(randomPostCode)
                .clickCustomerSubmitBtn();
        confirm();

        new ManagerOpenAccountPage()
                .openCreateAccountPage()
                .chooseCreatedCustomer(randomFirstName)
                .chooseCustomerCurrency()
                .clickProcessBtn();

        var openAccountAlert = switchTo().alert();
        var accountCode = openAccountAlert.getText().replaceAll("[^0-9]", "");
        openAccountAlert.accept();

        new ManagerCustomersPage()
                .openCustomerPage()
                .assertCreatedCustomerName(randomFirstName)
                .assertCreatedCustomerPostCode(randomPostCode)
                .assertCreatedCustomerAccountCode(accountCode);
    }

    @Test
    public void checkLoginPage() {

        assertTrue($(customerLoginBtn).shouldBe(visible).isDisplayed(), "customer btn not found");
        assertTrue($(managerLoginBtn).shouldBe(visible).isDisplayed(), "manager btn not found");
    }

    @Test
    public void checkMainHeader() {
        assertTrue($(mainHeadingTxt).isDisplayed(), "main heading not found");
        assertTrue($(homeBtn).isDisplayed(), "home btn not found");
        assertTrue($(logoutBtn).isDisplayed(), "logout btn not found");
    }
}
