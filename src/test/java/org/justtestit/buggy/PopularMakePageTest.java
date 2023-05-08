package org.justtestit.buggy;

import org.testng.annotations.Test;

import java.util.AbstractMap;

import static org.testng.Assert.*;

public class PopularMakePageTest extends BasePageTest {

    @Test(priority=1)
    public void testVoteCountSum() throws InterruptedException {

            int totalVoteNumber;
        totalVoteNumber = homePage.getPopularMakePage().getExpectedNumberOfVotes();
        homePage.getPopularMakePage().clickPopularMakeLogo();
            int modelVoteSum = homePage.getPopularMakePage().getActualNumberOfVotes();
            assertEquals(totalVoteNumber, modelVoteSum);

        }
        @Test(priority=2)
        public void verifyPopularMake() {
            driver.get(prop.getProperty("appurl"));
            int totalVoteNumber = homePage.getPopularMakeExpectedNumberOfVotes();
            OverAllPage overAllPageContent = homePage.clickOverAllRatingImg();
            AbstractMap.SimpleEntry<String, Integer> maxVoteMakeValue = null;
            try {
                maxVoteMakeValue = overAllPageContent.getTotalVoteCounts();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //AbstractMap.SimpleEntry<String, Integer> maxVoteMakeValue = homePage.getOverAllPage().getTotalVoteCounts();
            assertEquals(totalVoteNumber, maxVoteMakeValue.getValue());
        }
    }