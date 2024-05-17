package app.qonek.stepdefs;

import app.qonek.pages.LoginPage;
import app.qonek.pages.MenuBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;


public class LoginPageSteps {
    private LoginPage loginPage = new LoginPage();
    private MenuBar menuBar = new MenuBar();

    @Given("User sudah login")
    public void userSudahLogin() {
        loginPage.openWebPage();
        loginPage.inputEmail("qaautotest@gmail.com");
        loginPage.inputPassword("DevPassword772!");
        loginPage.clickButtonLogin();
        Assertions.assertTrue(menuBar.verifyAlreadyLogin());
    }
}
