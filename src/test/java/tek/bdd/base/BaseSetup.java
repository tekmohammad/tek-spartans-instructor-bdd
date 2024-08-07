package tek.bdd.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {

    //Encapsulating driver instance
    private static WebDriver driver;
    private Properties properties;

    //Find the full path to file
    //FileInputStream to read the file
    //Properties and load the FileInputStream to the properties
    public BaseSetup() {
        //System.getProperty("user.dir") return the locator of your project.
        try {
            String configFilePath = System.getProperty("user.dir") +
                    "/src/test/resources/configs/dev-config.properties";
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        }catch (IOException ex) {
            throw new RuntimeException("Something wrong with Config file", ex);
        }
    }

    public void setupBrowser() {
        driver = new ChromeDriver();
       String url = properties.getProperty("ui.url");
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void quitBrowser() {
        //null check before quit
        if (driver != null) {
            driver.quit();
        }
    }

    //Giving read-only indirect access to driver.
    //restrict setting new driver instance
    public WebDriver getDriver() {
        return driver;
    }
}
