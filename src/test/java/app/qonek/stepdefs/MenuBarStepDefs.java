package app.qonek.stepdefs;

import app.qonek.pages.MenuBar;
import io.cucumber.java.en.And;

public class MenuBarStepDefs {

    MenuBar menuBar = new MenuBar();

    @And("User berada di halaman Chat Template")
    public void userBeradaDiHalamanChatTemplate() {
        menuBar.clickChatTemplateMenu();
    }
}
