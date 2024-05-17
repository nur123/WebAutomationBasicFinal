package app.qonek.pages;

import app.qonek.base.WebPageObject;
import org.openqa.selenium.By;

public class LoginPage extends WebPageObject {

    public void openWebPage(){
        openPage("https://qonek-uat.web.app/");
    }

    public void inputEmail(String email) {
        type(By.id("sign_in_text_input_email"), email);
    }

    public void inputPassword(String password) {
        type(By.id("sign_in_text_input_password"), password);
    }

    public void clickButtonLogin(){
        click(By.id("sign_in_button_sign_in"));
    }

}
