package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainHeadPage extends PageBase {
    public static final By homeBtn = By.xpath("//button[@class='btn home']");
    public static final By logoutBtn = By.xpath("//button[@class='btn logout']");
    public static final By mainHeadingTxt = By.xpath("//strong[@class='mainHeading']");


    public static void clickHomeBtn () {$(homeBtn).shouldBe(Condition.visible).click();}
    public static void clickLogoutBtn () {$(logoutBtn).shouldBe(Condition.visible).click();}
    public static SelenideElement findMainHeadingTxt () { return $(mainHeadingTxt).shouldBe(Condition.visible);}
    public static SelenideElement findHomeBtn () { return $(homeBtn).shouldBe(Condition.visible);}
    public static SelenideElement findLogoutBtn () {return $(logoutBtn).shouldBe(Condition.visible);}
}
