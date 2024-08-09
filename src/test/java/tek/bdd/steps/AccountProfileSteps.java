package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import tek.bdd.pages.AccountPage;
import tek.bdd.utility.SeleniumUtility;

public class AccountProfileSteps extends SeleniumUtility {

    @Then("validate account name is {string}")
    public void validateAccountProfileName(String expectedProfileName) {
        String actualProfileName = getElementText(AccountPage.ACCOUNT_PROFILE_NAME_TEXT);

        Assert.assertEquals("Account Profile should Match ",
                expectedProfileName,
                actualProfileName);
    }
}
