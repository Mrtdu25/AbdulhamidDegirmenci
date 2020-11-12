package com.vytrack.pages.calendar;

import com.vytrack.pages.calendar.Repeat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RepeatEnds extends Repeat {
//"//span[contains(text(),'Daily every 1 day')]/following-sibling::span"}
//  (Session info: chrome=86.0.4240.111)
    @FindBy(xpath = "//span[contains(text(),'Daily every 1 day')]/following-sibling::span")
    private WebElement summaryMessageExtension;

    public String summaryMessageIs() {

            return super.summaryMessageIs() + summaryMessageExtension.getText();

    }
}
