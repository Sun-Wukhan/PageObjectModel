//package base;
//
//import cannabispage.OCSCheckOutPage;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.utils.FileUtil;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//public class Base {
//
//    public static WebDriver driver;
//    public static String baseURL = "https://ocs.ca/";
//
//
//    public static void initialization(){
//        System.setProperty("webdriver.chrome.driver", "/Users/navid/Documents/IzaanProject/src/main/drivers/chromedriver");
//        driver = new ChromeDriver();
//        driver.get(baseURL);
//        driver.manage().window().fullscreen();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//
//    }
//
//    public void failedTest(String testMethodName) throws IOException {
//       File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(srcFile, new File("/Users/navid/" +
//                "Documents/OntarioCannabisStore/ScreenShots/"+ testMethodName+"_"+".jpg"));
//
//    }

//}
