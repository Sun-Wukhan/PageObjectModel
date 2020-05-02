package Izaanlogintest;

import izaandirectory.IzaanLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class IzaanLogInTest {

    WebDriver driver;
    String baseURL = "https://www.izaan.io/";
    IzaanLoginPage p1;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/navid/Documents/IzaanProject/src/main/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseURL);
        p1 =  new IzaanLoginPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void login() throws AWTException, InterruptedException {
        p1.navigateToSite("Navi", "Adina123!");
        p1.watchVidsNow();

    }
}


