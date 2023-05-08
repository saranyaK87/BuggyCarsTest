package org.justtestit.buggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.management.ManagementPermission;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginID;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;
    @FindBy(xpath="//button[contains(text(),'Login')]")
    private WebElement loginBtn;

    @FindBy(xpath="//a[contains(text(),'Logout')]")
    private WebElement logoutBtn;

    @FindBy(xpath="//a[contains(text(),'Profile')]")
    private WebElement profileLink;

    @FindBy(xpath="//span[contains(text(),'Hi')]")
    private WebElement profileName;

    @FindBy(xpath = "//a[contains(text(),'Register')]")
    private WebElement registerBtn;
    @FindBy(xpath = "*[//text(),'Popular Make']/..//h3")
    private WebElement popularMake;
    @FindBy(xpath = "*[//small[normalize-space()=' votes)']]")
    private WebElement popularMakeVote;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage clickRegister() {
        registerBtn.click();
        return new RegistrationPage(driver);
    }

    public void login(String usernameVal, String passwordVal){
        loginID.sendKeys(usernameVal);
        password.sendKeys(passwordVal);
        loginBtn.click();
    }

    public Boolean logOut() {
        logoutBtn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return loginBtn.isDisplayed();
    }

    public void clickHomePagePopularMakeLogo(){
        driver.findElement(By.xpath("//div[@class='col-md-4']//h2[contains(text(), 'Popular Make')]/following-sibling::a//img")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    public int getPopularMakeExpectedNumberOfVotes (){
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        WebElement number = driver.findElement(By.xpath("//*[text() = 'Popular Make']/..//h3//small[contains(text(),'votes')]"));
        int totalVoteNumber = Integer.parseInt(number.getText().replaceAll("[^0-9]", ""));
        System.out.println("totalVoteNumber = "+totalVoteNumber);
        return totalVoteNumber;
    }
    public String getProfileName(){
        return profileName.getText();
    }

    public ProfilePage viewProfile(){
        profileLink.click();
        return new ProfilePage(driver);
    }

    public PopularMakePage getPopularMakePage () {
        PopularMakePage page = new PopularMakePage(driver);
        return page;
    }

    public ModelPage getModelPage () {
        ModelPage model = new ModelPage(driver);
        return model;
    }

    public OverAllPage clickOverAllRatingImg(){
        driver.findElement(By.xpath("//div[@class='col-md-4']//h2[contains(text(), 'Overall Rating')]/following-sibling::a//img")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new OverAllPage(driver);
    }


    public OverAllPage getOverAllPage () {
        OverAllPage page = new OverAllPage(driver);
        return page;
    }
}
