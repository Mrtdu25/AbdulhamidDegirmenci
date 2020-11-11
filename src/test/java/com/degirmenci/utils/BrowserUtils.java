package com.degirmenci.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    public static void clickWithJS(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) (Driver.getDriver())).executeScript("arguments[0].click()", element);
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

    public static void waitToSeeElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static boolean checkIfElementIsDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public static void waitForMaskToGoAway(List<WebElement> elements) {
        wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    public static void takeScreenshot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();

    }

}
