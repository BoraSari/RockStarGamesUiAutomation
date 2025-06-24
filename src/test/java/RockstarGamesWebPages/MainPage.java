package RockstarGamesWebPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MainPage extends BasePage{
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor executor = ((JavascriptExecutor)driver);
    protected Wait<WebDriver> wait;


    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div/button")
    private WebElement closeButton;

    @FindBy(css = "button > img[src='https://media-rockstargames-com.akamaized.net/mfe6/prod/__common/img/af22c6826e05c14923a3f11c69a2130c.svg']")
    private WebElement gamesSectionArrow;

    @FindBy(xpath = "//*//a[@href='/games'][1]")
    private WebElement viewAllGames;

    @FindBy(css = "div[class='rockstargames-modules-core-headerda487b6de58442100c2513ac095f3c6a']")
    private WebElement rockstarLogo;

   @FindAll(@FindBy(xpath = "//section//button[@data-gtm-action='Dot click']"))
    private List<WebElement>  gameSectionButtons;

    @FindBy(xpath = "//div//h2[contains(text(),'Now on PC')]")
    private  WebElement pcCheckMessage;

    @FindBy(id = "onetrust-close-btn-container")
    private WebElement cookieSection;


    @FindBy(xpath = "(//div[@class='rockstargames-sites-rockstargamesfd37974f16cd1f2376fef29d4af8d948 rockstargames-sites-rockstargamesb8d4ef3e1a73c58f4002eab351d4eec2'])[4]")
    private WebElement rdr2Picture;




    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public WebElement checkRockstarGamesLogo(){
        WebElement logo = rockstarLogo;
        return logo;
    }

    public void checkGameNewsSections() {

        for(WebElement sectionButtons:gameSectionButtons){
            getActionsFunctions().moveToElement(sectionButtons).build().perform();
            sectionButtons.click();
        }

    }

    public WebElement checkMessage(){
        WebElement message = pcCheckMessage;
        return message;
    }

    public void closeFirstPage(){

        executor.executeScript("arguments[0].click();",closeButton);
    }


    public void closeCookies(){
        cookieSection.click();
    }

    public void playRdr2Trailer()  {
        Actions actions = new Actions(driver);
        actions.moveToElement(rdr2Picture).click(rdr2Picture).build().perform();

    }









}
