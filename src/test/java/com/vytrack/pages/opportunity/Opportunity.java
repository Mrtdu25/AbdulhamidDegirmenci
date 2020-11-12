package com.vytrack.pages.opportunity;

import com.vytrack.pages.BaseP;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Opportunity extends BaseP {

    //label[contains(text(),'Opportunity name')]
    @FindBy(id = "select2-drop-mask")
    private WebElement mask;

    @FindBy(xpath = "//span[contains(text(),'Choose an account')]")
    private WebElement chooseAccount;

    @FindBy(xpath = "(//input[@class='select2-input'])[4]")
    private WebElement inputAccount;
////i[@class='fa-bars hide-text']
    //a[class='add-on btn entity-select-btn']
    @FindBy(xpath = "(//a[@href='javascript: void(0);'])[2]")
    private WebElement inputAccountBtn;

    public void sendAccountText(String str){
        BrowserUtils.enterText(inputAccount,str);
    }


    public void clickOnAccountBtn(){
        BrowserUtils.clickWithJS(inputAccountBtn);
        //BrowserUtils.clickOnElement(inputAccountBtn);
        BrowserUtils.wait(2);
    }

    public void enterInfo(String where, String info){
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'" + where + "')]/../following-sibling::div/input"));
        BrowserUtils.enterText(element,info);                        //label[contains(text(),'Probability (%)')]/../following-sibling::div/input
    }

    public void enterInfo(String where, double number){
                                                                    // (//label[contains(text(),'')]/../following-sibling::div/div/div/input)[1]
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'" + where + "')]/../following-sibling::div/input"));
        BrowserUtils.enterText(element,""+number);

    }

    public void enterMoney(String where, double number){
        // (//label[contains(text(),'')]/../following-sibling::div/div/div/input)[1]
        WebElement element = Driver.getDriver().findElement(By.xpath("(//label[contains(text(),'"+where+"')]/../following-sibling::div/div/div/input)[1]"));
        BrowserUtils.enterText(element,""+number);

    }

    public void clickOnChooseAccount(){
        BrowserUtils.clickOnElement(chooseAccount);
    }

    public void requiredFieldMessage(String field, String expMessage){
        WebElement message = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'"+field+"')]/../following-sibling::div/input/following-sibling::span/span"));
        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(expMessage,message.getText());
    }



}
