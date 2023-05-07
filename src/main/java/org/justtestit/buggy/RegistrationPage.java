package org.justtestit.buggy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {
    @FindBy(id = "username")
    public WebElement loginID;
    @FindBy(id = "firstName")
    public WebElement firstName;
    @FindBy(id = "lastName")
    public WebElement lastName;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "confirmPassword")
    public WebElement confirmPassword;
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    private WebElement registerBtn;
    @FindBy(xpath = "//div[contains(@class,'result alert')]")
    private WebElement result;

    public RegistrationPage (WebDriver driver) {
        super(driver);
    }

    public String newRegistration (Registration registrationEntries) {
        loginID.sendKeys(registrationEntries.loginID);
        firstName.sendKeys(registrationEntries.firstName);
        lastName.sendKeys(registrationEntries.lastName);
        password.sendKeys(registrationEntries.password);
        confirmPassword.sendKeys(registrationEntries.confirmPassword);
        registerBtn.click();
        return result.getText();
    }


}
