package com.degirmenci.step_definition;

import com.degirmenci.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        System.out.println("::: Starting Automation:::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
//    this hook will run only before scenarios with a tag @db

    /**
     * @db Scenario: I don't know but here I'm connecting to DB
     * Given user runs following query "SELECT * ...."
     * <p>
     * order = 0 - to define hooks execution order
     */
    @Before(value = "@db", order = 0)
    public void dbSetup() {
        System.out.println("::: Connecting to the database:::");
    }

    @After("@db")
    public void dbTearDown() {
        System.out.println("::: Disconnecting from the database:::");
    }

    @After
    public void tearDown() {
        //close browser, close DB connection, close tunnel,capture screenshot of the error, etc..
        //this is a hook after
        //runs automatically after every test
        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");
    }


}
