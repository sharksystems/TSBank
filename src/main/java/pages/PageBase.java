package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class PageBase {
//    WebDriver driver;
//    public PageBase (WebDriver driver) {this.driver = driver;}

    public final By homeBtn = By.xpath("//button[@class='btn home']");
    public final By logoutBtn = By.xpath("//button[@class='btn logout']");
    public final By mainHeadingTxt = By.xpath("//strong[@class='mainHeading']");

    public void clickHomeBtn () {$(homeBtn).shouldBe(Condition.visible).click();}
    public void clickLogoutBtn () {$(logoutBtn).shouldBe(Condition.visible).click();}
    public SelenideElement findMainHeadingTxt () { return $(mainHeadingTxt).shouldBe(Condition.visible);}
    public void findHomeBtn () {$(homeBtn).shouldBe(Condition.visible);}
    public void findLogoutBtn () {$(logoutBtn).shouldBe(Condition.visible);}
}
