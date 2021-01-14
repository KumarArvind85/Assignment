package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TOISignUpPage {

    protected WebDriver driver;

    public TOISignUpPage(WebDriver driver){
        this.driver=driver;
    }

    //private static String toiUrl = "https://timesofindia.indiatimes.com/";

    @FindBy(how= How.CSS, using="span.login")
    private WebElement signin;

    public RegistrationTogglePage clickSignIn(){
        WebDriverWait wait = getWaitObject(5);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("span.login"))));
        driver.findElement(By.cssSelector("span.login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#user-sign-in"))));
        return new RegistrationTogglePage(driver);
    }
    private WebDriverWait getWaitObject(int timeinseconds){
        return new WebDriverWait(driver,timeinseconds);
    }
}
