package PracticeFrontPage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPageAutomation {

    private WebDriver driver;
    String baseURL = "http://automationpractice.com/index.php";

    @FindBy(id = "search_query_top")
    WebElement searchOption;
    //type in shirt to search

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    WebElement searchButton;
    //This is the search Button, you already know

    @FindBy(xpath = "//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img")
    WebElement fadedShirt;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]")
    WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement continueOn;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedingCheckout;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/span[3]")
    WebElement showCart;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span/i")
    WebElement textTime;

    @FindBy(id = "email")
    WebElement emailPanel;


    public FrontPageAutomation(WebDriver driver) {
        this.driver = driver;
        driver.get(baseURL);
        PageFactory.initElements(driver, this);
        //Remember Getter and Setter Method
        //ALWAYS PUBLIC
    }

    public void findShirt(String search) {
        searchOption.sendKeys(search);
        searchButton.click();
        //THESE ARE YOUR ACTIONS
    }

    public void add_shirt_to_cart() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(fadedShirt);
        act.moveToElement(addToCart).click();
        act.build().perform();
        Thread.sleep(2000);
        driver.switchTo().activeElement();
        continueOn.click();

    }

    public void proceedWithPurchase(String email) throws InterruptedException {
        proceedingCheckout.click();
        emailPanel.sendKeys(email);

    }
}



