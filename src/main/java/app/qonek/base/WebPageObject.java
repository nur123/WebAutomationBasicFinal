package app.qonek.base;

import app.qonek.driver.WebdriverInitializer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebPageObject {

    public WebDriver getDriver() {
        return WebdriverInitializer.getDriver();
    }

     public void openPage(String url) {
        getDriver().get(url);
    }

    public WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return getDriver().findElements(locator);
    }

    public void type(By locator, String text) {
        WebElement el = find(locator);
        el.clear();
        el.sendKeys(text);
    }

    public void click(By locator) {
        WebElement el = find(locator);
        el.click();
    }

    public void waitABit(int timeInSeconds){
        try {
            Thread.sleep(Duration.ofSeconds(timeInSeconds).toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getText(By locator) {
        WebElement el = find(locator);
        return el.getText();
    }

    public String getAttribute(By locator, String attributeName) {
        return find(locator).getAttribute(attributeName);
    }

    public void executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(script);
    }

    public WebElement waitUntilPresent(By locator, int durationInsSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(durationInsSeconds));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean waitUntilNotPresent(By locator, int durationInsSeconds){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(durationInsSeconds));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean isDisplayed(By locator, int durationInsSeconds){
        return waitUntilPresent(locator, durationInsSeconds).isDisplayed();
    }

    public boolean isDisplayed(By locator){
        return isDisplayed(locator, 5);
    }

    public void keyPress(CharSequence... text){
        Actions actions = new Actions(getDriver());
        actions.sendKeys(text).build().perform();
    }

    public void refreshPage(){
        getDriver().navigate().refresh();
    }


}
