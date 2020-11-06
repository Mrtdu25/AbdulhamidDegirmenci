package com.degirmenci.pages;

import com.degirmenci.utils.BrowserUtils;
import com.degirmenci.utils.Driver;
import org.junit.Assert;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.ldap.PagedResultsControl;
import java.util.List;


public class CalenderEventPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEventBtn;

    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBox;

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    @FindBy(tagName = "iframe")
    private WebElement iframeElement;


    @FindBy(xpath = "//*[@title='View']")
    public WebElement threeDot_view;

    @FindBy(xpath = "//*[@title='Edit']")
    public WebElement threeDot_edit;

    @FindBy(xpath = "//*[@title='Delete']")
    public WebElement threeDot_delete;

    @FindBy(xpath = "//div[@class='column-manager dropdown']")
    private WebElement gridOptions;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[1]/td[3]/input")
    private WebElement gridOptions_titleBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[2]/td[3]/input")
    private WebElement gridOptions_calendarBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[3]/td[3]/input")
    private WebElement gridOptions_startBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[4]/td[3]/input")
    private WebElement gridOptions_endBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[5]/td[3]/input")
    private WebElement gridOptions_recurrentBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[6]/td[3]/input")
    private WebElement gridOptions_recurrenceBox;

    @FindBy(xpath = "//tbody[@class='ui-sortable']/tr[7]/td[3]/input")
    private WebElement gridOptions_invitationBox;

    @FindBy(xpath = "//a[@class=\"btn-success btn dropdown-toggle\"]")
    private WebElement saveAndCloseDropdownBtn;

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle ']//h1")
    private WebElement allCalenderEventsSubtitle;

    @FindBy(xpath = "//input[starts-with(@id,'time_selector_oro_calendar_event_form_start')]")
    public WebElement startsTimeInput;

    @FindBy(xpath = "//input[starts-with(@id,'time_selector_oro_calendar_event_form_end')]")
    public WebElement endTimeInput;

    @FindBy(xpath = "//input[starts-with(@id,'date_selector_oro_calendar_event_form_start')]")
    private WebElement startDateInput;

    @FindBy(xpath = "//input[starts-with(@id,'date_selector_oro_calendar_event_form_end')]")
    private WebElement endDateInput;

    @FindBy(name = "oro_calendar_event_form[allDay]")
    private WebElement allDayEventCheckBox;

    @FindBy(xpath = "//select[@class='recurrence-repeats__select']")
    private WebElement repeatsSelectBtn;

    @FindBy(xpath = "//div[@class='recurrence-subview-control__item'][1]")
    private WebElement repeatEveryRadioButton;

    @FindBy(xpath = "//div[@data-name='recurrence-summary']")
    private WebElement summaryMessage;

    @FindBy(xpath = "//span[contains(text(),'After')]")
    private WebElement afterCheckBox;

    @FindBy(xpath = "//input[@data-related-field='occurrences']")
    private WebElement occurrencesInput;











    public void clickOnCreateCalenderEvent(){

        BrowserUtils.clickOnElement(createCalendarEventBtn);
    }

    public void enterTitle(String text){

        BrowserUtils.enterText(titleInputBox,text);

    }

    public void enterDescription(String text){

        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
        Driver.getDriver().switchTo().defaultContent();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
        descriptionInputBox.sendKeys(text);

        Driver.getDriver().switchTo().defaultContent();

    }

    public String getDataFromGeneralInfo(String parameterName) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String xpath = "//label[contains(text(),'"+parameterName+"')]/../div/div";
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();
    }

    public void hoverOnTheThreeDots(String str){

        Actions actions = new Actions(Driver.getDriver());
        WebElement dots = Driver.getDriver().findElement(By.xpath("//td[.='"+str+"']/following-sibling::td[7]"));
        actions.moveToElement(dots).perform();

    }


    public void optionsDisp(String view,String edit, String delete){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(threeDot_view));

        String viewText = threeDot_view.getText().trim();
        String editText = threeDot_edit.getText().trim();
        String deleteText=threeDot_delete.getText().trim();

        Assert.assertEquals(viewText,view);
        Assert.assertEquals(editText,edit);
        Assert.assertEquals(deleteText,delete);

    }




    public void clickOnGridOptions(){
        BrowserUtils.clickOnElement(gridOptions);
    }

    public void deselectAllOptionExceptTitle(){

        Assert.assertTrue(gridOptions_titleBox.isSelected());

        gridOptions_calendarBox.click();
        Assert.assertTrue(gridOptions_calendarBox.isEnabled());

        gridOptions_startBox.click();
        Assert.assertTrue(gridOptions_startBox.isEnabled());

        gridOptions_endBox.click();
        Assert.assertTrue(gridOptions_endBox.isEnabled());

        gridOptions_recurrentBox.click();
        Assert.assertTrue(gridOptions_recurrentBox.isEnabled());

        gridOptions_recurrenceBox.click();
        Assert.assertTrue(gridOptions_recurrenceBox.isEnabled());

        gridOptions_invitationBox.click();
        Assert.assertTrue(gridOptions_invitationBox.isEnabled());


    }


    public void titleIsDisplayed(){

        Assert.assertTrue(gridOptions_titleBox.isDisplayed());

    }

    //TC3
    public void clickOnSaveAndCloseDropdown(){

        BrowserUtils.clickOnElement(saveAndCloseDropdownBtn);

    }

    public void verifyThatSaveAndCloseDropdownOptionsAvailable(String dropdownOption){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        String xpath="//*[contains(text(),'"+dropdownOption+"')]";

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        Assert.assertTrue(dropdown.isDisplayed());

    }

    public String allCalenderEventsSubtitleGetText(){
        BrowserUtils.wait(2);
        return allCalenderEventsSubtitle.getText().trim();
    }

   //TC6
    public void selectStartTime(String timeValue){

        BrowserUtils.clickOnElement(startsTimeInput);
        WebElement time = Driver.getDriver().findElement(By.xpath("//li[contains(text(),'"+timeValue+"')]"));
        time.click();
        titleInputBox.click();


    }

    public String endTimeSubtitleGetText(String timeValue){

        WebElement time = Driver.getDriver().findElement(By.xpath("//li[contains(text(),'"+timeValue+"')]"));

        return time.getText().trim();

    }




    //TC7
    public void clickOnAllDayEventCheckBox(String text){
        WebElement checkbox = Driver.getDriver().findElement(By.xpath("//label[contains(text(),'"+text+"')]"));

        BrowserUtils.clickOnElement(checkbox);
    }

    public void checkboxIsSelected(String checkBoxName){

        if (allDayEventCheckBox.isSelected()){
            System.out.println(checkBoxName);
        }else {
            System.out.println(checkBoxName+"is NOT selected");
        }

    }

    public boolean verifyThatStartAndEndTimeBoxAreNotDisplayed(){

        if (!startsTimeInput.isDisplayed() && !endTimeInput.isDisplayed()){
            return true;
        }else {
            return false;
        }

    }

    public boolean verifyThatStartAndEndDateBoxAreDisplayed(){

        if (startDateInput.isDisplayed() && endDateInput.isDisplayed()){
            return true;
        }else {
            return false;
        }
    }


    //T8

    public void verifyTheSelectedOption(String expected){


        Select select=new Select(repeatsSelectBtn);

        String firstOptionText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected,firstOptionText);


    }


    public String repeatEveryRadioButtonIsSelected(String expected){

         if (repeatEveryRadioButton.isSelected()){
             return expected;
         }else {
             return expected+" is not selected";
         }


    }

    public void summaryMessageGetText(String expected){

        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);

        WebElement text = wait.until(ExpectedConditions.visibilityOf(summaryMessage));

        String actual = text.getText().trim();

        Assert.assertEquals(expected,actual);


    }



    //TC10

    public void clickAfterCheckBoxAndInput10(String occurrences){

        afterCheckBox.click();
        occurrencesInput.sendKeys(occurrences, Keys.ENTER);
    }









}
