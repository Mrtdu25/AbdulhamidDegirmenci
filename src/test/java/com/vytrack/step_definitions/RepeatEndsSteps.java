package com.vytrack.step_definitions;

import com.vytrack.pages.calendar.RepeatEnds;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RepeatEndsSteps {
    RepeatEnds repeatEnds = new RepeatEnds();

    @Then("following message as a summary is displayed: {string}")
    public void following_message_as_a_summary_is_displayed(String string) {
        Assert.assertEquals(string,repeatEnds.summaryMessageIs());
    }





}
