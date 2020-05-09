package cannabispage;

// import base.Base;
import base.BaseX2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import base.ReporterMethods;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class OCSCheckOutPage extends BaseX2 {

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

    @FindBy(xpath = "//*[@id=\"shopify-section-overlay\"]/div/section/div/div[2]/div/p[3]")
    WebElement accessDenied;

    @FindBy(xpath = "//*[@id=\"shopify-section-en-header\"]/div/div[2]/div/div[1]/div[1]/nav/ul/li[1]/a")
    WebElement flowers;

    @FindBy(xpath = "//*[@id=\"shopify-section-en-header\"]/div/div[2]/div/div[1]/div[1]/nav/ul/li[1]/div/div[2]/div[3]/a")
    WebElement show_All_Flowers;

    @FindBy(xpath = "//*[@id=\"product_4362322544460--\"]/div/div/div/div[1]/fieldset/ul/li/label/div/span")
    WebElement gramsPerSale;

    @FindBys({@FindBy(xpath="//label[@title='28g']")})
    List <WebElement> allGramsPerSale;

    @FindBy(xpath = "//*[@id=\'product_4362322544460--\']/div/div/div/div[2]/button")
    WebElement AddToCart;

    @FindBys(@FindBy(xpath="//button[@class='btn btn--primary product-tile__button js-quick-add-button']"))
    List <WebElement> multiAddCart;

    @FindBy(xpath = "//*[@id=\"grams-tooltip-exceeded--header-flyout\"]/h4/span[2]")
    WebElement weightLimit;

    @FindBy(xpath = "//*[@id=\"tooltip_g992q4aexf\"]/div[2]/h5")
    WebElement overLoad;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div/div[2]/div/div[2]/div[2]/div/div")
    WebElement viewShoppingCart;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div/form/div[3]/div[1]/div[2]/fieldset/label/span")
    WebElement agreeToTermsCheckBox;

    @FindBy(xpath = "//button[@class='btn btn--primary full-width js-checkout-button']")
    WebElement checkOutButton;

    @FindBy(id = "checkout_email")
    WebElement emailField;

    @FindBy(id = "checkout_shipping_address_first_name")
    WebElement firstNameField;

    @FindBy(id = "checkout_shipping_address_last_name")
    WebElement lastNameField;

    @FindBy(id = "checkout_shipping_address_address1")
    WebElement addressField;

    @FindBy(id = "checkout_shipping_address_city")
    WebElement cityField;

    @FindBy(id = "checkout_shipping_address_zip")
    WebElement postalCodeField;

    @FindBy(id = "checkout_shipping_address_phone")
    WebElement phoneField;

    @FindBy(id = "continue_button")
    WebElement continueProcessButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/p[2]")
    WebElement pricePoint;


    public OCSCheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void entering_User_Information(String monthTime, String dayTime, String yearTime) throws InterruptedException {
        //month.sendKeys("02");
        ReporterMethods.sendKeys("Month", month, monthTime);
        //Thread.sleep(2000);
        //day.sendKeys("27");
        ReporterMethods.sendKeys("Day", day, dayTime);
        //Thread.sleep(2000);
        //year.sendKeys("1993");
        ReporterMethods.sendKeys("Year", year, yearTime);
        //verifyIdentityButton.click();
        ReporterMethods.click(verifyIdentityButton, "Identity");
        //Thread.sleep(2000);

    }

    public String access_To_Page_Denied() throws java.lang.AssertionError {
        String expected = ReporterMethods.getText(accessDenied, "DENIED");
        //access_To_Page_Denied();
        return expected;
    }

    public void Accessing_and_choosing_a_flower() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(flowers).perform();
        Thread.sleep(2000);
        act.moveToElement(show_All_Flowers).click().perform();
        act.build().perform();
        Thread.sleep(2000);
        ReporterMethods.click(gramsPerSale, "weight");
        //gramsPerSale.click();
        ReporterMethods.click(AddToCart, "add to Cart");
        Thread.sleep(2000);

    }

    public void Accessing_and_choosing_a_groups_flower() throws InterruptedException {
        Actions act = new Actions(driver);
        act.moveToElement(flowers).perform();
        Thread.sleep(2000);
        act.moveToElement(show_All_Flowers).click().perform();
        act.build().perform();
        Thread.sleep(2000);
    }

    public void list_of_Flowers_adding_them_to_Cart(){
        for(int i = 0; i<allGramsPerSale.size(); i++) {
            //allGramsPerSale.get(0).click();
            ReporterMethods.click(allGramsPerSale.get(0), "Strain of product, selecting weight");
            //allGramsPerSale.get(1).click();
            ReporterMethods.click(allGramsPerSale.get(1), "Strain of product, selecting weight");
            //allGramsPerSale.get(2).click();
            ReporterMethods.click(allGramsPerSale.get(2), "Strain of product, selecting weight");
        }
        for(int j = 0; j <multiAddCart.size(); j++){
            //multiAddCart.get(0).click();
            ReporterMethods.click(multiAddCart.get(0), "Adding the first item to cart");
            //multiAddCart.get(1).click();
            ReporterMethods.click(multiAddCart.get(1), "Adding the second item to cart");
            //multiAddCart.get(2).click();
            ReporterMethods.click(multiAddCart.get(2), "Adding the third item to cart");
        }
    }

    public void counting_inventory_of_product() throws InterruptedException {
        //viewShoppingCart.click();
        ReporterMethods.click(viewShoppingCart, "clicking on view shopping cart");
        Thread.sleep(2000);
        Actions act1 = new Actions(driver);
        act1.moveToElement(weightLimit).perform();
        act1.build().perform();
        Thread.sleep(3000);
    }

    public void verifying_cart_and_entering_credentials(String email, String namefirst, String nameLast, String address, String city, String postal, String number) throws InterruptedException {
        //viewShoppingCart.click();
        ReporterMethods.click(viewShoppingCart, "Viewing Shopping Cart");
        Thread.sleep(2000);
        //agreeToTermsCheckBox.click();
        ReporterMethods.click(agreeToTermsCheckBox, "Agreeing to Terms and Conditions");
        Thread.sleep(2000);
        //checkOutButton.click();
        ReporterMethods.click(checkOutButton, "Checking Out Button");
        //emailField.sendKeys(email);
        ReporterMethods.sendKeys("Insert Email here", emailField, email);
        //firstNameField.sendKeys(namefirst);
        ReporterMethods.sendKeys("Insert firstName Here", firstNameField, namefirst);
        //lastNameField.sendKeys(nameLast);
        ReporterMethods.sendKeys("Insert lastName Here", lastNameField, nameLast);
        // addressField.sendKeys(address);
        ReporterMethods.sendKeys("Insert Address Here", addressField, address);
        //cityField.sendKeys(city);
        ReporterMethods.sendKeys("Insert City here", cityField, city);
        //postalCodeField.sendKeys(postal);
        ReporterMethods.sendKeys("Insert postalcode here", postalCodeField, postal);
        //phoneField.sendKeys(number);
        ReporterMethods.sendKeys("Insert phone number here", phoneField, number);
        //continueProcessButton.click();
        ReporterMethods.click(continueProcessButton, "Continuing checkout Purchase");

        Thread.sleep(6000);
    }


    public String verifyPrice() {
        String actual = ReporterMethods.getText(pricePoint, "Price of Product");
        return actual;
    }

    public String overcapacity(){
        String actual = ReporterMethods.getText(overLoad, "The amount over the legal limit");
        return actual;
    }
}


