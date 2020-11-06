package com.degirmenci.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    private static WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);


  // wait
    public static void wait(int second){

        try {
            Thread.sleep(1000*second);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Wait not successful");
        }

    }

    //clicks on element
    public static void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    //Enters text
    public static void enterText(WebElement element,String text){

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
        wait.until(ExpectedConditions.attributeToBe(element,"value",text));

        System.out.println("Entering text "+text);


    }



}
