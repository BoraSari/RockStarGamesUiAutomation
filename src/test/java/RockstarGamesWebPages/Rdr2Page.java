package RockstarGamesWebPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rdr2Page extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    Wait<WebDriver> waits = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(30L))
            .pollingEvery(Duration.ofSeconds(10L))
            .ignoring(NoSuchElementException.class)
            .ignoring(ElementNotInteractableException.class);



     @FindBy(css = "svg[class='rockstargames-modules-core-videoplayerc6c27af76d4f0eb4bebd4a3eeb2a8c15']")
     private WebElement fullScreenButton;

     @FindBy(css = "button[aria-label='Quality Settings Menu']")
     private WebElement qualityChangeButton;

     @FindBy(css = "div>button[aria-label='Next video page']")
     private WebElement nextArrow;

     @FindBy(xpath = "//span[contains(text(),'2160p')]")
     private WebElement qualityOptionForVideo;

     @FindBy(xpath = "//h3[contains(text(),'Related Videos')]")
     private WebElement relatedVideos;

     @FindBy(xpath = "(//div//h5[@class='rockstargames-sites-rockstargamesfd87597d0f90ed6d8a2081da933f53bc'])[12]")
    private WebElement newsTitle;

     @FindBy(xpath = "(//button[@class='rockstargames-modules-core-videoplayerea5b581015e7f2a7149e17ffede61f2b '])[2]")
     private WebElement soundIcon;


     @FindBy(css = "div[class='rockstargames-modules-core-videoplayeracfcf6e26a55c7f25a2ce148f01942b7']")
     private WebElement volumeChangeBar;

     @FindBy(css = "div > button[aria-label='Play/Pause Toggle']")
     private WebElement pauseButton;

     @FindBy(xpath = "(//div//h5[@class='rockstargames-sites-rockstargamesfd87597d0f90ed6d8a2081da933f53bc'])[12]")
     private WebElement legendPageText;



     public Rdr2Page(WebDriver driver){
        super(driver);
         PageFactory.initElements(driver,this);
    }


    public void playVideoFunctions()throws InterruptedException{
         Actions actions = new Actions(driver);
         if (fullScreenButton.isDisplayed() && fullScreenButton.isEnabled()){
             actions.moveToElement(fullScreenButton).build().perform();
                fullScreenButton.click();
            }

         getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[aria-label='Quality Settings Menu']")));
        actions.moveToElement(qualityChangeButton).build().perform();
        qualityChangeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'2160p')]")));
        actions.moveToElement(qualityOptionForVideo).build().perform();
        qualityOptionForVideo.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='rockstargames-modules-core-videoplayerea5b581015e7f2a7149e17ffede61f2b '])[2]")));
        actions.moveToElement(soundIcon).build().perform();
       soundIcon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='rockstargames-modules-core-videoplayeracfcf6e26a55c7f25a2ce148f01942b7']")));
        actions.moveToElement(volumeChangeBar).build().perform();
        volumeChangeBar.click();
       for (int i=0;i<2;i++){
           if (pauseButton.isDisplayed()&& pauseButton.isEnabled()){
               actions.moveToElement(pauseButton).build().perform();
               pauseButton.click();
           }

       }
       if (fullScreenButton.isDisplayed() && fullScreenButton.isEnabled()){
           actions.moveToElement(fullScreenButton).build().perform();
           getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("svg[class='rockstargames-modules-core-videoplayerc6c27af76d4f0eb4bebd4a3eeb2a8c15']")));
           fullScreenButton.click();
        }
     }

    public void scrollThePage(){
        JavascriptExecutor executor = ((JavascriptExecutor) driver);
        executor.executeScript("window.scrollBy(0,650)");
    }

    public void inspectOtherNewsAboutGame() throws InterruptedException {
         Actions actions = new Actions(driver);
        for(int i=0;i<9;i++){
            getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div>button[aria-label='Next video page']")));
                actions.moveToElement(nextArrow).build().perform();
                 nextArrow.click();
            }




     }

     public WebElement checkDisplayingOfRelatedVideosSection(){
         WebElement title = relatedVideos;
         return title;
     }

     public String getRelatedVideosTitleText(){
         return relatedVideos.getText();
     }

    public String checkNewsTitle(){
         String title = newsTitle.getText();
        return title;
     }

     public void navigateRdrLegendsPage(){
          getExpilictWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div//h5[@class='rockstargames-sites-rockstargamesfd87597d0f90ed6d8a2081da933f53bc'])[12]")));
             legendPageText.click();


     }

     public String getAttributeOfLegendsTitle(){
         String exampleTitle = legendPageText.getDomAttribute("class");
         return exampleTitle;

     }


     public Point getLocationOfLegendsText(){
          Point random = legendPageText.getLocation();
          return random;
     }
}
