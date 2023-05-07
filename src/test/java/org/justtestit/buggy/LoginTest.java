package org.justtestit.buggy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BasePageTest  {

    //Test to validate Login Feature
    @Test(priority=3)
    public void validateLogin() throws InterruptedException {
        homePage.login(prop.getProperty("username"), prop.getProperty("password"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String profileName=homePage.getProfileName();
        Assert.assertTrue(profileName.contentEquals("Hi, "+prop.getProperty("firstname")));
    }

}
