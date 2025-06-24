package RockstarGameTests;
import RockstarGamesWebPages.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class RockstarGamesTests extends BaseTest{
    protected  static Logger logger  = Logger.getLogger(String.valueOf(RockstarGamesTests.class));
    protected MainPage mainPage;
   protected BasePage basePage;
   protected Rdr2Page rdr2Page;
   protected LegendsPage legendsPage;
   protected Rdr1GamePage rdr1GamePage;


    @BeforeMethod
    public void classSetup(){
        logger.info("Rockstar Games Classes Setup");
        mainPage=new MainPage(getDriver());
        basePage=new BasePage(getDriver());
        rdr2Page= new Rdr2Page(getDriver());
        legendsPage = new LegendsPage(getDriver());
        rdr1GamePage= new Rdr1GamePage(getDriver());
    }

    @Test(priority = 1,description = "Regression Test for main page",timeOut = 600000)
    public void checkAllGamesOWebsiteTest() {
        logger.info("Check game news on website");
        mainPage.checkGameNewsSections();
        logger.info("Assertion controls for message display and logo display.");
        softAssert.assertTrue(mainPage.checkMessage().isDisplayed());
        softAssert.assertTrue(mainPage.checkRockstarGamesLogo().isDisplayed());
    }
    @Test(priority = 2, description = "Regression Test Part",testName = "Gameplay Trailer Video Functions Test",timeOut = 600000)
    public void checkRdr2TrailerTest() throws InterruptedException {
        logger.info("Gameplay video test on website");
       mainPage.playRdr2Trailer();
       rdr2Page.scrollThePage();
       logger.info("Check video functions like quality change, volume change and  pause section etc.");
       rdr2Page.playVideoFunctions();
        logger.info("Scroll down the page after video");
       rdr2Page.scrollThePage();
       logger.info("Inspect other rockstar games news");
       rdr2Page.inspectOtherNewsAboutGame();


       logger.info("Element location defination");
       int locationOfX = rdr2Page.getLocationOfLegendsText().getX();
       int locationOfY = rdr2Page.getLocationOfLegendsText().getY();


       logger.info("Change value type of this locations");
       String stringX  = String.valueOf(locationOfX);
       String stringY = String.valueOf(locationOfY);


       logger.info("Assertions checks for title, game news and element locations etc.");
       softAssert.assertEquals(rdr2Page.getRelatedVideosTitleText(),"Related Videos");
       softAssert.assertTrue(rdr2Page.getAttributeOfLegendsTitle().equals("rockstargames-sites-rockstargamesfd87597d0f90ed6d8a2081da933f53bc"));
       softAssert.assertTrue(rdr2Page.getLocationOfLegendsText().toString().contains(stringX));
       softAssert.assertTrue(rdr2Page.getLocationOfLegendsText().toString().contains(stringY));
       softAssert.assertTrue(rdr2Page.checkDisplayingOfRelatedVideosSection().isEnabled());
       softAssert.assertTrue(rdr2Page.checkNewsTitle().equals("Undead Nightmare Debut trailer"));

    }

    @Test(priority = 3,dependsOnMethods = "checkRdr2TrailerTest",description = "Part Of Regression Test",enabled = true,timeOut = 600000)
    public void legendsPageTextTest() throws InterruptedException {
        logger.info("Navigate rdr legends page");
        rdr2Page.navigateRdrLegendsPage();
        logger.info("Fill the age verification form");
        legendsPage.filledAgeForm("06", "03", "2015");
        logger.info("Scroll down the page after verification form");
        legendsPage.scrollDownThePage();
        logger.info("Scroll up the page after verification form");
        legendsPage.scrollUpThePage();
        logger.info("Click game search section");
        legendsPage.clickSearchBoxIcon();
        logger.info("Click game categorysection and filter search with games");
        legendsPage.clickGamesSectionButton();


        System.out.println(legendsPage.getValueOfInputField());
        System.out.println("Show tag name of element" + legendsPage.getTagNameOfElement());


       logger.info("Assertion for tag name, input value and  element display etc");
        softAssert.assertEquals(legendsPage.getTagNameOfElement(), "h2");
        softAssert.assertEquals(legendsPage.getValueOfInputField(), "Red Dead Redemption");
        softAssert.assertTrue(legendsPage.getTitleOfLegendsTrailer().contains("Legends and Killers"));
        softAssert.assertTrue(legendsPage.checkAvabilityOfContentNotAvaibleMessage().isDisplayed());
        softAssert.assertTrue(legendsPage.getSearchBoxIcon().isDisplayed());


        try {
            softAssert.assertEquals(legendsPage.getNotAvaibleMessageText(), "You may not view this content at this time");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @Test(priority = 4,enabled = true,dependsOnMethods = "legendsPageTextTest",description = "Part of regression test")
    public void rdr1PageTests() throws InterruptedException {
        logger.info("Search Rdr game on search field");
        legendsPage.searchGame("Red Dead Redemption");
        logger.info("Scroll down the page");
        rdr1GamePage.scrollDownThePage();
        logger.info("Navigate Rdr1 game page");
        rdr1GamePage.clickRdr1GamePoster();
        logger.info("Watch Rdr1 trailer");
        rdr1GamePage.startTrailer();
        logger.info("Close the Rdr1 trailer");
        rdr1GamePage.closeGameplayTrailerVideo();
        logger.info("Click buy now button");
        rdr1GamePage.clickBuyNowButton();

        System.out.println(rdr1GamePage.getPlatformsMessage().length());
        System.out.println(rdr1GamePage.getPlatformsMessage().toUpperCase());
        System.out.println(rdr1GamePage.getPlatformsMessage().toLowerCase());


        logger.info("Get upper and lower version of string texts");
        String upperMessage = rdr1GamePage.getPlatformsMessage().toUpperCase();
        String lowerMessage = rdr1GamePage.getPlatformsMessage().toLowerCase();


        logger.info("Assertions for message length, special character contain,upper and lower message text and empty title");
        softAssert.assertTrue(rdr1GamePage.getPlatformsMessage().length()==62);
        softAssert.assertTrue(rdr1GamePage.getPlatformsMessage().endsWith("."));
        softAssert.assertTrue(upperMessage.equals("NOW AVAİLABLE ON PC, NİNTENDO SWİTCH, PLAYSTATİON 4, AND XBOX."));
        softAssert.assertTrue(lowerMessage.equals("now available on pc, nintendo switch, playstation 4, and xbox."));
        softAssert.assertFalse(rdr1GamePage.getAllPlatformTitles().isEmpty());

    }





}
