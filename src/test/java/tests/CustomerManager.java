package tests;

import data.RandomCustomer;
import pages.*;

import static com.codeborne.selenide.Selenide.switchTo;
import static data.Currencies.*;

public class CustomerManager {

    private final RandomCustomer testCustomer = new RandomCustomer();
    HomePage homePage = new HomePage();

    public String getCustomerFirstName () {
        return testCustomer.getFirstName();
    }
    public String getCustomerLastName () {
        return testCustomer.getLastName();
    }
    public String getCustomerPostCode () {
        return testCustomer.getPostCode();
    }
    String customerAccountID;
    String[] customerMultipleAccountsID = {"","",""};

    public void createCustomer() {

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
                .clickProcessBtn();

        var openAccountAlert = switchTo().alert();
        this.customerAccountID = openAccountAlert.getText().replaceAll("[^0-9]", "");
        openAccountAlert.accept();
        homePage.clickHomeBtn();
    }
    public void createCustomerForAccountsCheck() {

        homePage.clickManagerLoginBtn();

        new ManagerAddCustomerPage()
                .openAddCustomerPage()
                .enterCustomerFirstName(testCustomer.getFirstName())
                .enterCustomerLastName(testCustomer.getLastName())
                .enterRandomCustomerPostCode(testCustomer.getPostCode())
                .clickCustomerSubmitBtn();

        ManagerOpenAccountPage openAccountPage = new ManagerOpenAccountPage();
                openAccountPage.openCreateAccountPage();
                for(int i = 0; i <= 2; i++ ) {
                    openAccountPage.chooseCreatedCustomer(testCustomer.getFirstName());
                    switch (i) {
                        case 0 -> openAccountPage.chooseCustomerCurrency(DOLLAR.getCurrency());
                        case 1 -> openAccountPage.chooseCustomerCurrency(POUND.getCurrency());
                        case 2 -> openAccountPage.chooseCustomerCurrency(RUPEE.getCurrency());
                    }
                    openAccountPage.clickProcessBtn();
                    var openAccountAlert = switchTo().alert();
                    this.customerMultipleAccountsID[i] = openAccountAlert.getText().replaceAll("[^0-9]", "");
                    openAccountAlert.accept();
                }
        homePage.clickHomeBtn();
    }
    public void deleteCustomer () {
        ManagerCustomersPage customersPage = new ManagerCustomersPage();

        if(!customersPage.isCustomersSearchVisible()){
            customersPage.clickHomeBtn();
            homePage.clickManagerLoginBtn();
        }
        customersPage.openCustomersPage();
        customersPage.deleteCustomerByFirstAndLastName(testCustomer.getFirstName(), testCustomer.getLastName());
    }
}