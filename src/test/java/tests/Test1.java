package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManagerAddCustomerPage;
import pages.ManagerOpenAccountPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;
import static pages.HomePage.customerLoginBtn;
import static pages.HomePage.managerLoginBtn;
import static pages.MainHeadPage.*;
import static pages.ManagerMainPage.*;

public class Test1 extends base.TestInit {

    @Test
    public void checkManagerCustomerCreation() {
        //Create random credentials for user
        String randomFirstName = faker.name().firstName();
        String randomLastName = faker.name().lastName();
        String randomPostCode = faker.address().zipCode();

        //Go to Manager Login > Add Customer and create a new user with random credentials
        new HomePage().openManagerLoginBtn();
        $(addCustomerBtn).shouldBe(enabled).click();
        new ManagerAddCustomerPage()
                .enterCustomerFirstName(randomFirstName)
                .enterCustomerLastName(randomLastName)
                .enterRandomCustomerPostCode(randomPostCode)
                .clickCustomerSubmitBtn();
        confirm();
        //go to Open Account and fill the fields with the new user's credentials
        $(openAccountBtn).shouldBe(enabled).click();
        new ManagerOpenAccountPage()
                .chooseCreatedCustomer(randomFirstName)
                .chooseCustomerCurrency()
                .clickProcessBtn();
        //Get the account code from the Alert
        Alert openAccountAlert = switchTo().alert();
        String accountCode = openAccountAlert.getText().replaceAll("[^0-9]", "");
        openAccountAlert.accept();

        By accountCodeLocator = By.xpath("//td[contains(span, '" + accountCode + "')]");
        By customerNameLocator = By.xpath("//td[contains(text(), '" + randomFirstName + "')]");
        By customerPostCodeLocator = By.xpath("//td[contains(text(), '" + randomPostCode + "')]");
        //go to Customers and check if created user, account code and credentials are there
        $(showCustomersBtn).shouldBe(enabled).click();
        $(customerNameLocator).shouldBe(visible);
        $(accountCodeLocator).shouldBe(visible);
        $(customerPostCodeLocator).shouldBe(visible);
    }

    @Test
    public void checkLoginPage() {

        assertTrue($(customerLoginBtn).shouldBe(visible).isDisplayed(), "customer btn not found");
        assertTrue($(managerLoginBtn).shouldBe(visible).isDisplayed(), "manager btn not found");
    }

    @Test
    public void checkMainHeader() {
//        new MainHeadPage()
//                .clickHomeBtn()
//                .clickLogoutBtn();

        assertTrue($(mainHeadingTxt).isDisplayed(), "main heading not found");
        assertTrue($(homeBtn).isDisplayed(), "home btn not found");
        assertTrue($(logoutBtn).isDisplayed(), "logout btn not found");
    }
}
