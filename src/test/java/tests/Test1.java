package tests;

import org.testng.annotations.Test;
import pages.*;

import static base.Enums.Currency.*;
import static com.codeborne.selenide.Selenide.*;


public class Test1 extends base.TestInit {

    @Test
    public void checkCustomerTransactions() {

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
                .chooseCustomerCurrency(RUPEE.getLabel())
                .clickProcessBtn();

        var openAccountAlert = switchTo().alert();
        var accountCode = openAccountAlert.getText().replaceAll("[^0-9]", "");
        openAccountAlert.accept();

        new ManagerCustomersPage()
                .openCustomerPage()
                .assertCustomerByFirstName(randomFirstName)
                .assertCustomerByPostCode(randomPostCode)
                .assertCustomerByAccountID(accountCode)
                .deleteCustomerByFirstName(randomFirstName);
    }
}
