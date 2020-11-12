package com.vytrack.pages.car;

import com.vytrack.pages.BaseP;
import com.vytrack.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllVehiclesModel extends BaseP {

    @FindBy(css = "[title='Create Vehicles Model']")
    private WebElement createVehiclesModelBtn;

    public void clickOnCreateVehiclesModelBtn(){
        BrowserUtils.clickOnElement(createVehiclesModelBtn);
    }

//change
}
