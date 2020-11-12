package com.vytrack.step_definitions;

import com.vytrack.pages.car.AllVehiclesModel;
import io.cucumber.java.en.Given;

public class AllVehiclesSteps {
    AllVehiclesModel allVehiclesModel = new AllVehiclesModel();

    @Given("user clicks on create model button")
    public void user_clicks_on_create_model_button() {
        allVehiclesModel.clickOnCreateVehiclesModelBtn();
    }




}
