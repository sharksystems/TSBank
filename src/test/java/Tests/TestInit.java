package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestInit {

    WebDriver driver;
    @BeforeMethod
    public void setup (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void bquit () {
        driver.quit();
    }
    public void goToSite (){
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

}
