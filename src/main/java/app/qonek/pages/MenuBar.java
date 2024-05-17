package app.qonek.pages;

import app.qonek.base.WebPageObject;
import org.openqa.selenium.By;

public class MenuBar extends WebPageObject {

    public boolean verifyAlreadyLogin(){
        return isDisplayed(By.id("navmenu_navbtn_guidebook"), 10);
    }

    public void clickChatTemplateMenu(){
        click(By.id("navmenu_navbtn_guidebook"));
    }
}
