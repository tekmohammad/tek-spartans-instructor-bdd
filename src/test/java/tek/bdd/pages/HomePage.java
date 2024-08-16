package tek.bdd.pages;

import org.openqa.selenium.By;

public class HomePage {

    //POM is design pattern where class contains All the elements
    // of a Web App Page. Each page should have respective java class to store its elements
    public static final By SING_IN_LINK = By.id("signinLink");

    public static final By ACCOUNT_LINK = By.id("accountLink");

    public static final By SEARCH_BAR_INPUT = By.id("searchInput");

    public static final By SEARCH_BUTTON = By.id("searchBtn");

    public static final By ALL_SEARCH_RESULTS_TITLE = By.xpath("//div[@class='products']/div//p[@class='products__name']");
    public static final By FIRST_SEARCHED_PRODUCT_TITLE = By.xpath("//div[@class='products']/div[1]//p[@class='products__name']");
    public static final By CART_LINK = By.id("cartBtn");



}
