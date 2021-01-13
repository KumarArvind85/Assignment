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
        System.setProperty("webdriver.gecko.driver", "/Users/arvindkumar/Downloads/geckodriver");
        //System.setProperty("webdriver.firefox.bin","/Applications/Firefox.app/Contents/MacOS/firefox-bin");

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
