package pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class ManagerOpenAccountPage extends ManagerPageElements {

    private final By customerSelectField = By.xpath("//select[@id='userSelect']");
    private final By currencySelectField = By.xpath("//select[@id='currency']");
    private final By accountProcessBtn = By.xpath("//button[@type='submit' and contains(text(), 'Process')]");
    private final By customerSelectLabel = By.xpath("//select[@id='userSelect']/preceding-sibling::label");
    private final By currencySelectLabel = By.xpath("//select[@id='currency']/preceding-sibling::label");

    public ManagerOpenAccountPage openCreateAccountPage() {
        clickOpenAccountBtn();
        return this;
    }

    public ManagerOpenAccountPage chooseCreatedCustomer(String name) {
        $(customerSelectField).shouldBe(enabled).selectOptionContainingText(name);
        return this;
    }

    public ManagerOpenAccountPage chooseCustomerCurrency(String currency) {
        $(currencySelectField).shouldBe(enabled).selectOptionByValue(currency);
        return this;
    }

    public ManagerOpenAccountPage clickProcessBtn() {
        $(accountProcessBtn).shouldBe(enabled).click();
        return this;
    }
}
