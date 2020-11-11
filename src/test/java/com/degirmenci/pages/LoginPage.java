package com.degirmenci.pages;

import com.degirmenci.utils.ConfigurationReader;
import com.degirmenci.utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id ="prependedInput2")
    private WebElement password;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessageText() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return warningMessage.getText().trim();
    }



    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    public void login(){

        String usernameValue = ConfigurationReader.getProperty("storemanager.username");
        String passwordValue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);


    }

    public void login(String role) {
        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");

        if (role.equalsIgnoreCase("sales manager")) {
            usernameValue = ConfigurationReader.getProperty("salesmanager.username");
        } else if (role.equalsIgnoreCase("driver")) {
            usernameValue = ConfigurationReader.getProperty("driver.username");
        } else if (role.equalsIgnoreCase("store manager")){
            usernameValue = ConfigurationReader.getProperty("storemanager.username");
        }

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }


}
