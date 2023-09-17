package pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class ManagerOpenAccountPage extends BasePage<ManagerOpenAccountPage> {

    ManagerMainPage managerMainPage = new ManagerMainPage();

    public final By customerSelectField = By.xpath("//select[@id='userSelect']");
    public final By currencySelectField = By.xpath("//select[@id='currency']");
    public final By accountProcessBtn = By.xpath("//button[@type='submit' and contains(text(), 'Process')]");
    public final By customerSelectLabel = By.xpath("//select[@id='userSelect']/preceding-sibling::label");
    public final By currencySelectLabel = By.xpath("//select[@id='currency']/preceding-sibling::label");

    public ManagerOpenAccountPage openCreateAccountPage() {
        managerMainPage.clickOpenAccountBtn();
        return this;
    }

    public ManagerOpenAccountPage chooseCreatedCustomer(String name) {
        $(customerSelectField).shouldBe(visible).selectOptionContainingText(name);
        return this;
    }

    public ManagerOpenAccountPage chooseCustomerCurrency(String currency) {
        $(currencySelectField).shouldBe(visible).selectOptionByValue(currency);
        return this;
    }

    public ManagerOpenAccountPage clickProcessBtn() {
        $(accountProcessBtn).shouldBe(enabled).click();
        return this;
    }

    public ManagerOpenAccountPage assertOpenAccountElementsVisible() {
        assertTrue($(customerSelectField).shouldBe(visible).isDisplayed(), "customer select field not found");
        assertTrue($(currencySelectField).shouldBe(visible).isDisplayed(), "currency select field not found");
        assertTrue($(accountProcessBtn).shouldBe(visible).isDisplayed(), "process btn not found");
        assertTrue($(customerSelectLabel).shouldBe(visible).isDisplayed(), "customer select label not found");
        assertTrue($(currencySelectLabel).shouldBe(visible).isDisplayed(), "currency select label not found");
        return this;
    }
}
