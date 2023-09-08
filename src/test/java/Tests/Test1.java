package Tests;

import PageObjects.LoginPage;
import org.testng.annotations.Test;

public class Test1 extends TestInit{

    @Test
    public void checkLogin () {
        LoginPage loginPage = new LoginPage(driver);
        goToSite();

    }

}
