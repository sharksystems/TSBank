package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;
import static pages.HomePage.*;
import static pages.MainHeadPage.*;

public class Test1 extends base.TestInit {

    @Test
    public void checkLoginPage() {

        assertTrue($(customerLoginBtn).shouldBe(visible).isDisplayed(),"customer btn not found");
        assertTrue($(managerLoginBtn).shouldBe(visible).isDisplayed(),"manager btn not found");
    }

    @Test
    public void checkMainHeader() {
//        new MainHeadPage()
//                .clickHomeBtn()
//                .clickLogoutBtn();

        assertTrue($(mainHeadingTxt).isDisplayed(),"main heading not found");
        assertTrue($(homeBtn).isDisplayed(),"home btn not found");
        assertTrue($(logoutBtn).isDisplayed(),"logout btn not found");

    }
}
