package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.HomePage;
import tek.bdd.pages.ShoppingCartPage;
import tek.bdd.utility.SeleniumUtility;

import java.util.List;

public class ProductAndOrderSteps extends SeleniumUtility {

    @When("user enter {string} on search bar and click search")
    public void user_enter_on_search_bar_and_click_search(String searchText) {
        sendText(HomePage.SEARCH_BAR_INPUT, searchText);
        clickOnElement(HomePage.SEARCH_BUTTON);
    }

    @Then("validate search result contains {string} for all products")
    public void validate_search_result_contains_for_all_products(String exptectedSearchKeyword) {
        List<WebElement> elements = getElements(HomePage.ALL_SEARCH_RESULTS_TITLE);

        for (WebElement element : elements) {
            Assert.assertTrue(element.getText()
                    .toLowerCase().contains(exptectedSearchKeyword
                            .toLowerCase()));
        }
    }

    @When("user click on first item in search result")
    public void user_click_on_first_item_in_search_result() {
            clickOnElement(HomePage.FIRST_SEARCHED_PRODUCT_TITLE);
    }

    @Then("verify {int} item in the cart list")
    public void verify_item_in_the_cart_list(int expectedCartSize) {
        List<WebElement> cartItems = getElements(ShoppingCartPage.CART_ITEM_LIST);
        Assert.assertEquals(cartItems.size(), expectedCartSize);
    }

    @When("user delete all items in cart")
    public void user_delete_all_items_in_cart() {
//        getElements(ShoppingCartPage.ALL_ITEMS_DELETE)
//                .forEach(each -> {
//                    clickOnElement(each);
//                });

        List<WebElement> elements = getElements(ShoppingCartPage.ALL_ITEMS_DELETE);
        for(WebElement each : elements) {
            clickOnElement(each);
        }
    }

    @Then("validate shopping cart is empty")
    public void validate_shopping_cart_is_empty() {
       boolean isDisplayed = isElementDisplayed(ShoppingCartPage.CART_EMPTY_TITLE);
       Assert.assertTrue("Cart Empty title should display", isDisplayed);
    }

}
