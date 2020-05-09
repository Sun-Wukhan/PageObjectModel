package base;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class ReporterMethods {
    /**
     * This class will have all the common methods/helper methods
     */
    static WebDriver driver = null;


    public static void sendKeys(String webElementName, WebElement element, String textToSend) {
        Reporter.log("Send keys to: " + webElementName);
        element.sendKeys(textToSend);
        Reporter.log("Sent keys to: " + webElementName);

    }

    public static void click(WebElement element, String elementName) {
        Reporter.log("Click on: " + elementName);
        element.click();
        Reporter.log("Clicked on: " + elementName);
    }

    public static void selectByIndex(WebElement element, int i) {
        Select select = new Select(element);
        Reporter.log("Select option at index: " + i);
        select.selectByIndex(i);
        Reporter.log("Selected option at index: " + i);

    }

    public static String getText(WebElement webElement, String webElementName) {

        Reporter.log("Getting Text from: " + webElementName);
        String actualText = webElement.getText();
        Reporter.log("Actual text: " + actualText);
        return actualText;
    }

    // Implement for click
    // Handle drop down

    public void waitUntilElementIsPresentUsingIDLocator(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    // 5 every 6sec
    public void fluentWait() {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

                //Wait for the condition
                .withTimeout(30, TimeUnit.SECONDS)
                // which to check for the condition with
                .pollingEvery(6, TimeUnit.SECONDS)
                //Which will ignore the NoSuchElementException
                .ignoring(NoSuchElementException.class);
    }
}
