package com.vytrack.pages.calendar;

import com.vytrack.pages.BaseP;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalendarEventsPage extends BaseP {

    @FindBy(xpath = "//a[@title='Create Calendar event']")
    private WebElement createEventBtn;

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBox;

    @FindBy(tagName = "iframe")
    private WebElement iframeElement;

    @FindBy(xpath = "//tbody//tr//td[2]")
    private List<WebElement> meetingTitles;

    @FindBy(xpath = "//tbody//tr//td[9]")
    private List<WebElement> threeDots;

    @FindBy(xpath = "//*[@title='View']")
    private WebElement eyeIcon;

    @FindBy(xpath = "//*[@title='Edit']")
    private WebElement editIcon;

    @FindBy(xpath = "//*[@title='Delete']")
    private WebElement deleteIcon;

    @FindBy(css = "a[title='Grid Settings']")
    private WebElement settingsBtn;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td/input")
    private List<WebElement> gridOptionsCheckBoxes;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr/td/label")
    private List<WebElement> gridOptionsTitles;

    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    private WebElement saveAndCloseOptBtn;

    @FindBy(xpath = "//div[@class='pull-right pinned-dropdown']//ul[1]//li[1]//button")
    private WebElement saveAndCloseOption;

    @FindBy(xpath = "//div[@class='pull-right pinned-dropdown']//ul[1]//li[2]//button")
    private WebElement saveAndNewOption;

    @FindBy(xpath = "//div[@class='pull-right pinned-dropdown']//ul[1]//li[3]//button")
    private WebElement saveOption;

    @FindBy(xpath = "//a[@title='Cancel']")
    private WebElement cancelBtn;





    public void clickCancelBtn(){
        BrowserUtils.clickOnElement(cancelBtn);
    }

    public void createCalendarEventBtnIsDisplayed(){
        BrowserUtils.checkIfElementIsDisplayed(createEventBtn);
    }


    public void saveAndCloseOptionsAvailable(String sc,String sn,String s){

        if (BrowserUtils.checkIfElementIsDisplayed(saveAndCloseOption)){
            Assert.assertEquals(sc,saveAndCloseOption.getText());
            Assert.assertEquals(sn,saveAndNewOption.getText());
            Assert.assertEquals(s,saveOption.getText());
            return;
        }else {
            throw new RuntimeException("Save and Close Options are not matching");
        }
    }


    public void clickOnSaveAndCloseOptionsBtn(){
        BrowserUtils.clickOnElement(saveAndCloseOptBtn);
    }

    public void checkIfOptionIsSelected(String str){
        String s = "";
        for (WebElement each : gridOptionsTitles) {
            if (!each.getText().equals(str)){
                continue;
            }
            s=each.getAttribute("for");
        }
        for (WebElement each : gridOptionsCheckBoxes){
            if (!each.getAttribute("id").equals(s)){
                continue;
            }
            Assert.assertTrue(each.isSelected());
            return;
        }
        throw new RuntimeException("option wasn't found");
    }

    public void deselectingOptions(String str){
        for (WebElement each : gridOptionsTitles) {
            if (each.getText().equals(str)){
                continue;
            }
            BrowserUtils.clickOnElement(each);
        }
    }



    public void clickOnSettings(){
        BrowserUtils.clickOnElement(settingsBtn);
    }

    public void optionsDisp(String view,String edit, String delete){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(eyeIcon));


        Assert.assertEquals(view,eyeIcon.getAttribute("title"));
        Assert.assertEquals(edit,editIcon.getAttribute("title"));
        Assert.assertEquals(delete,deleteIcon.getAttribute("title"));

    }



    public boolean eyeIconDisplayed(){
        return eyeIcon.isDisplayed();
    }
    public boolean editIconDisplayed(){
        return editIcon.isDisplayed();
    }
    public boolean deleteIconDisplayed(){
        return deleteIcon.isDisplayed();
    }




    public void hoverOverElement(String str) {
        Actions actions = new Actions(Driver.getDriver());
        for (WebElement each : meetingTitles) {
            if (each.getText().equalsIgnoreCase(str)){
                actions.moveToElement(each).perform();
                break;
            }
        }

    }

    public void hoverOverDots(String str){
        BrowserUtils.wait(2);
        Actions actions = new Actions(Driver.getDriver());
        WebElement dots = Driver.getDriver().findElement(By.xpath("//td[.='"+str+"']/following-sibling::td[7]"));
        actions.moveToElement(dots).perform();

    }


    public String getInfo(String parameterName){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        String xpath = "//label[text()='" + parameterName + "']/../div/div";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();

    }

    public void enterTitleText(String text){
        Driver.getDriver().switchTo().defaultContent();
        BrowserUtils.enterText(titleInputBox,text);
    }


    public void  enterDescriptionText(String text){
        BrowserUtils.wait(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        Driver.getDriver().switchTo().defaultContent();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
        descriptionInputBox.sendKeys(text);
        Driver.getDriver().switchTo().defaultContent();


    }


    public void clickOnCreateCalendarEvent(){
        BrowserUtils.wait(3);
        BrowserUtils.clickOnElement(createEventBtn);
        BrowserUtils.wait(3);
    }



}
