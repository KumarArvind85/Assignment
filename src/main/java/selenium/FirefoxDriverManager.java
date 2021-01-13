package selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.Collections;

public class FirefoxDriverManager extends DriverManager {

    @Override
    protected void createWebDriver() {
        String path = "src/main/resources/drivers/geckodriver";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.gecko.driver", absolutePath);

        DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setCapability("marionette", true);
        this.driver = new FirefoxDriver(cap);
        /*
        File pathToBinary = new File("/Users/arvindkumar/Downloads/geckodriver");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        this.driver = new FirefoxDriver(ffBinary,firefoxProfile);
        */

    }
}
