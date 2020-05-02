package izaandirectory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;

public class IzaanLoginPage {

    WebDriver driver;
    String url;

    @FindBy(xpath = "//a[@href='/signIn']")
    WebElement signInBtn;

    @FindBy(xpath = "/html/body/app-root/app-common-layout/app-signin/section/div/div/div[3]/div/button")
    WebElement traineeSignIn;

    @FindBy(id = "email")
    WebElement userEmail;

    @FindBy(id = "password")
    WebElement userPass;

    @FindBy(id = "btnSignIn")
    WebElement finalClick;

    @FindBy(xpath = "//a[contains(text(),'videos(')]")
    WebElement videoFinder;

    @FindBys({@FindBy(xpath = "//li/a[contains(text(),'Class_')]")})
    List<WebElement> linkOfVideos;

    public IzaanLoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToSite(String email, String pw) throws InterruptedException, AWTException {

        Actions act = new Actions(driver);
        act.moveByOffset(1116, 40); //identify the x,y coordinates
        act.build().perform(); // .perform is needed
        Thread.sleep(3000);
        signInBtn.click();

        Thread.sleep(1000);

        traineeSignIn.click();

        userEmail.sendKeys(email);
        userPass.sendKeys(pw);

        finalClick.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.equals(ExpectedConditions.elementToBeSelected(videoFinder));
        videoFinder.click();
        Thread.sleep(2000);
        watchVidsNow();

    }

    public void watchVidsNow() {

        for (int i = 0; i < linkOfVideos.size(); i++) {

            System.out.println("https://qaae-class-videos.s3.amazonaws.com/QAAE2001/" + linkOfVideos.get(i).getText() + ".mp4");
        }
    }
}

