package org.justtestit.buggy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
