package com.degirmenci.step_definition;

import com.degirmenci.pages.CreateCarPage;
import com.degirmenci.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepDefinition {

    CreateCarPage createCarPage=new CreateCarPage();


    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {

     createCarPage.clickOnCreateCar();

        BrowserUtils.wait(4);

    }

    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String,String> data) {

        data.forEach( (key,value)-> System.out.println("Key "+ key+", Value "+ value));

        String licensePlate = data.get("License Plate");
        String modelYear = data.get("Model Year");

        createCarPage.enterLicensePlate(licensePlate);
        createCarPage.enterModelYear(modelYear);
    }





}
