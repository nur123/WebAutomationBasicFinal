package app.qonek.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class WebdriverInitializer {

    //global variable / instance variable static
    public static AtomicReference<HashMap<String, ChromeDriver>> webDriverPool = new AtomicReference<>(
            new HashMap<>());

    public static void initialize() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--start-maximized");
        ChromeDriver driver = new ChromeDriver(options);
        webDriverPool.updateAndGet(dv -> {
            dv.put(Thread.currentThread().getName(), driver);
            return dv;
        });
    }

    public static void quit() {
        webDriverPool.updateAndGet(dv -> {
            ChromeDriver driver = dv.get(Thread.currentThread().getName());
            dv.remove(Thread.currentThread().getName());
            driver.quit();
            return dv;
        });
    }

    public static ChromeDriver getDriver() {
        return webDriverPool.get().get(Thread.currentThread().getName());
    }

    public static HashMap<String, ChromeDriver> getDriverMap(){
        return webDriverPool.get();
    }
}
