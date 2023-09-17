package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class MainHeadPage extends BasePage<MainHeadPage> {

    public final By mainHeadingTxt = By.xpath("//strong[@class='mainHeading']");
    public final By homeBtn = By.xpath("//button[@class='btn home']");
    public final By logoutBtn = By.xpath("//button[@class='btn logout']");

    public MainHeadPage clickHomeBtn () {$(homeBtn).shouldBe(Condition.visible).click(); return this;}
    public MainHeadPage clickLogoutBtn () {$(logoutBtn).shouldBe(Condition.visible).click(); return this;}

    public MainHeadPage assertMainHeadElementsVisible () {
        //preconditions: logged in as customer or manager
        assertTrue($(mainHeadingTxt).isDisplayed(), "main heading not found");
        assertTrue($(homeBtn).isDisplayed(), "home btn not found");
        assertTrue($(logoutBtn).isDisplayed(), "logout btn not found");
        return this;
    }

}
