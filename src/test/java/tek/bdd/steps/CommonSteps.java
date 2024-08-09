package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.AccountPage;
import tek.bdd.utility.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {
    @Given("user click on {string} link")
    public void userClickOnLinks(String linkText) {
        clickOnElement(By.linkText(linkText));
    }


    @When("user click on {string} button")
    public void user_click_on_button(String buttonVisibleText) {

        String buttonXpath = "//button[text()='" + buttonVisibleText + "']";

        clickOnElement(By.xpath(buttonXpath));

    }

    @When("user enter {string} on {string} field")
    public void userEnterTextToAnyField(String text, String fieldName) {
        String xpath = " //label[text()='"+fieldName+"']/..//input";
        sendText(By.xpath(xpath), text);
    }

    @Then("validate Toast Displayed")
    public void validate_toast_displayed() {
       boolean isToastDisplayed  = isElementDisplayed(AccountPage.TOAST_BOX);
        Assert.assertTrue("Toast Should Displayed", isToastDisplayed);
    }

    @When("wait for {} seconds")
    public void waitForSeconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }



}
