package RockstarGamesWebPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected String baseUrl = "https://www.rockstargames.com/";
    protected WebDriver driver;
    protected WebDriverWait wait;


     public BasePage(WebDriver driver){
         this.driver=driver;
     }

     protected Wait<WebDriver> getFluentWait(){
         return  new FluentWait<WebDriver>(driver)
                 .withTimeout(Duration.ofSeconds(30))
                 .ignoring(NoSuchElementException.class)
                 .pollingEvery(Duration.ofSeconds(5))
                 .withMessage("Fluent wait can't be started.");
     }

     protected JavascriptExecutor getExecutor(){
         JavascriptExecutor js = ((JavascriptExecutor)driver);
         return js;
    }

    protected  String getPageSources(){
         return  driver.getPageSource();
    }


    protected Actions getActionsFunctions(){
         Actions actions = new Actions(driver);
         return actions;
    }
    protected   String getPageTitle(){
         return  driver.getTitle();
    }
    protected WebDriverWait getExpilictWait(){
         wait = new WebDriverWait(driver,Duration.ofSeconds(10));
         wait.ignoring(NoSuchElementException.class)
                 .withTimeout(Duration.ofSeconds(30));
         return wait;
    }
}
