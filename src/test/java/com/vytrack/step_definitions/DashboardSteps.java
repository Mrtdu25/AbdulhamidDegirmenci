package com.vytrack.step_definitions;

import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashboardSteps {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user is on Dashboard page")
    public void user_is_on_dashboard_page() {
        Driver.getDriver().get("http://qa1.vytrack.com");
        loginPage.login();
    }

    @When("user clicks on {string} icon")
    public void user_clicks_on_icon(String icon) {
        BrowserUtils.wait(5);
        dashboardPage.clickOn(icon);
    }
    @Then("{string} page should open")
    public void page_should_open(String pageSubtitle) {
        BrowserUtils.wait(7);
        Assert.assertEquals(pageSubtitle,dashboardPage.getPageSubTitleText());
    }

    @Then("user should see {string} icon")
    public void user_should_see_icon(String string) {
        Assert.assertTrue(dashboardPage.isIconDisplayed(string));
    }


}
