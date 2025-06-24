package RockstarGameTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.security.auth.RefreshFailedException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.file.ClosedFileSystemException;
import java.time.Duration;
import java.util.Locale;
import java.util.logging.Logger;

public class BaseTest {

    protected  static Logger logger  = Logger.getLogger(String.valueOf(BaseTest.class));
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected String baseUrl = "https://www.rockstargames.com/";
    protected  SoftAssert softAssert;



    protected WebDriver getDriver(){
        return driver.get();
    }

    @BeforeClass
    @Parameters({"browser"})
    public void setup(@NotNull String browser){
        logger.info("Paralel Test Browser setup");
        switch (browser.toLowerCase()){
                case "google":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                default: throw  new RuntimeException("Browsers can't started.");
            }
            logger.info("Required function  for Webdriver");
            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            getDriver().get(baseUrl);

    }

    @BeforeMethod
    public void setupSoftAssertion(){
        logger.info("Soft assertion setup");
        softAssert = new SoftAssert();
    }


    @AfterClass
    public void tearDown(){
        logger.info("Clean Web Driver after test");
        if (driver!=null){
            getDriver().quit();
            driver.remove();
        }
        softAssert.assertAll("All tests are succesfully asserted.");


    }

}
