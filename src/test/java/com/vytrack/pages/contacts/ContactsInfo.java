package com.vytrack.pages.contacts;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsInfo extends Contacts{

    ////div[@class='sub-title']/following-sibling::h1
    ////label[contains(text(),'Job Title')]/following-sibling::div/div

    @FindBy(css = "[class='user-name']")
    private WebElement fullName;

    @FindBy(xpath = "(//label[contains(text(),'Phones')]/following-sibling::div/div/ul/li/span/span/a)[1]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//label[contains(text(),'Job Title')]/following-sibling::div//div")
    private WebElement personsJobTitle;




    public String getElementText(String text){
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'"+text+"')]/following-sibling::div/div"));
        return element.getText();
    }

    public boolean elementIsDisplayed(String text){
        WebElement element = Driver.getDriver().findElement(By.cssSelector("[value='"+text+"']"));
        return BrowserUtils.checkIfElementIsDisplayed(element);
    }

    public boolean infoElementIsDisplayed(String text){
        WebElement element = Driver.getDriver().findElement(By.xpath("//div[.='"+text+"']"));
        return BrowserUtils.checkIfElementIsDisplayed(element);
    }


    public boolean socialMediaIsDisplayed(String text){
        WebElement element = Driver.getDriver().findElement(By.cssSelector("a[title='"+text+"']"));
        return BrowserUtils.checkIfElementIsDisplayed(element);
    }



    public String getFullName(){
        return  fullName.getText();
    }

    public String getPhone(){
        return phoneNumber.getText();
    }

    public boolean phoneNumberIsDisplayed(String number){
        WebElement phoneNum = Driver.getDriver().findElement(By.linkText(number));
        return BrowserUtils.checkIfElementIsDisplayed(phoneNum);
    }

    public boolean emailIsDisplayed(String email){
        WebElement phoneNum = Driver.getDriver().findElement(By.linkText(email));
        return BrowserUtils.checkIfElementIsDisplayed(phoneNum);
    }






}
