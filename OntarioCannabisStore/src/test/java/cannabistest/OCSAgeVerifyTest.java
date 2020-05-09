package cannabistest;

//import base.Base;
//import base.CustomListener;
import base.BaseX2;
//import base.CustomListener;
import cannabispage.OCSCheckOutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

//@Listeners(CustomListener.class)
public class OCSAgeVerifyTest extends BaseX2 {

    public static OCSCheckOutPage p1 = null;

    @BeforeMethod
    public void setUp() {
        //initialization();
        p1 = PageFactory.initElements(driver, OCSCheckOutPage.class);

    }


    @Test(priority = 0)
    public void valid_Legal_Age_Credentials() throws InterruptedException, java.lang.AssertionError {
        p1.entering_User_Information("02", "27", "1993");
        String actual = driver.getTitle();
        Thread.sleep(2000);
        String expected = "Ontario Cannabis Store | Ontario Cannabis Store";
        Assert.assertEquals(actual, expected);
        Reporter.log("Verified Age requirements to access page", true);

    }

    @Test(priority = 1)
    public void invalid_Legal_Age_Credentials() throws InterruptedException, java.lang.AssertionError {
        p1.entering_User_Information("01", "05", "2015");
        Thread.sleep(2000);
        String actual = p1.access_To_Page_Denied();
        String expected =  "Unfortunately, you need to be over the age of 19 to access this website.";
        Assert.assertEquals(actual, expected);
        Reporter.log("Verified age requirements denied access to page", true);


    }
}
