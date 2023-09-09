package tests;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.LoginPage;
import static pages.LoginPage.*;
import static pages.MainHeadPage.*;
import org.testng.annotations.Test;
import pages.MainHeadPage;
import static com.codeborne.selenide.Selenide.*;


public class Test1 extends base.TestInit {
    @Test
    public void checkLoginPage() {
        new LoginPage();
        goToSite();
        findCustomerLoginBtn();
        findManagerLoginBtn();

        Assert.assertTrue(findCustomerLoginBtn().isDisplayed());
        Assert.assertTrue(findCustomerLoginBtn().isEnabled());
        Assert.assertTrue(findManagerLoginBtn().isDisplayed());
        Assert.assertTrue(findManagerLoginBtn().isEnabled());
    }
    @Test
    public void checkMainHeader (){
        new MainHeadPage();
        goToSite();
        findMainHeadingTxt();
        findHomeBtn();

        Assert.assertTrue(findMainHeadingTxt().isDisplayed());
        Assert.assertTrue(findHomeBtn().isDisplayed());
        Assert.assertTrue(findHomeBtn().isEnabled());
    }

}
