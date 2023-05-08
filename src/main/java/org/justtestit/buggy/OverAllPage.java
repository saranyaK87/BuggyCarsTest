package org.justtestit.buggy;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Object;

public class OverAllPage extends BasePage {
    @FindBy(xpath = "//div[@class='pull-xs-right' and contains(.,'page')]")
    public WebElement totalPages;

    @FindBy(xpath = "//a[contains(text(),'»')]")
    public WebElement nextPage;


    public OverAllPage(WebDriver driver) {
        super(driver);
    }

    public int getTotalPagesNumber() {
        return totalPages.getText().charAt(totalPages.getText().length()-1);
    }

    public void clickNext() {
        nextPage.click();
    }

    public AbstractMap.SimpleEntry<String, Integer> getTotalVoteCounts () {

        String makeNameOnThisRow;
        int voteOnThisRow;
        String maxVoteMake = "";
        int maxVoteValue = 0;

        ArrayList<AbstractMap.SimpleEntry<String, Integer>> arrayList = new ArrayList<AbstractMap.SimpleEntry<String, Integer>>();

        String textOfTotalPage = totalPages.getText();
        //Get Number of pages
        int totalPgs = Integer.parseInt(
                textOfTotalPage.substring(textOfTotalPage.lastIndexOf("of ")+3));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Iterate through each Page in OverAllPage
        for (int a = 1; a <= totalPgs; a++) {
            String[] tmpText = totalPages.getText().substring(textOfTotalPage.lastIndexOf("page ")+5).split(" of ");
            int currentPageNumber = Integer.parseInt(tmpText[0]);

            //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='cars table table-hover']/tbody/tr[1]")));

            if (currentPageNumber <= totalPgs){
                List<WebElement> rowsOnThisPage = driver.findElements(By.xpath("//table[@class='cars table table-hover']/tbody/tr"));

            //Get Next Page
            //Iterate Each Row in this page
            for (int i = 1; i <= rowsOnThisPage.size(); i++) {



                makeNameOnThisRow = driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[2]")).getText();
                voteOnThisRow = Integer.parseInt(driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[5]")).getText());

                Boolean savingNewKeyValue = false;

                //If MakeName matches a Key, then add vote count to its value
                for (int x = 0; x < arrayList.size(); x++) {
                    if (arrayList.get(x).getKey().equalsIgnoreCase(makeNameOnThisRow)) {
                        arrayList.get(x).setValue(voteOnThisRow + arrayList.get(x).getValue());
                        int currentVoteValue = arrayList.get(x).getValue();
                        if (currentVoteValue > maxVoteValue) {
                            maxVoteValue = currentVoteValue;
                            maxVoteMake = arrayList.get(x).getKey();
                        }
                        savingNewKeyValue = true;
                        break;
                    }
                }
                if (!savingNewKeyValue) {
                    arrayList.add(new AbstractMap.SimpleEntry(makeNameOnThisRow, voteOnThisRow));
                    savingNewKeyValue = false;
                }
            }
            //Click next button
             nextPage.click();
        }
    }
        AbstractMap.SimpleEntry<String, Integer> maxMakeVote = new AbstractMap.SimpleEntry<>(maxVoteMake, maxVoteValue);
        return maxMakeVote;
    }

}
