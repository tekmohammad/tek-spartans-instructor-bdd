package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.utility.SeleniumUtility;

public class SetupTestSteps extends SeleniumUtility {

    @Given("Open browser and navigate to retail app")
    public void openBrowserAndNavigate() {
        setupBrowser();
    }

    @Then("validate top left corner is TEKSCHOOL")
    public void validateTopLeftLogo() {
       String topLeftCornerText = getElementText(By.className("top-nav__logo"));

        Assert.assertEquals("TEKSCHOOL" , topLeftCornerText);
    }

    @Then("Close the browser")
    public void closeBrowser() {
        quitBrowser();
    }
}
