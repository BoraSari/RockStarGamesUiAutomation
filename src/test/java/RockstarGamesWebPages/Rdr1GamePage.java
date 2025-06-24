package RockstarGamesWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Rdr1GamePage extends BasePage{

    @FindBy(css = "a[data-gtm-label='reddeadredemption']")
    private WebElement rdr1GamePoster;

    @FindBy(xpath = "//img[@class='rockstargames-sites-legacyc7a9346aef47e925c8207d4c29dd62cf rockstargames-sites-legacyc1e80852d004d7874de4d4d292a8ac35']")
    private WebElement platformsPcIcon;

    @FindBy(css = "div[class='rockstargames-sites-legacyee2f948c8cdbaa179e237743a7fed85b ']")
    private WebElement allPlatforms;

    @FindBy(css = "div[class='rockstargames-sites-legacyb8ca1e26cdff51b56d4e2d18bed40b40']")
    private WebElement avabilityMessageForAllPlatforms;

    @FindBy(xpath = "//div[contains(text(),'Watch Trailer')]")
    private WebElement trailerStartButton;

    @FindBy(xpath = "//button[@style='opacity: 1;'][1]")
    private WebElement closeButton;

    @FindBy(xpath = "//div[contains(text(),'Buy Now')][1]")
    private WebElement buyNowButton;

    @FindAll(@FindBy(css = "a[data-variant='platform']"))
    private List<WebElement> allPlatformTitles;

    @FindBy(css = "svg[class='foundry_hcgxh_uaq1gw9 foundry_hcgxh_v1yii70 foundry_hcgxh_v1yii72']")
    private WebElement dropDownForLanguageChange;

    public Rdr1GamePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void clickRdr1GamePoster(){
        getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-gtm-label='reddeadredemption']")));
        getActionsFunctions().moveToElement(rdr1GamePoster).build().perform();
        rdr1GamePoster.click();
    }

    public void scrollDownThePage(){
        getExecutor().executeScript("arguments[0].scrollIntoView()",rdr1GamePoster);
    }

    public void  inspectAllPlatformnsIcons(){
        for (int i=0;i<4;i++){
            allPlatforms.click();
        }
    }
    public String getPlatformsMessage(){
        String message = avabilityMessageForAllPlatforms.getText();
        return message;
    }

    public void startTrailer(){
        trailerStartButton.click();
    }

    public void closeGameplayTrailerVideo(){
        getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@style='opacity: 1;'][1]")));
        closeButton.click();
    }

    public void clickBuyNowButton(){
        buyNowButton.click();
    }

    public List<WebElement> getAllPlatformTitles(){
        return allPlatformTitles;
    }

    public void changeLanguage(){
        getActionsFunctions().moveToElement(dropDownForLanguageChange).build().perform();
        dropDownForLanguageChange.click();
    }
}

