package org.justtestit.buggy;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest extends BasePageTest {

    @Test(priority=2)
    public void validateNewRegistration() throws InterruptedException {

        RegistrationPage registerPage = homePage.clickRegister();
        System.out.println("Clicked register button");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MICROSECONDS);

        //Creating a 7 letter random username everytime
        String generatedString = RandomStringUtils.random(7, true, true);

        //Creating a new registration. Populating values from config file.
        Registration registrationDetails = new Registration.RegistrationMainBuilder()
                .username(generatedString).firstName(prop.getProperty("firstname")).lastname(prop.getProperty("lastname"))
                .password(prop.getProperty("password")).confirmPassword(prop.getProperty("password")).build();
        String result = registerPage.newRegistration(registrationDetails);

        System.out.println("New User registered");

        Assert.assertTrue(result.equals("Registration is successful"),result);
    }


}
