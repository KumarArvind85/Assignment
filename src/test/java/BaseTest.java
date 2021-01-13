import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.DriverManager;
import selenium.DriverManagerFactory;
import selenium.DriverType;

public class BaseTest {

    protected DriverManager driverManager;
    protected WebDriver driver;

    @BeforeSuite
    public void setUp(){
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
