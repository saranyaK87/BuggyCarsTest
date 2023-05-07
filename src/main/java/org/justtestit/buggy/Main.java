package org.justtestit.buggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String driverPath = "C:\\Saranya\\Selenium\\chromedriver.exe";
        String websiteURL = "https://buggy.justtestit.org";

        System.setProperty("webdriver.chrome.driver", driverPath);


        WebDriver driver = new ChromeDriver();
        driver.get(websiteURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
        driver.manage().window().maximize();

        WebElement registerBtn = driver.findElement(By.className("btn-success-outline"));
        registerBtn.click();


    }
}