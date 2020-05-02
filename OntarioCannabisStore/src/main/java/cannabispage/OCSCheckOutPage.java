package cannabispage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OCSCheckOutPage {

    WebDriver driver;
    String baseURL = "https://ocs.ca/";

    @FindBy(xpath = "//*[@id=\"dob__month\"]")
    WebElement month;

    @FindBy(xpath = "//input[@id='dob__day']")
    WebElement day;

    @FindBy(xpath = "//input[@id='dob__year']")
    WebElement year;

    @FindBy(xpath = "//button[@class='btn btn--outline']")
    WebElement verifyIdentityButton;

    @FindBy(xpath = "//*[@id=\"shopify-section-en-header\"]/div/div[2]/div/div[1]/div[1]/nav/ul/li[1]/a")
    WebElement flowersMenu;

    @FindBy(xpath = "//*[@id=\"shopify-section-en-header\"]/div/div[2]/div/div[1]/div[1]/nav/ul/li[1]/div/div[2]/div[3]/a")
    WebElement showAllFlowers;

    @FindBy(xpath = "//label [@title='28g']")
    WebElement sizeOfFlower;

    @FindBy(xpath = "/html/body/div[1]/div[6]/section/div[2]/div[2]/div[2]/div/article[1]/div/div/div/div[2]/button")
    WebElement verifyPurchaseButton;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div/div[2]/div/div[2]/div[2]/div/div")
    WebElement viewShoppingCart;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div/form/div[3]/div[1]/div[2]/fieldset/label/span")
    WebElement agreeToTermsCheckBox;

    public OCSCheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this );
    }

    public void entering_User_Information() throws InterruptedException {
        month.sendKeys("02");
        //Thread.sleep(2000);
        day.sendKeys("27");
        //Thread.sleep(2000);
        year.sendKeys("1993");
        verifyIdentityButton.click();
        //Thread.sleep(2000);
        String actual = driver.getTitle();
        String expected = "Ontario Cannabis Store | Ontario Cannabis Store";
        Assert.assertEquals(actual, expected);

    }

    public void choosing_Flowers_To_AddToCart() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(flowersMenu).perform();
        Thread.sleep(2000);
        act.moveToElement(showAllFlowers).click().perform();
        act.build().perform();
        Thread.sleep(2000);
        sizeOfFlower.click();
        Thread.sleep(2000);
        verifyPurchaseButton.click();
        Thread.sleep(2000);
        String actual = viewShoppingCart.getText();
        String expected = "28.0 g / out of\n" +
                          "30g limit\n" +
                          "1\n" +
                          "$117.60";
        Assert.assertEquals(expected, actual);

    }

    public void checking_Product_In_Cart() throws InterruptedException {
        viewShoppingCart.click();
        //Alert alert = driver.switchTo().alert();
        //alert.dismiss();
        Thread.sleep(2000);
        agreeToTermsCheckBox.click();
        Thread.sleep(2000);
        //Alert alert = driver.switchTo().alert();
        //String word = alert.getText();
        //System.out.println(word);


    }
}
