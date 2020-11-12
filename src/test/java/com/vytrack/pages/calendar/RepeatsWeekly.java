package com.vytrack.pages.calendar;

import com.vytrack.pages.calendar.Repeat;
import com.vytrack.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RepeatsWeekly extends Repeat {
    @FindBy(css = "input[value='monday']")
    private WebElement mondayChkBox;

    @FindBy(css = "input[value='tuesday']")
    private WebElement tuesdayChkBox;

    @FindBy(css = "input[value='wednesday']")
    private WebElement wednesdayChkBox;

    @FindBy(css = "input[value='thursday']")
    private WebElement thursdayChkBox;

    @FindBy(css = "input[value='friday']")
    private WebElement fridayChkBox;

    @FindBy(css = "input[value='saturday']")
    private WebElement saturdayChkBox;

    @FindBy(css = "input[value='sunday']")
    private WebElement sundayChkBox;

    @FindBy(css = "input[name='recurrence[dayOfWeek]']")
    List<WebElement> daysOfWeek;


    public void selectingDays(String day1,String day2){
        for (WebElement each : daysOfWeek) {
            if (each.getAttribute("value").equalsIgnoreCase(day1)){
                BrowserUtils.clickOnElement(each);
            }
            if (each.getAttribute("value").equalsIgnoreCase(day2)){
                BrowserUtils.clickOnElement(each);
            }
        }
    }

    public boolean areOptionsSelected(String days){
        String[] arrDays = days.split(" ");
        boolean areSelected = false;
        boolean day1 = false;
        boolean day2 = false;

        for (WebElement each : daysOfWeek) {
            if (each.getAttribute("value").equalsIgnoreCase(arrDays[0])){
                day1 = each.isSelected();
            }
            if (each.getAttribute("value").equalsIgnoreCase(arrDays[2])){
                day2=each.isSelected();
            }
        }
        return areSelected=day1&&day2;
    }

}
