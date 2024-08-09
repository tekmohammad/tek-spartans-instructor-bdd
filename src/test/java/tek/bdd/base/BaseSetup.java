package tek.bdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import tek.bdd.browsers.BaseBrowser;
import tek.bdd.browsers.ChromeBrowser;
import tek.bdd.browsers.EdgeBrowser;
import tek.bdd.browsers.FireFoxBrowser;

import javax.swing.plaf.metal.MetalLookAndFeel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    //Encapsulating driver instance
    private static WebDriver driver;
    private final Properties properties;

    //Find the full path to file
    //FileInputStream to read the file
    //Properties and load the FileInputStream to the properties
    public BaseSetup() {
        //System.getProperty("user.dir") return the locator of your project.
        try {
            String configFilePath = System.getProperty("user.dir") +
                    "/src/test/resources/configs/dev-config.properties";
            LOGGER.info("Reading Config file " + configFilePath);
            File file = new File(configFilePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException ex) {
            LOGGER.error("Error reading config file", ex);
            throw new RuntimeException("Something wrong with Config file", ex);
        }
    }

    public void setupBrowser() {
        //To Open Chrome browser in headless mode
        String browserType = properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Running on browser {} and isHeadless {}", browserType, isHeadless);
        BaseBrowser browser;

        if(browserType.equalsIgnoreCase("chrome"))
            browser = new ChromeBrowser();
        else if (browserType.equalsIgnoreCase("edge"))
            browser = new EdgeBrowser();
        else if (browserType.equalsIgnoreCase("firefox"))
            browser = new FireFoxBrowser();
        else
            throw new RuntimeException("Wrong browser type choose between chrome, firefox or edge");

       driver = browser.openBrowser(isHeadless);

        String url = properties.getProperty("ui.url");
        LOGGER.debug("Using URL {}", url);
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
