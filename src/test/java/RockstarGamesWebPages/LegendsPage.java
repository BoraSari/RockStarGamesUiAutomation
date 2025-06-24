package RockstarGamesWebPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LegendsPage extends BasePage{

    @FindBy(id = "monthInput")
    private WebElement monthField;

    @FindBy(id = "dayInput")
    private WebElement dayField;

    @FindBy(id = "yearInput")
    private WebElement yearField;

    @FindBy(xpath = "//button[@type=\"submit\"][1]")
    private WebElement submitButton;

    @FindBy(xpath = "//h2[contains(text(),'Legends and Killers Pack Trailer')]")
    private WebElement legendsAndKillersTitle;

    @FindBy(xpath = "//h2[contains(text(),'You may not view this content at this time')]")
    private WebElement contentNotAvaibleMessage;

    @FindBy(css = "div>button[data-testid='searchToggle']")
    private WebElement searchBoxIcon;

    @FindBy(xpath = "(//button[contains(text(),'Games')])[3]")
    private WebElement gamesSectionButton;

    @FindBy(css = "input[type='textfield']")
    private WebElement gameSearchInputField;


    public LegendsPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }



    public  void  filledAgeForm(String month,String day,String year){
        if (monthField.isDisplayed() && yearField.isDisplayed()&& dayField.isDisplayed()){
            monthField.sendKeys(month);
            dayField.sendKeys(day);
            yearField.sendKeys(year);
        }
        submitButton.click();

    }

    public void scrollDownThePage() throws InterruptedException {
        getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Legends and Killers Pack Trailer')]")));
        getExecutor().executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);


    }

    public void scrollUpThePage() throws InterruptedException {
        getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'You may not view this content at this time')]")));
        getExecutor().executeScript("window.scrollBy(0,-800)");
        Thread.sleep(2000);
    }

    public String getTitleOfLegendsTrailer(){
        String title = legendsAndKillersTitle.getText();
        return title;
    }

    public String getTagNameOfElement(){
        String tagNameOfElement =  legendsAndKillersTitle.getTagName();
        return tagNameOfElement;
    }

    public String getNotAvaibleMessageText(){
        String message = contentNotAvaibleMessage.getText();
        return message;
    }

    public WebElement checkAvabilityOfContentNotAvaibleMessage(){
        WebElement message = contentNotAvaibleMessage;
        return message;
    }


   public void clickSearchBoxIcon() {
        getExpilictWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div>button[data-testid='searchToggle']")));
       getActionsFunctions().moveToElement(searchBoxIcon).build().perform();
       searchBoxIcon.click();
    }


    public WebElement getSearchBoxIcon(){
        WebElement icon = searchBoxIcon;
        return icon;
    }

    public void clickGamesSectionButton(){
        gamesSectionButton.click();
    }

    public void searchGame(String gameName){
        gameSearchInputField.sendKeys(gameName+ Keys.ENTER);
    }

    public String getValueOfInputField(){
        String value = gameSearchInputField.getDomProperty("value");
        return value;
    }


    }




