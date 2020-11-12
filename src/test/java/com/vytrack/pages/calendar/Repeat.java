package com.vytrack.pages.calendar;

import com.vytrack.pages.calendar.CreateCalendarEventPage;
import com.vytrack.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Repeat extends CreateCalendarEventPage {
    @FindBy(xpath = "//select[contains(@id,'recurrence-repeats-view')]")
    private WebElement repeatsDropdown;
    Select select = new Select(repeatsDropdown);

    @FindBy(xpath = "//input[@checked='checked']")
    private WebElement repeatEveryBtn;

    @FindBy(xpath = "//label[contains(text(),'Ends')]")
    private  WebElement labelEnds;

    @FindBy(xpath = "//span[contains(text(),'Never')]")
    private WebElement labelNever;

    @FindBy(xpath = "//span[contains(text(),'Never')]/preceding-sibling::input")
    private WebElement neverChkBtn;

    @FindBy(xpath = "//label[contains(text(),'Summary:')]/../following-sibling::div/div/span")
    private WebElement summaryMessage;



    @FindBy(xpath = "//label[contains(text(),'Summary:')]")
    private WebElement summaryLabel;

    @FindBy(xpath = "//span[.='occurrences']/preceding-sibling::input[1]")
    private WebElement afterBox;

    @FindBy(xpath = "//span[.='occurrences']/preceding-sibling::input[2]")
    private WebElement afterRadio;

    @FindBy(xpath = "//span[.='By']/../following-sibling::span/div/input[2]")
    private WebElement byDate;

    @FindBy(xpath = "//span[.='By']/..//preceding-sibling::input[1]")
    private WebElement byRadio;

    public void selectingRepeatingOptions(String option, String dropdown){
        if (dropdown.equalsIgnoreCase("Repeat")){
            select.selectByVisibleText(option);
        }
    }

    public void setByDate(String str){
        str=str.substring(3);
        BrowserUtils.clickOnElement(byRadio);
        byDate.clear();
        byDate.sendKeys(str+ Keys.ENTER);
        //BrowserUtils.enterText(byDate,str);
    }

    public void setOccurrences(int n){
        BrowserUtils.clickOnElement(afterRadio);
        BrowserUtils.enterText(afterBox,""+n);
        BrowserUtils.clickOnElement(neverChkBtn);
        BrowserUtils.clickOnElement(afterRadio);

    }


    public boolean neverChkBtnIsSelected(){
        return neverChkBtn.isSelected();
    }


    public String summaryMessageIs(){
            return summaryLabel.getText() + " " + summaryMessage.getText();
    }






    public boolean repeatEveryBtnIsSelected(){
        return repeatEveryBtn.isSelected();
    }

    public String selectedRepeatsOption(){
        return select.getFirstSelectedOption().getText();
    }

    public void selectOptions(){
        List<WebElement> options = select.getOptions();
        String opt = "";

        for (WebElement each : options) {
            opt+=each.getText();
        }
        Assert.assertEquals("DailyWeeklyMonthlyYearly",opt);
        System.out.println(opt);
    }

}
