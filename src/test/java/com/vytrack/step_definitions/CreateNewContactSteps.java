package com.vytrack.step_definitions;

import com.vytrack.pages.contacts.ContactsInfo;
import com.vytrack.pages.contacts.CreateContacts;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.Map;


public class CreateNewContactSteps {

    CreateContacts createContacts = new CreateContacts();
    ContactsInfo contactsInfo = new ContactsInfo();

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String string) {
        createContacts.clickOnCreateButton(string);
    }


    @When("for {string} enter {string}")
    public void for_enter(String string, String string2) {
        createContacts.enterPersonsInfo(string,string2);
    }

    @When("user adds new contacts information")
    public void user_adds_new_contacts_information(Map<String,String> info) {
       info.forEach((k,v) -> { createContacts.enterPersonsInfo(k,v); });
    }


    @When("for phone number enter {string}")
    public void for_phone_number_enter(String string) {
        createContacts.enterPersonsPhone(string);
    }
    @When("for email enter {string}")
    public void for_email_enter(String string) {
        createContacts.enterPersonsEmail(string);
    }
    @Then("new contact should be {string}")
    public void new_contact_should_be(String string) {
        Assert.assertEquals(string,contactsInfo.getFullName());
    }
    @Then("email {string} , phone {string} should be displayed")
    public void email_phone_should_be_displayed(String string, String string2) {
        Assert.assertTrue(contactsInfo.emailIsDisplayed(string));
        Assert.assertTrue(contactsInfo.phoneNumberIsDisplayed(string2));
    }

    @Then("{string} , {string} should be displayed")
    public void should_be_displayed(String string, String string2) {

        Assert.assertTrue(string+"is not displayed",contactsInfo.elementIsDisplayed(string));
        Assert.assertTrue(string2+"is not displayed",contactsInfo.elementIsDisplayed(string2));

    }

    @Then("{string} , should be displayed")
    public void should_be_displayed(String string) {
        Assert.assertTrue(string+"is not displayed",contactsInfo.infoElementIsDisplayed(string));
    }


    @Then("{string} , social media should be displayed")
    public void social_media_should_be_displayed(String string) {
        Assert.assertTrue(string+"is not displayed",contactsInfo.socialMediaIsDisplayed(string));
    }




    @Then("{string} for {string} , should be displayed")
    public void for_should_be_displayed(String string, String string2) {
        Assert.assertEquals(string2,contactsInfo.getElementText(string));
    }



}
