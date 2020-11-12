package com.vytrack.pages.contacts;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContacts extends Contacts{


    //(//label[contains(text(),'Emails')])[1]

    @FindBy(css = "[type='email']")
    private WebElement emailInput;

    @FindBy(css = "[data-name='field__phone']")
    private WebElement phoneInput;


    public void enterPersonsPhone(String phoneNumber){
        BrowserUtils.enterText(phoneInput,phoneNumber);
    }

    public void enterPersonsEmail(String email){
        BrowserUtils.enterText(emailInput,email);
    }

    public void enterPersonsInfo(String type, String data){

        WebElement inputField = Driver.getDriver().findElement(By.xpath("(//label[contains(text(),'"+type+"')])[1]/../following-sibling::div/input"));

        BrowserUtils.enterText(inputField,data);


    }

}
