package com.vytrack.pages.calendar;

import com.vytrack.pages.calendar.CalendarEventsPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CreateCalendarEventPage extends CalendarEventsPage {

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


    @FindBy(xpath = "//input[contains(@id, 'time_selector_oro_calendar_event_form_start')]")
    private WebElement startTime;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_oro_calendar_event_form_start')]")
    private WebElement startDate;

    @FindBy(xpath = "//input[contains(@id, 'time_selector_oro_calendar_event_form_end')]")
    private WebElement endTime;

    @FindBy(xpath = "//input[contains(@id, 'date_selector_oro_calendar_event_form_end')]")
    private WebElement endDate;

    @FindBy(xpath = "//body/div[6]/ul/li[1]")
    private WebElement pickedTime;

    @FindBy(xpath = "//li[contains(@class,'timepicker-selected')]")
    private WebElement pickedTime2;

    @FindBy(xpath = "//body/div[6]/ul/li")
    private List<WebElement> startTimeOptions;

    @FindBy(xpath = "/html/body/div[9]/ul/li[3]")
    private WebElement endTimeSelected;

    @FindBy(xpath = "//input[contains(@id, 'oro_calendar_event_form_allDay')]")
    private WebElement allDayEventChkBox;

    @FindBy(xpath = "//input[contains(@id,'recurrence')]")
    private WebElement repeatChkBox;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    private WebElement saveAndClose;

    @FindBy(xpath = "//label[contains(text(),'End')]/following-sibling::div//div")
    private WebElement savedEventEndingTime;



    public boolean areStartAndEndDateBoxesDisplayed(){
        if (startDate.isDisplayed() && endDate.isDisplayed()){
            return true;
        }else{
            return false;
        }
    }

    public boolean areStartTimeAndEndTimeBoxesDisplayed(){
        if (startTime.isDisplayed() && endTimeSelected.isDisplayed()) {
            return true;
        }else {
            return false;
        }
    }

    public void selectChkBox (String str) {
        waitForLoading();
        js.executeScript("arguments[0].scrollIntoView(true)",startTime);
        if (str.equalsIgnoreCase("All-Day Event")){
            BrowserUtils.clickOnElement(allDayEventChkBox);
        }else if (str.equalsIgnoreCase("Repeat")){
            BrowserUtils.clickOnElement(repeatChkBox);
        }else {
            throw new RuntimeException("invalid checkbox");
        }
    }

    public void selectAllDayChkBox(){
        waitForLoading();
        BrowserUtils.clickOnElement(allDayEventChkBox);
    }

    public boolean isAllDayChkBoxSelected(){
        return allDayEventChkBox.isSelected();
    }

    public void  isChkBoxSelected(String str) {
        if (str.equalsIgnoreCase("All-Day Event”")){
            Assert.assertTrue(allDayEventChkBox.isSelected());
        }else if (str.equalsIgnoreCase("Repeat")){
            Assert.assertTrue(repeatChkBox.isSelected());
        }else {
            throw new RuntimeException("invalid checkbox");
        }
    }

    public void clickOnSaveAndClose(){
        BrowserUtils.clickOnElement(saveAndClose);
    }

    public String endingTimeOfSavedEvent(){
        return savedEventEndingTime.getText();
    }

    public void clickOnAllDayEventChkBox(){
        BrowserUtils.clickOnElement(allDayEventChkBox);
    }

    public void selectingStartTime(String start){
        waitForLoading();
        js.executeScript("arguments[0].scrollIntoView(true)",startTime);
        BrowserUtils.clickOnElement(startTime);
        for (WebElement each : startTimeOptions) {
            if (each.getText().equalsIgnoreCase(start)) {
                BrowserUtils.clickOnElement(each);
                return;
            }
        }
    }

    public void endingTime(String str){

        enterTitleText("testing");
        clickOnSaveAndClose();
        waitForLoading();
        Assert.assertTrue(endingTimeOfSavedEvent().contains(str));

    }


    public void meetingLastingTime(Integer n){
        String startingTime="";
        String endingTime="";
        int start = 0;
        int end = 0;
        waitForLoading();
        BrowserUtils.clickOnElement(endTime);
        endingTime = pickedTime2.getText();
        startingTime = pickedTime.getText();
        System.out.println("endingTime = " + endingTime);
        System.out.println("startingTime = " + startingTime);

        endingTime = endingTime.replace(":","").substring(0,endingTime.length()-4);
        startingTime = startingTime.replace(":","").substring(0,startingTime.length()-4);
        end = Integer.parseInt(endingTime);
        start = Integer.parseInt(startingTime);



        Integer time = (end-start);
        if (time==-1100){
            n-=1101;
        }else {
            n = n * 100;
        }
        System.out.println("time = " + time);
        Assert.assertEquals(n,time);


    }
}
