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
        LOGGER.info("Clicking on Element {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public void sendText(By locator, String value) {
        LOGGER.info("Sending text {} to locator {}", value, locator);
        waitForVisibility(locator).sendKeys(value);
    }

    //Create method for getting the text of a locator
    public String getElementText(By locator) {
        return waitForVisibility(locator).getText();
    }

    public boolean isElementEnabled(By locator) {
        return waitForVisibility(locator)
                .isEnabled();
    }

    public boolean isElementDisplayed(By locator) {
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
