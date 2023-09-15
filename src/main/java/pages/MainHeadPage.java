package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainHeadPage extends BasePage<MainHeadPage> {

    public static final By mainHeadingTxt = By.xpath("//strong[@class='mainHeading']");
    public static final By homeBtn = By.xpath("//button[@class='btn home']");
    public static final By logoutBtn = By.xpath("//button[@class='btn logout']");

    public MainHeadPage clickHomeBtn () {$(homeBtn).shouldBe(Condition.visible).click(); return this;}
    public MainHeadPage clickLogoutBtn () {$(logoutBtn).shouldBe(Condition.visible).click(); return this;}
}
