package com.vytrack.step_definitions;

import com.vytrack.pages.car.ModelInformation;
import com.vytrack.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class ModelnformationSteps {
    ModelInformation modelInformation = new ModelInformation();


    @Then("user should see new model on the list")
    public void user_should_see_new_model_on_the_list(Map<String,String> dataTable) {
        BrowserUtils.wait(3);
        String carModel = dataTable.get("Car model");
        String carMake = dataTable.get("Car make");

        Assert.assertEquals(carMake+" "+carModel,modelInformation.getMakeAndModel());



        BrowserUtils.wait(3);
    }

}
