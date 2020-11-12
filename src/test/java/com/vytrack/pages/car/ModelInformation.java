package com.vytrack.pages.car;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModelInformation extends AllVehiclesModel {

    @FindBy(xpath = "//label[contains(text(),'Model Name')]/../div/div")
    private WebElement modelName;

    @FindBy(xpath = "//label[contains(text(),'Make')]/../div/div")
    private WebElement makeName;

    public String getMakeAndModel(){
        return makeName.getText()+" "+modelName.getText();
    }

}
