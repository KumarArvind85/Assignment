import org.testng.annotations.Test;
import pages.RegistrationTogglePage;
import pages.TOISignUpPage;

import java.util.concurrent.TimeUnit;

public class TestRegistration extends BaseTest {

    @Test
    public void navigateToGmailTests() throws InterruptedException {
        driver.get("https://timesofindia.indiatimes.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        TOISignUpPage page = new TOISignUpPage(driver);
        RegistrationTogglePage rp = page.clickSignIn();
        //rp.provideEmailForSignUp(Utils.getProperty("email")); -- Use it only to read email supplied from build
        rp.provideEmailForSignUp("arvind.at22@gmail.com");
        rp.clickContinue();
        rp.generateOtp();
        rp.validateOtp();

    }
}
