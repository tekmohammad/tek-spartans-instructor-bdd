package tek.bdd.pages;

import org.openqa.selenium.By;

public class ShoppingCartPage {

    public static final By CART_ITEM_LIST = By.xpath("//div[@class='cart__item']");
    public static final By ALL_ITEMS_DELETE = By.xpath("//div[@class='cart__item']//span[@class='cart__item-delete']");
    public static final By CART_EMPTY_TITLE = By.className("cart__empty-title");

}
