package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BaseP{

    @FindBy(css = "i[class='fa-suitcase']")
    private WebElement accounts;

    @FindBy(css = "i[class='fa-group']")
    private WebElement contacts;

    @FindBy(css = "i[class='fa-usd']")
    private WebElement opportunities;

    public void clickOn(String icon){
        WebElement selectedIcon = Driver.getDriver().findElement(By.xpath("//i[@class='fa-"+icon+"']/../following-sibling::a"));
        BrowserUtils.clickOnElement(selectedIcon);
    }

    public boolean isIconDisplayed(String icon){
        WebElement iconQ = Driver.getDriver().findElement(By.xpath("//i[@class='fa-" + icon + "']"));
        return BrowserUtils.checkIfElementIsDisplayed(iconQ);
    }



}
