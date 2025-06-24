package RockstarGamesWebPages;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.security.auth.x500.X500Principal;
import java.time.Duration;

public class AllGamesPage extends  BasePage {

    private WebDriverWait wait;

    @FindBy(xpath = "//img[@class=\"_1v4b2b8h _1v4b2b8j _1o231x80\"][1]")
    private WebElement gta6Picture;

    @FindBy(xpath = "(//div[@aria-label='Grand Theft Auto VI'])[2]")
    private  WebElement gta6Posture;

    @FindBy(css = "g[clip-path='url(#:Ra4bd7rpqfkq:)']")
    private WebElement videoPlayButton;

    @FindBy(xpath = "//button[@class='ytp-fullscreen-button ytp-button']")
    private WebElement fullScreenSection;

    @FindBy(xpath = "\"//iframe[@class='_1c9k4ih5 _11i6lpx0']\";")
    private WebElement iframe;

    @FindBy(xpath = "//div[@data-state='open'][1]")
    private WebElement closePage;

    @FindBy(xpath = "//button[1]")
    private WebElement gta6Icon;

    @FindBy(xpath = "//div[@class='g0abma3']")
    private WebElement menuSection;

    @FindBy(xpath = "//button[@class='f09d600 ic6qv70 l56esf2 l56esf0 l56esfi']")
    private WebElement sectionIcons;

    @FindBy(xpath = "(//button[@class='f09d600 ic6qv70 l56esf2 l56esf0 l56esfi'])[4]")
    private WebElement downloadSections;

    @FindBy(xpath = "//button[@class='_82hq4b0 _141c7590 _141c7590 ic6qv70 _1092chna l56esf2 l56esf0 l56esfi _1092chn7 _1092chn0 puylxo0 puylxo6 _1092chnd _1092chne _1092chni']//button[@class='_82hq4b0 _141c7590 _141c7590 ic6qv70 _1092chna l56esf2 l56esf0 l56esfi _1092chn7 _1092chn0 puylxo0 puylxo6 _1092chnd _1092chne _1092chni']")
    private WebElement motionSection;

    @FindBy(css = "div[class='foundry_a86h3z_okz6z28 foundry_a86h3z_8kowh41 foundry_a86h3z_okz6z29 foundry_a86h3z_okz6z24 foundry_a86h3z_okz6z25']")
    private WebElement reduceMotion;


    @FindBy(xpath = "//a[@href='/VI/downloads']")
    private WebElement allDownloadsButton;



    public AllGamesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void playGta6GameVideo() throws InterruptedException {
        gta6Posture.click();
        videoPlayButton.click();
        driver.switchTo().frame(iframe);
        fullScreenSection.click();
        Thread.sleep(50000);
        fullScreenSection.click();
        driver.switchTo().defaultContent();
        closePage.click();
    }

    public void inspectSections() {
        menuSection.click();
        for (int i = 0; i < 4; i++) {
            sectionIcons.click();
        }
        motionSection.click();
        reduceMotion.click();
    }

    public WebElement checkGta6icon() {
     WebElement icon = gta6Icon;
     return icon;

    }

    public WebElement getGta6Picture(){
        WebElement picture = gta6Picture;
        return  gta6Picture;

    }

    public String gta6PictureProperty(){
        String property = gta6Picture.getDomAttribute("class");
        return property;
    }

    public void seeAllDownloads(){
        menuSection.click();
       downloadSections.click();
    }

    public String getTextOfAllDownloadsSection(){
       return allDownloadsButton.getText();
    }

    public void navigateAllDownloadsPage(){
        allDownloadsButton.click();
    }




}








