package com.vytrack.pages.opportunity;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountWindow extends Opportunity{



    public void selectAccount(String str){
        WebElement element = Driver.getDriver().findElement(By.xpath("//td[contains(text(),'" + str + "')]"));
        BrowserUtils.clickOnElement(element);
    }

    public boolean isMessageDisplayed(String str){
        WebElement message = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'" + str + "')]"));
        return message.isDisplayed();
    }


}
