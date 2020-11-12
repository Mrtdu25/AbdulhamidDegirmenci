package com.vytrack.step_definitions;

import com.vytrack.pages.car.CreateCarPage;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreateCarStepsDefinitions {
    CreateCarPage createCarPage = new CreateCarPage();


    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
        createCarPage.clickOnCreateCar();
        BrowserUtils.wait(10);
    }


    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {
        BrowserUtils.wait(3);
        dataTable.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

      /*  for(Map.Entry<String, String> entry: dataTable.entrySet()){
        System.out.println("Key: " + entry.getKey() + ", value: "+entry.getValue());
     } */

        String licensePlate = dataTable.get("License Plate");
        String modelYear = dataTable.get("Model Year");

        System.out.println("License plate: " + licensePlate);
        System.out.println("Model year: " + modelYear);

        createCarPage.enterLicensePlate(licensePlate);
        createCarPage.enterModelYear(modelYear);
        BrowserUtils.wait(3);
    }
}
