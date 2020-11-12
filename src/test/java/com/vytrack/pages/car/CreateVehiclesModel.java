package com.vytrack.pages.car;

import com.vytrack.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateVehiclesModel extends AllVehiclesModel {

    @FindBy(name = "custom_entity_type[ModelName]")
    private WebElement modelNameInputBox;
    @FindBy(name = "custom_entity_type[Make]")
    private WebElement makeInputBox;

    public void enterModelName(String model) {
        BrowserUtils.enterText(modelNameInputBox, model);
    }

    public void enterMake(String make){
        BrowserUtils.enterText(makeInputBox, make);
    }
}
