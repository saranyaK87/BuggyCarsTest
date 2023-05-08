package org.justtestit.buggy;

import org.testng.annotations.Test;

import java.util.AbstractMap;

import static org.testng.Assert.*;

public class PopularMakePageTest extends BasePageTest {

    @Test(priority=3)
    public void testVoteCountSum() throws InterruptedException {

            int totalVoteNumber = homePage.getPopularMakePage().getExpectedNumberOfVotes();
            homePage.getPopularMakePage().clickPopularMakeLogo();
            int modelVoteSum = homePage.getPopularMakePage().getActualNumberOfVotes();

            assertEquals(totalVoteNumber, modelVoteSum);
        }
        @Test(priority=2)
        public void verifyPopularMake() {
            int totalVoteNumber = homePage.getPopularMakePage().getExpectedNumberOfVotes();
            OverAllPage overAllPageContent = homePage.clickOverAllRatingImg();
            AbstractMap.SimpleEntry<String, Integer> maxVoteMakeValue = homePage.getOverAllPage().getTotalVoteCounts();
            assertEquals(totalVoteNumber, maxVoteMakeValue.getValue());
        }
        @Test
        public void verifyPopularModel() {
            OverAllPage overAllPageContent = homePage.clickOverAllRatingImg();
        }
    }