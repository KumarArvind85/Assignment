package selenium;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class ChromeDriverManager extends DriverManager{
    @Override
    protected void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/arvindkumar/Downloads/chromedriver");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-data-dir=" + "/Users/arvindkumar/Library/Application Support/Google/Chrome");
        options.addArguments("profile-directory=Default");
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        this.driver = new ChromeDriver(options);
    }
}
