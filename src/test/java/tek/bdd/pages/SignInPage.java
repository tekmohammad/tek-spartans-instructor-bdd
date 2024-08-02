package tek.bdd.pages;

import org.openqa.selenium.By;

public class SignInPage {

    public static final By PAGE_SUBTITLE = By.className("login__subtitle");

    public static final By EMAIL_INPUT = By.name("email");

    public static final By PASSWORD_INPUT = By.name("password");

    public static final By LOGIN_BUTTON = By.id("loginBtn");

    public static final By ERROR_MESSAGE = By.className("error");

}
