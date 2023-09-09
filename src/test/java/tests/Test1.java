package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;


public class Test1 extends base.TestInit {
    @Test
    public void checkLoginPage() {
        LoginPage loginPage = new LoginPage();
        goToSite();
        loginPage.findCustomerLoginBtn();
        loginPage.findManagerLoginBtn();

        Assert.assertTrue(loginPage.findCustomerLoginBtn().isDisplayed());
        Assert.assertTrue(loginPage.findCustomerLoginBtn().isEnabled());
        Assert.assertTrue(loginPage.findManagerLoginBtn().isDisplayed());
        Assert.assertTrue(loginPage.findManagerLoginBtn().isEnabled());
    }
    @Test
    public void checkMainHeader (){
        LoginPage loginPage = new LoginPage();
        goToSite();
        loginPage.findMainHeadingTxt();
        loginPage.clickHomeBtn();

        Assert.assertTrue($(loginPage.mainHeadingTxt).isDisplayed());
        Assert.assertTrue($(loginPage.homeBtn).isDisplayed());
        Assert.assertTrue($(loginPage.homeBtn).isEnabled());
    }

}
