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

//    public WebDriver driver;
    @BeforeMethod
    public void setup (){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        WebDriverRunner.setWebDriver(driver);
        Configuration.browser = "chrome";
    }
    @AfterMethod
    public void tearDownDriver() {
       closeWebDriver();
    }

    public void goToSite (){
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }



}
