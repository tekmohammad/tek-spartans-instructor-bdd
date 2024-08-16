package tek.bdd.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import java.time.Duration;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    private WebElement waitForVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickOnElement(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator))
                .click();
        LOGGER.info("Clicking on Element {}", locator);
    }
    public void clickOnElement(WebElement locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator))
                .click();
        LOGGER.info("Clicking on Element {}", locator);
    }

    public void sendText(By locator, String value) {
        LOGGER.info("Clearing And Sending text {} to locator {}", value, locator);
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(value);
    }

    //Create method for getting the text of a locator
    public String getElementText(By locator) {
        LOGGER.info("Get Element text {}", locator);
        return waitForVisibility(locator).getText();
    }

    public boolean isElementEnabled(By locator) {
        LOGGER.info("Checking element is Enabled {}", locator);
        return waitForVisibility(locator)
                .isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
        LOGGER.info("Checking element is Displayed {}", locator);
        return waitForVisibility(locator)
                .isDisplayed();
    }

    public byte[] takeScreenShot() {
        TakesScreenshot screenShot = (TakesScreenshot) getDriver();
        return screenShot.getScreenshotAs(OutputType.BYTES);
    }

    public List<WebElement> getElements(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
