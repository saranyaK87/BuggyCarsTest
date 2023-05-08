package org.justtestit.buggy;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public AbstractMap.SimpleEntry<String, Integer> getTotalVoteCounts() throws InterruptedException {
        String makeNameOnThisRow;
        int voteOnThisRow;
        String maxVoteMake = "";
        int maxVoteValue = 0;
        int rowCount = 0;
        ArrayList<AbstractMap.SimpleEntry<String, Integer>> arrayList = new ArrayList<AbstractMap.SimpleEntry<String, Integer>>();
        String textOfTotalPage = totalPages.getText();
        //Get Number of pages
        int totalPgs = Integer.parseInt(textOfTotalPage.substring(textOfTotalPage.lastIndexOf("of ")+3));
        // Iterate through each Page in OverAllPage
        for (int a = 1; a <= totalPgs; a++)
        {
            System.out.println("I'm in Page :"+a);
            String[] tmpText = totalPages.getText().substring(textOfTotalPage.lastIndexOf("page ")+5).split(" of ");
            int currentPageNumber = Integer.parseInt(tmpText[0]);
            if (currentPageNumber <= totalPgs)
            {
                List<WebElement> rowsOnThisPage = driver.findElements(By.xpath("//table[@class='cars table table-hover']/tbody/tr"));
                rowCount = rowsOnThisPage.size();
                System.out.println("Row count is "+rowCount);
                //Get Next Page
                //Iterate Each Row in this page
                for (int i = 1; i <= rowCount; i++)
                {
                    System.out.println("I'm in row :"+i);
                    try {
                        makeNameOnThisRow = driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[2]")).getText();
                        voteOnThisRow = Integer.parseInt(driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[5]")).getText());
                        System.out.println("Make name in this row "+makeNameOnThisRow);
                        System.out.println("voteOnThisRow "+voteOnThisRow);
                    }
                    catch (StaleElementReferenceException e){
                        makeNameOnThisRow = driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[2]")).getText();
                        voteOnThisRow = Integer.parseInt(driver.findElement(By.xpath("//table[@class='cars table table-hover']/tbody/tr[" + i + "]/td[5]")).getText());
                    }
                    Boolean savingNewKeyValue = false;
                    //If MakeName matches a Key, then add vote count to its value
                    for (int x = 0; x < arrayList.size(); x++)
                    {
                        if (arrayList.get(x).getKey().equalsIgnoreCase(makeNameOnThisRow))
                        {
                            arrayList.get(x).setValue(voteOnThisRow + arrayList.get(x).getValue());
                            int currentVoteValue = arrayList.get(x).getValue();
                            if (currentVoteValue > maxVoteValue)
                            {
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
/*
                int remainingPages = totalPgs - currentPageNumber;
                System.out.println("Max Vote so far - " + maxVoteValue);
                System.out.println("Popular Make so far - " + maxVoteMake);
                System.out.println("We have got - " + remainingPages + "to go!");
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(20))
                        .pollingEvery(Duration.ofSeconds(20))
                        .ignoring(NoSuchElementException.class);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='cars table table-hover']/tbody/tr")));*/
                Thread.sleep(2000);
            }
        }
        AbstractMap.SimpleEntry<String, Integer> maxMakeVote = new AbstractMap.SimpleEntry<>(maxVoteMake, maxVoteValue);
        return maxMakeVote;
    }


}
