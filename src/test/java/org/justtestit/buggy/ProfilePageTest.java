package org.justtestit.buggy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProfilePageTest extends BasePageTest {
    @Test
    public void profileUpdate() {
        homePage.login(prop.getProperty("username"), prop.getProperty("password"));
        ProfilePage profilePage = homePage.viewProfile();

        //Update Values in fields
        Assert.assertTrue(profilePage.updateBasicInfo(prop.getProperty("firstname"),prop
                .getProperty("lastname")).equals("The profile has been saved successful"),"Profile Update failed - Please check!");

        Assert.assertTrue(profilePage.updateAdditionalInfo(prop.getProperty("gender"),
                prop.getProperty("age"),prop.getProperty("address"),prop.getProperty("phone"),
                prop.getProperty("hobby")).equals("The profile has been saved successful"),"Profile Update failed - Please check!");

    }

    @Test
    public void getToHomePage () {
        OverAllPage overAllPageContent = homePage.clickOverAllRatingImg();
        driver.findElement(By.xpath("//a[contains(text(),'Buggy Rating')]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='center-block']//img")).isDisplayed());
    }
}