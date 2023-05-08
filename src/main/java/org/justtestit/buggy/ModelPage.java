package org.justtestit.buggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ModelPage extends BasePage {
    @FindBy(xpath = "//h4[contains(text(),'Votes:')]")
    private WebElement votes;
    @FindBy(xpath = "//button[contains(text(),'Vote!')]")
    private WebElement voteBtn;
    @FindBy(xpath = "//textarea[@id='comment']")
    private WebElement comment;
    @FindBy(xpath = "//table[@class=\"table\"]")
    private WebElement commentTable;
    @FindBy(xpath = "//p[contains(text(),'Thank you for your vote!')]")
    public WebElement thanksForYourVoteText;

    public ModelPage(WebDriver driver) {
        super(driver);
    }




/*    public void getFirstUnVotedModel(){
        int rowNum = 1;
        //Get overall Page count
        int pageCount = Integer.parseInt(driver.findElement(By.xpath("")));
        //overallPage.totalPages.getText().substring(overallPage.totalPages.getText().lastIndexOf("of ") + 3)
        driver.findElements(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + rowNum + "]/td[2]"));
    }*/
}
