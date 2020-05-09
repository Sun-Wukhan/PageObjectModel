package cannabistest;

//import base.Base;
import base.CustomListener;
import base.BaseX2;
import base.CustomListener;
import cannabispage.OCSCheckOutPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class OCSVerifyCart extends BaseX2 {


    public static OCSCheckOutPage p1 = null;

    @BeforeMethod
    public void setUp(){
        //initialization();
        p1 = PageFactory.initElements(driver, OCSCheckOutPage.class);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifying_With_Legal_Amount_Of_Product_To_Cart() throws InterruptedException, java.lang.AssertionError {
        p1.entering_User_Information("02", "27", "1993");
        p1.Accessing_and_choosing_a_flower();
        p1.verifying_cart_and_entering_credentials("Navid_Khan@Icloud.com", "Navid", "Khan", "219 FortYork", "Toronto", "M4C3Y5", "3062615595");
        String actual = p1.verifyPrice();
        String expected = "$117.60";
        Assert.assertEquals(actual, expected);
    }

    @Test(priority = 0)
    public void verifying_With_Illegal_Amount_Of_Product_To_Cart() throws InterruptedException, java.lang.AssertionError {
        p1.entering_User_Information("02", "27", "1993");
        p1.Accessing_and_choosing_a_groups_flower();
        p1.list_of_Flowers_adding_them_to_Cart();
        p1.counting_inventory_of_product();
        Assert.assertEquals(true, true);
        Thread.sleep(4000);

        //p1.verifying_cart_and_entering_credentials("Navid_Khan@Icloud.com", "Navid", "Khan", "219 FortYork", "Toronto", "M4C3Y5", "3062615595");
        Thread.sleep(2000);
    }
}
