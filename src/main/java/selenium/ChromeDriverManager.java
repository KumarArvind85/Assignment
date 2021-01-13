package selenium;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Collections;

public class ChromeDriverManager extends DriverManager{
    @Override
    protected void createWebDriver() {
        String path = "src/main/resources/drivers/chromedriver";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("profile-directory=Default");
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        this.driver = new ChromeDriver(options);
    }
}
