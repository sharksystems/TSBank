package pages;

import org.openqa.selenium.By;

public class ManagerMainPage extends BasePage<BasePage> {

    public static final By addCustomerBtn = new By.ByXPath("//button[@ng-click='addCust()']");
    public static final By openAccountBtn = new By.ByXPath("//button[@ng-click='openAccount()']");
    public static final By showCustomersBtn = new By.ByXPath("//button[@ng-click='showCust()']");

}
