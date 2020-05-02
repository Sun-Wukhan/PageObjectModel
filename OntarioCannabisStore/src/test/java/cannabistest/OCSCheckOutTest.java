package cannabistest;

import cannabispage.OCSCheckOutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OCSCheckOutTest {

    WebDriver driver;
    String baseURL = "https://ocs.ca/";
    OCSCheckOutPage p1;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/navid/Documents/IzaanProject/src/main/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseURL);
        p1 =  new OCSCheckOutPage(driver);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }

    @Test(priority = 0)
    public void legal_Entry_Authorization() throws InterruptedException {
        p1.entering_User_Information();
        Reporter.log("Verified Age requirements to access page", true);

    }

    @Test(priority = 1)
    public void selecting_a_cannabis_product() throws InterruptedException {
        p1.choosing_Flowers_To_AddToCart();
        Reporter.log("Choosing a strain of cannabis product to add to cart");

    }

    @Test(priority = 2)
    public void verifying_Products_In_Cart() throws InterruptedException {
        p1.checking_Product_In_Cart();

    }
}
