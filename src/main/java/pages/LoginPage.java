package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PageBase;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageBase {
//    WebDriver driver;
//    public LoginPage (WebDriver driver) {super(driver);}
    public final By customerLoginBtn = By.xpath("//div/button[@ng-click='customer()']");
    public final By managerLoginBtn = By.xpath("//div/button[@ng-click='manager()']");
    public SelenideElement findCustomerLoginBtn () {
        return $(customerLoginBtn).shouldBe(Condition.visible);
    }
    public SelenideElement findManagerLoginBtn () {
        return $(managerLoginBtn).shouldBe(Condition.visible);
    }


}
