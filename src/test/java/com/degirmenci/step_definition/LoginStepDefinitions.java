package com.degirmenci.step_definition;


import com.degirmenci.pages.LoginPage;
import com.degirmenci.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get("https://qa1.vytrack.com/user/login");

    }

    @When("user logs in")
    public void user_logs_in() {
        loginPage.login("sales manager");


    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() throws InterruptedException {

        String expected="Dashboard";
        String actual=loginPage.getPageSubTitleText();

        Assert.assertEquals("Actual does not equal expected",actual,expected);
        Thread.sleep(4000);
        Driver.closeDriver();

    }




    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {

        String actual = loginPage.getWarningMessageText();

        Assert.assertEquals("Actual does not equal to expected",string,actual);


    }

    @Then("user should see {string} page")
    public void user_should_see_page(String string) {
        String actual = loginPage.getPageSubTitleText();

        Assert.assertEquals("Actual does not equal expected",string,actual);
    }

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {

       loginPage.login(string);

    }

    @Then("user should see Quick Launch page")
    public void user_should_see_quick_launch_page() {

        String actual = loginPage.getPageSubTitleText();
        String expected="Quick Launchpad";

        Assert.assertEquals("Actual result does NOT match with expected",actual,expected);
        Driver.closeDriver();

    }

    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {

        loginPage.login(string, string2);

    }



    @When("user logs in second time as a {string}")
    public void user_logs_in_second_time_as_a(String string) {
       loginPage.login("store manager");
    }




}


