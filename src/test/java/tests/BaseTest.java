package tests;

import data.RandomCustomer;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;
import static data.Currencies.*;

public class BaseTest extends base.TestInit {

    @Test
    public void checkCustomerTransactions() {

        RandomCustomer testCustomer = new RandomCustomer();

        HomePage homePage = new HomePage();

        homePage.clickManagerLoginBtn();

        new ManagerAddCustomerPage()
                .openAddCustomerPage()
                .enterCustomerFirstName(testCustomer.getFirstName())
                .enterCustomerLastName(testCustomer.getLastName())
                .enterRandomCustomerPostCode(testCustomer.getPostCode())
                .clickCustomerSubmitBtn();

        new ManagerOpenAccountPage()
                .openCreateAccountPage()
                .chooseCreatedCustomer(testCustomer.getFirstName())
                .chooseCustomerCurrency(DOLLAR.getCurrency())
                .clickProcessBtn()
                .clickHomeBtn();

        homePage.clickCustomerLoginBtn();

        new CustomerLoginPage()
                .chooseCustomerName(testCustomer.getFirstName())
                .clickCustomerLoginBtn();

        new CustomerDepositPage()
                .openDepositPage()
                .enterDepositAmount("4");

        new CustomerWithdrawalPage()
                .openWithdrawalPage()
                .enterWithdrawalAmount("3")
                .enterWithdrawalAmount("1");
        sleep(10000);

        new CustomerTransactionsPage()
                .openTransactionsPage()
                .assertCustomerDepositByAmount("4")
                .assertCustomerWithdrawalByAmount("3")
                .assertCustomerWithdrawalByAmount("1")
                .clickResetBtn()
                .clickHomeBtn();
        homePage.clickManagerLoginBtn();

        new ManagerCustomersPage()
                .openCustomersPage()
                .deleteCustomerByFirstName(testCustomer.getFirstName());
    }

    @Test
    public void checkManagerCustomerCreation() {

        RandomCustomer testCustomer = new RandomCustomer();

        new HomePage().clickManagerLoginBtn();

        new ManagerAddCustomerPage()
                .openAddCustomerPage()
                .enterCustomerFirstName(testCustomer.getFirstName())
                .enterCustomerLastName(testCustomer.getLastName())
                .enterRandomCustomerPostCode(testCustomer.getPostCode())
                .clickCustomerSubmitBtn();

        new ManagerOpenAccountPage()
                .openCreateAccountPage()
                .chooseCreatedCustomer(testCustomer.getFirstName())
                .chooseCustomerCurrency(RUPEE.getCurrency())
                .clickProcessBtn();

        var openAccountAlert = switchTo().alert();
        var accountCode = openAccountAlert.getText().replaceAll("[^0-9]", "");
        openAccountAlert.accept();

        new ManagerCustomersPage()
                .openCustomersPage()
                .assertCustomerByFirstName(testCustomer.getFirstName())
                .assertCustomerByPostCode(testCustomer.getPostCode())
                .assertCustomerByAccountID(accountCode)
                .deleteCustomerByFirstName(testCustomer.getFirstName());
    }
}
