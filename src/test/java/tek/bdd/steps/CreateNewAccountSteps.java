package tek.bdd.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.AccountPage;
import tek.bdd.pages.SignUpPage;
import tek.bdd.utility.RandomGenerator;
import tek.bdd.utility.SeleniumUtility;

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
       String actualText  = getElementText(AccountPage.PROFILE_PAGE_TITLE);

        Assert.assertEquals("Account page should contains Your Profile Text"
                ,"Your Profile", actualText);
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
        List<Map<String, String>> data= dataTable.asMaps();

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
}
