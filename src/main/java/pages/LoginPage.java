package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends PageBase {

    public static final By customerLoginBtn = By.xpath("//div/button[@ng-click='customer()']");
    public static final By managerLoginBtn = By.xpath("//div/button[@ng-click='manager()']");

    public static SelenideElement findCustomerLoginBtn() {
        return $(customerLoginBtn).shouldBe(Condition.visible);
    }
    public static SelenideElement findManagerLoginBtn() {return $(managerLoginBtn).shouldBe(Condition.visible);}


}
