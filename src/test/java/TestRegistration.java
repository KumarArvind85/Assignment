import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.RegistrationTogglePage;
import pages.TOISignUpPage;
import selenium.DriverManager;
import selenium.DriverManagerFactory;
import selenium.DriverType;

public class TestRegistration {

    DriverManager driverManager;
    WebDriver driver;

    @Test
    public void navigateToGmailTests() throws InterruptedException {

        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        driver.get("https://timesofindia.indiatimes.com/");
        Thread.sleep(10000);
        TOISignUpPage page = new TOISignUpPage(driver);
        RegistrationTogglePage rp = page.clickSignIn();
        rp.provideEmailForSignUp("arvind.at22@gmail.com");
        rp.clickContinue();
        rp.generateOtp();
        rp.validateOtp();

    }
}
