package tests;

import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;
import static data.Currencies.*;

public class BaseTest extends base.TestInit {

    @Test
    public void checkCustomerAccountCurrencies () {

        CustomerManager customerManager = new CustomerManager();
        customerManager.createCustomerForAccountsCheck();

        new HomePage().clickCustomerLoginBtn();
        new CustomerLoginPage()
                .chooseCustomerName(customerManager.getCustomerFirstName())
                .clickCustomerLoginSubmitBtn();
        new CustomerPageElements()
                .chooseCustomerAccount(customerManager.customerMultipleAccountsID[0])
                .assertCustomerCurrencyType(DOLLAR.getCurrency())
                .chooseCustomerAccount(customerManager.customerMultipleAccountsID[1])
                .assertCustomerCurrencyType(POUND.getCurrency())
                .chooseCustomerAccount(customerManager.customerMultipleAccountsID[2])
                .assertCustomerCurrencyType(RUPEE.getCurrency());

        customerManager.deleteCustomer();
    }

    @Test
    public void checkCustomerTransactionWithInvalidData () {

        CustomerManager customerManager = new CustomerManager();
        customerManager.createCustomer();

        HomePage homePage = new HomePage();

        homePage.clickCustomerLoginBtn();
        new CustomerLoginPage()
                .chooseCustomerName(customerManager.getCustomerFirstName())
                .clickCustomerLoginSubmitBtn();
        new CustomerDepositPage()
                .openDepositPage()
                .enterDepositAmount("0")
                .enterDepositAmount("-1")
                .enterDepositAmount("/")
                .assertNoSuccessfulDeposit();

        customerManager.deleteCustomer();
    }

    @Test
    public void checkCustomerTransactions() {

        CustomerManager customerManager = new CustomerManager();
        customerManager.createCustomer();

        new HomePage().clickCustomerLoginBtn();

        new CustomerLoginPage()
                .chooseCustomerName(customerManager.getCustomerFirstName())
                .clickCustomerLoginSubmitBtn();

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

        customerManager.deleteCustomer();
    }

    @Test
    public void checkManagerCustomerCreation() {

        CustomerManager customerManager = new CustomerManager();

        customerManager.createCustomer();

        new HomePage().clickManagerLoginBtn();

        new ManagerCustomersPage()
                .openCustomersPage()
                .assertCustomerByFirstName(customerManager.getCustomerFirstName())
                .assertCustomerByPostCode(customerManager.getCustomerPostCode())
                .assertCustomerByAccountID(customerManager.customerAccountID);

        customerManager.deleteCustomer();
    }
}
