package base;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestInit {

    @BeforeMethod
    public void setupDriver (){
        Configuration.browser = "chrome";
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @AfterMethod
    public void tearDownDriver() {
       closeWebDriver();
    }

}
