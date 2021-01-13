package pages;

import gmailAPI.GMail;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.DriverManager;
import selenium.DriverManagerFactory;
import selenium.DriverType;

import java.util.HashMap;

public class TOISignUpPage {
    //DriverManager driverManager;
    private WebDriver driver;


    public TOISignUpPage(WebDriver driver){
        this.driver=driver;
    }


    private static String toiUrl = "https://timesofindia.indiatimes.com/";

    @FindBy(how= How.CSS, using="span.login")
    private WebElement signin;


    public void openTOI( WebDriver driver){
        driver.get(toiUrl);
    }

    public void clickSignIn(){
        WebDriverWait wait = getWaitObject(5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("span.login"))));
        driver.findElement(By.cssSelector("span.login")).click();
        //WebDriverWait wait = getWaitObject(5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#user-sign-in"))));
    }

    public void provideEmailForSignUp(String emailId){
        driver.findElement(By.cssSelector("input[name=\"emailId\"]")).sendKeys(emailId);
    }

    public void clickContinue() throws InterruptedException {
        //WebDriverWait wait = getWaitObject(5);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input.submit-btn"))));
        Thread.sleep(30000);
        driver.findElement(By.cssSelector("input.submit-btn")).click();

    }

    public void generateOtp(){
        WebDriverWait wait = getWaitObject(3);
        driver.findElement(By.cssSelector("#sso-generate-otp")).click();
    }

    public void validateOtp(){
        HashMap<String,String> map = new HashMap<>();
        map = GMail.getGmailData("Code is 402543 for Times Internet Login Confirmation.");
        String sub = map.get("subject");
        System.out.println(map.get("subject"));
        System.out.println(map.get("body"));
        String otp = StringUtils.substringBetween(sub, "is", "for");
        WebDriverWait wait = getWaitObject(3);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[name=\"otplogin\"]"))));
        driver.findElement(By.cssSelector("input[name=\"otplogin\"]")).sendKeys(otp);
        driver.findElement(By.cssSelector("input.submit-btn")).click();
    }

    private WebDriverWait getWaitObject(int timeinseconds){
        return new WebDriverWait(driver,timeinseconds);
    }
}
