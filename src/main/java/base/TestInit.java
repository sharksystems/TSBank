package base;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.codeborne.selenide.Configuration;
import static com.codeborne.selenide.Selenide.*;

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
