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