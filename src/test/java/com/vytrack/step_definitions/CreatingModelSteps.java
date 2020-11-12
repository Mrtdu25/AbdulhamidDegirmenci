package com.vytrack.step_definitions;

import com.vytrack.pages.car.CreateVehiclesModel;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.When;

import java.util.Map;

public class CreatingModelSteps {
    CreateVehiclesModel createVehiclesModel = new CreateVehiclesModel();


    @When("user adds new model information")
    public void user_adds_new_model_information(Map<String,String> dataTable) {
        BrowserUtils.wait(3);

        String carModel = dataTable.get("Car model");
        String carMake = dataTable.get("Car make");

        createVehiclesModel.enterModelName(carModel);
        createVehiclesModel.enterMake(carMake);

        BrowserUtils.wait(3);

    }
}
