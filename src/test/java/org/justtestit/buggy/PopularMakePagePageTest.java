package org.justtestit.buggy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class PopularMakePagePageTest extends BasePageTest {

    @Test(priority=2)
    public void testVoteCountSum() throws InterruptedException {

            int totalVoteNumber = homePage.getPopularMakePage().getExpectedNumberOfVotes();
            homePage.getPopularMakePage().clickPopularMakeLogo();
            int modelVoteSum = homePage.getPopularMakePage().getActualNumberOfVotes();

            assertEquals(totalVoteNumber, modelVoteSum);
        }
    }