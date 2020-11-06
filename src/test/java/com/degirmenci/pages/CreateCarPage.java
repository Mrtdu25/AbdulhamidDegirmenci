package com.degirmenci.pages;

import com.degirmenci.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateCarPage extends BasePage {

    @FindBy(css = "[title='Create Car']")
    private WebElement createCarBtn;

    @FindBy(name = "custom_entity_type[LicensePlate]")
    private WebElement licensePlateInput;

    @FindBy(name = "custom_entity_type[ModelYear]")
    private WebElement modelYearInput;




    public void clickOnCreateCar(){

        BrowserUtils.clickOnElement(createCarBtn);

    }

    public void enterLicensePlate(String licensePlate){

        BrowserUtils.enterText(licensePlateInput,licensePlate);

    }

    public void enterModelYear(String modelYear){

        BrowserUtils.enterText(modelYearInput,modelYear);

    }















}
