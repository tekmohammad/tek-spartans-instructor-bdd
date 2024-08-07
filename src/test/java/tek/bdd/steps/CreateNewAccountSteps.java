package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.AccountPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomGenerator;
import tek.bdd.utility.SeleniumUtility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CreateNewAccountSteps extends SeleniumUtility {
    private static String emailToUse;

    @When("user enter {string} and {string}  and {string}")
    public void userEnterNewAccountInfo(String name, String email, String password) {

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail() : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);

    }

    @Then("validate user is in account page")
    public void validateUserInAccountPage() {
        String actualText = getElementText(AccountPage.PROFILE_PAGE_TITLE);

        Assert.assertEquals("Account page should contains Your Profile Text"
                , "Your Profile", actualText);
    }

    @Then("validate email address in account page match")
    public void validateEmailAddressInAccountPageMatch() {
        String actualEmail = getElementText(AccountPage.PROFILE_EMAIL_TEXT);

        Assert.assertEquals("Email in Account page should match with email used in create account step",
                emailToUse, actualEmail);
    }

    @When("user enter new account info")
    public void user_enter_new_account_info(DataTable dataTable) {
        //Converting data table to Map<String, String>
        Map<String, String> data = dataTable.asMap();
        String email = data.get("email");
        String name = data.get("name");
        String password = data.get("password");

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail() : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @When("user enter new account info using list Data")
    public void user_enter_new_account_info_using_list_data(DataTable dataTable) {
        //Convert Data Table to List.
        List<String> data = dataTable.asList();
        String name = data.get(0);
        String email = data.get(1);
        String password = data.get(2);

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail() : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @When("user enter new account as list of list")
    public void user_enter_new_account_as_list_of_list(DataTable dataTable) {
        //convert data table to List of List
        List<List<String>> data = dataTable.asLists();
        String name = data.get(0).get(0);
        String email = data.get(0).get(1);
        String password = data.get(0).get(2);

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail() : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @When("user enter new account as list of maps")
    public void user_enter_new_account_as_list_of_maps(DataTable dataTable) {
        //Converting data table to list of Maps
        List<Map<String, String>> data = dataTable.asMaps();

        String email = data.get(0).get("email");
        String name = data.get(0).get("name");
        String password = data.get(0).get("password");

        emailToUse = email.equalsIgnoreCase("random")
                ? RandomGenerator.generateRandomEmail() : email;

        sendText(SignUpPage.NAME_INPUT, name);
        sendText(SignUpPage.EMAIL_INPUT, emailToUse);
        sendText(SignUpPage.PASSWORD_INPUT, password);
        sendText(SignUpPage.CONFIRM_PASSWORD, password);
    }

    @Then("validate field error messages")
    public void validate_field_error_messages(DataTable dataTable) {
        // Converting data table to list
        List<String> expectedData = dataTable.asList();

        //GetActual Data
        List<WebElement> errorElements = getElements(SignUpPage.ERROR_MESSAGE);
        Assert.assertEquals("Number of Error message should be same as Expected",
                expectedData.size(),
                errorElements.size());

        for (int index = 0; index < expectedData.size(); index++) {
            String expected = expectedData.get(index);
            String actual = errorElements.get(index).getText();

            Assert.assertEquals("Error Message should match",
                    expected,
                    actual);
        }

    }

    @Then("validate field error messages using map")
    public void validate_field_error_messages_using_map(DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMap();

        List<WebElement> errorElements = getElements(SignUpPage.ERROR_MESSAGE);
        Assert.assertEquals("Number of Error message should be same as Expected",
                expectedData.size(),
                errorElements.size());

        Map<String, String> actualErrors = new HashMap<>();
        for(WebElement element : errorElements) {
            String text = element.getText();
            String key = text.split(" ")[0];
            actualErrors.put(key, text);
        }

        for (String key : expectedData.keySet()) {
            Assert.assertEquals("Error Message should match",
                    expectedData.get(key),
                    actualErrors.get(key));
        }


//        Assert.assertEquals("Error Message should match",
//                expectedData.get("name"),
//                errorElements.get(0).getText());
//        Assert.assertEquals("Error Message should match",
//                expectedData.get("email"),
//                errorElements.get(1).getText());
//        Assert.assertEquals("Error Message should match",
//                expectedData.get("password"),
//                errorElements.get(2).getText());
//        Assert.assertEquals("Error Message should match",
//                expectedData.get("confirm"),
//                errorElements.get(3).getText());

    }
}
