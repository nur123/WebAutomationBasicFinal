package app.qonek.pages;

import app.qonek.base.WebPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class ChatTemplatePage extends WebPageObject {

    public boolean isButtonCreateNewTemplateDisplayed() {
        return isDisplayed(By.xpath("//*[contains(text(),'New Template')]"));
    }

    public void clickCreateNewTemplate() {
        try {
            click(By.xpath("//p[contains(text(),'Create New Template')]"));
        }catch (Exception e){
            click(By.id("chattemplate_btn_createnew"));
        }
    }

    public boolean isPopUpCreateNewChatTemplateDisplayed() {
        try {
            return isDisplayed(By.cssSelector(".BroadcastChatTemplate"));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPopUpCreateNewChatTemplateNotDisplayed() {
        try {
            return waitUntilNotPresent(By.cssSelector(".BroadcastChatTemplate"), 5);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEditorialTemplateDisplayed() {
        return isDisplayed(By.cssSelector(".leftModalAddNewTemplate"));

    }

    public boolean isPreviewTemplateDisplayed() {
        return isDisplayed(By.cssSelector(".ContainerPreviewAddNewTemplate"));
    }

    public boolean isInputTemplateNameDisplayed() {
        return isDisplayed(By.id("addnewtemplatechat_textinput_templatename"));
    }

    public void inputTemplateName(String name) {
        type(By.id("addnewtemplatechat_textinput_templatename"), name);
    }

    public String getTemplateNameText() {
        return getAttribute(By.id("addnewtemplatechat_textinput_templatename"), "value");
    }

    public boolean isButtonLoadExistingDisplayed() {
        return isDisplayed(By.id("addnewtemplatechat_btn_loadexisting"));
    }

    public boolean isButtonAddBubleChatDisplayed() {
        return isDisplayed(By.id("addnewtemplate_buble_btn_addbublechat"));
    }

    public boolean isButtonWaitForSecondDisplayed() {
        return isDisplayed(By.id("addnewtemplate_buble_btn_waitforrespond"));
    }

    public boolean isButtonCreateTemplateDisplayed() {
        return isDisplayed(By.id("addnewtemplate_buble_btn_createtemplate"));
    }

    public void clickCreateTemplateBtn() {
        waitABit(5);
        click(By.id("addnewtemplate_buble_btn_createtemplate"));
    }


    public void inputOnBubbleText(String text, int formNo) {
        List<WebElement> elements = findElements(By.xpath("//div[@data-placeholder='Input Chat Text']"));
        elements.get(formNo - 1).click();
        keyPress(text);
    }

    public String getInputBubleText(int formNo) {
        List<WebElement> elements = findElements(By.xpath("//div[@data-placeholder='Input Chat Text']/div"));
        return elements.get(formNo - 1).getText();
    }

    public String getPreviewBubleText(int formNo) {
        return getText(By.xpath("//div[@id='" + (formNo - 1) + "']//p/div"));
    }

    public void clickButtonAddBubbleChatBtn() {
        click(By.id("addnewtemplate_buble_btn_addbublechat"));
    }

    public int getInputBubbleTextCount() {
        return findElements(By.cssSelector(".ContainerBuble")).size();
    }

    public void clickButtonAddFile(int formNumber) {
        click(By.xpath("(//img[@src='/assets/icons/paperclip-2.svg'])[" + formNumber + "]"));
    }

    public void addImageData() {
        String filePath = System.getProperty("user.dir") + File.separator + "gambar" + File.separator + "brz_038.jpg";
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.getElementById('inputFileImage').style.display='block';");
//        js.executeScript("document.getElementById('inputFileImage').value='" + filePath.replace("\\", "\\\\") + "';");
        type(By.id("inputFileImage"), filePath);
    }

    public boolean isImageAttachmentOnEditorialFormDisplayed() {
        return isDisplayed(By.id("bublechat_reusable_image_addnewtemplate_buble_btn_3"));
    }

    public boolean isImageAttachmentOnPreviewDisplayed() {
        return isDisplayed(By.xpath("//div[@class='ChatContent_User']//img[contains(@src, 'data')]"));
    }

    public void inputHotkey(String hotkey) {
        waitABit(2);
        type(By.id("inputlabel_textinput_hotkey"), hotkey);
    }

    public String getHotkeyText() {
        waitABit(2);
        return getAttribute(By.id("inputlabel_textinput_hotkey"), "value");
    }

    public String getColumnValue(String columnName){
        switch (columnName.toLowerCase()){
            case "template name":
                return getText(By.xpath("//tr//td[2]"));
            case "created time":
                return getText(By.xpath("//tr//td[3]"));
            case "hotkey":
                return getText(By.xpath("//tr//td[4]"));
            case "guide book":
                return getText(By.xpath("//tr//td[5]//p"));
            default:
                return "";
        }
    }

    public boolean isBtnEditDisplayed(){
        return isDisplayed(By.id("chattemplate_page_btn_edit"));
    }

    public boolean isBtnDeleteDisplayed(){
        return isDisplayed(By.id("chattemplate_page_btn_delete"));
    }

    public void clickLoadExistingBtn(){
        click(By.id("addnewtemplatechat_btn_loadexisting"));
    }

    public boolean isOptionTemplateDisplayed(){
        return isDisplayed(By.cssSelector(".labelOptionTemplate"));
    }
}
