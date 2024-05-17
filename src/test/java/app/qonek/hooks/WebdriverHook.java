package app.qonek.hooks;

import app.qonek.driver.WebdriverInitializer;
import app.qonek.pages.LoginPage;
import app.qonek.pages.MenuBar;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;

import java.util.HashMap;

public class WebdriverHook {

    private LoginPage loginPage = new LoginPage();
    private MenuBar menuBar = new MenuBar();

    @Before
    public void webDriverInit() {
        if(WebdriverInitializer.getDriver() == null) {
            WebdriverInitializer.initialize();
            loginProcess();
        }else {
            menuBar.refreshPage();
            menuBar.waitABit(5);
        }
    }

    public void loginProcess(){
        loginPage.openWebPage();
        loginPage.inputEmail("qaautotest@gmail.com");
        loginPage.inputPassword("DevPassword772!");
        loginPage.clickButtonLogin();
        Assertions.assertTrue(menuBar.verifyAlreadyLogin());
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("QUITTING ALL WEBDRIVER");
        HashMap<String, ChromeDriver> driverMap = WebdriverInitializer.getDriverMap();
        driverMap.keySet().forEach(key -> {
            driverMap.get(key).quit();
        });
    }
}
