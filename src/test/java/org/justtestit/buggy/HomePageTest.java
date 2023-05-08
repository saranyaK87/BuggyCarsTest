package org.justtestit.buggy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends BasePageTest {
    @Test(priority=1)
    public void verifyTitle(){
        Assert.assertTrue(driver.getTitle().equals("Buggy Cars Rating"));
    }
    @Test
    public void verifyHeaderImage () {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='center-block']//img")).isDisplayed());
    }
    @Test
    public void logOut() {
        homePage.login(prop.getProperty("username"), prop.getProperty("password"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Assert.assertTrue(homePage.logOut());
    }



}
