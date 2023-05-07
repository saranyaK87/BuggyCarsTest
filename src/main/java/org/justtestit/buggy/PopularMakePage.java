package org.justtestit.buggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PopularMakePage extends BasePage {

    public PopularMakePage(WebDriver driver) {
        super(driver);
    }

    public int getExpectedNumberOfVotes (){

        WebElement number = driver.findElement(By.xpath("//small[contains(text(),'votes')]"));
        int totalVoteNumber = Integer.parseInt(number.getText().replaceAll("[^0-9]", ""));
        return totalVoteNumber;

    }

    public int getActualNumberOfVotes(){
        List<WebElement> voteList = driver.findElements(By.xpath("//table[@class='cars table table-hover']/tbody/tr/td[4]"));


        int modelVoteSum = 0;
        //Collect and find sum of all votes
        for (int i = 1; i <= voteList.size(); i++) {

            modelVoteSum = modelVoteSum + Integer.parseInt(
                    driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[4]")).getText());

        }
        return modelVoteSum;
    }

    public void clickPopularMakeLogo(){
        driver.findElement(By.xpath("//div[@class='col-md-4']//h2[contains(text(), 'Popular Make')]/following-sibling::a//img")).click();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
}
