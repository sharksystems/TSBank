package pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ManagerOpenAccountPage extends BasePage<BasePage>{


    public static final By customerSelectField = By.xpath("//select[@id='userSelect']");
    public static final By currencySelectField = By.xpath("//select[@id='currency']");
    public static final By accountProcessBtn = By.xpath("//button[@type='submit' and contains(text(), 'Process')]");

    public ManagerOpenAccountPage chooseCreatedCustomer (String name) {
        $(customerSelectField).shouldBe(visible).selectOptionContainingText(name);
        return this;
    }
    public ManagerOpenAccountPage chooseCustomerCurrency () {
        $(currencySelectField).shouldBe(visible).selectOptionByValue("Rupee");
        return this;
    }
    public ManagerOpenAccountPage clickProcessBtn() {
        $(accountProcessBtn).shouldBe(enabled).click();
        return this;
    }
}
