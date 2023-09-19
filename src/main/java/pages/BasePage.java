package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    private final By mainHeadingTxt = By.xpath("//strong[@class='mainHeading']");
    private final By homeBtn = By.xpath("//button[@class='btn home']");
    private final By logoutBtn = By.xpath("//button[@class='btn logout']");

    public void clickHomeBtn () {$(homeBtn).shouldBe(Condition.visible).click();}
    public void clickLogoutBtn () {$(logoutBtn).shouldBe(Condition.visible).click();}
}
