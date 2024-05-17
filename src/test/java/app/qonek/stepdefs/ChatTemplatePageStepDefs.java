package app.qonek.stepdefs;

import app.qonek.pages.ChatTemplatePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ChatTemplatePageStepDefs {

    ChatTemplatePage chatTemplatePage = new ChatTemplatePage();

    @And("User belum pernah membuat Chat Template sebelumnya dan terdapat button Create New Template")
    public void userBelumPernahMembuatChatTemplateSebelumnyaDanTerdapatButtonCreateNewTemplate() {
        Assertions.assertTrue(chatTemplatePage.isButtonCreateNewTemplateDisplayed());
    }

    @When("User menekan button Create New Template")
    public void userMenekanButtonCreateNewTemplate() {
        chatTemplatePage.clickCreateNewTemplate();
    }

    @Then("Menampilkan pop-up Create New Chat Template")
    public void menampilkanPopUpCreateNewChatTemplate() {
        Assertions.assertTrue(chatTemplatePage.isPopUpCreateNewChatTemplateDisplayed());
    }

    @And("terbagi menjadi 2 bagian, yaitu bagian Editorial Template dan bagian Preview Template")
    public void terbagiMenjadiBagianYaituBagianEditorialTemplateDanBagianPreviewTemplate() {
        Assertions.assertTrue(chatTemplatePage.isEditorialTemplateDisplayed());
        Assertions.assertTrue(chatTemplatePage.isPreviewTemplateDisplayed());
    }

    @And("pada bagian Editorial Template terdapat input form Template Name dan button Load Existing Box bubble chat 1 button Add Bubble Chat dan button Wait For Second Input form Template Hotkey")
    public void padaBagianEditorialTemplateTerdapatInputFormTemplateNameDanButtonLoadExistingBoxBubbleChatButtonAddBubbleChatDanButtonWaitForSecondInputFormTemplateHotkeyDefaultnyaTergenerateOlehSistem() {
        Assertions.assertTrue(chatTemplatePage.isInputTemplateNameDisplayed());
        Assertions.assertTrue(chatTemplatePage.isButtonLoadExistingDisplayed());
        Assertions.assertTrue(chatTemplatePage.isButtonWaitForSecondDisplayed());
        Assertions.assertTrue(chatTemplatePage.isButtonAddBubleChatDisplayed());
    }

    @And("pada bagian Preview Template akan menampilkan contoh pesan seperti pada Bubble chat yang telah ditambahkan")
    public void padaBagianPreviewTemplateAkanMenampilkanContohPesanSepertiPadaBubbleChatYangTelahDitambahkan() {
        Assertions.assertTrue(chatTemplatePage.isPreviewTemplateDisplayed());
    }

    @And("pada kanan bawah pop-up terdapat button Create Template")
    public void padaKananBawahPopUpTerdapatButtonCreateTemplate() {
        Assertions.assertTrue(chatTemplatePage.isButtonCreateTemplateDisplayed());
    }

    @When("User klik dan mengetikkan {string} pada form Template Name")
    public void userKlikDanMengetikkanPromoProdukPadaFormTemplateName(String productName) {
        chatTemplatePage.inputTemplateName(productName);
    }

    @Then("Input form Template Name akan aktif dan terisi {string}")
    public void inputFormTemplateNameAkanAktifDanTerisiPromoProduk(String productName) {
        Assertions.assertEquals(productName, chatTemplatePage.getTemplateNameText());
    }

    @When("User klik dan mengetikkan {string} pada form box Bubble Chat {int}")
    public void userKlikDanMengetikkanPadaFormBoxBubbleChat(String text, int formNo) {
        chatTemplatePage.inputOnBubbleText(text, formNo);
    }

    @Then("Box bubble chat {int} akan terisi pesan {string}")
    public void boxBubbleChatAkanTerisiPesan(int formNo, String text) {
        Assertions.assertEquals(text, chatTemplatePage.getInputBubleText(formNo));
    }

    @And("pada bagian Preview menampilkan bubble chat {int} dengan pesan {string}")
    public void padaBagianPreviewMenampilkanBubbleChatDenganPesan(int formNo, String text) {
        Assertions.assertEquals(text, chatTemplatePage.getPreviewBubleText(formNo));
    }

    @When("User klik button Add Bubble Chat")
    public void userKlikButton() {
        chatTemplatePage.clickButtonAddBubbleChatBtn();
    }

    @Then("Akan muncul bubble chat baru pada bagian Editorial Template")
    public void akanMunculBubbleChatBaruPadaBagianEditorialTemplate() {
        Assertions.assertEquals(2, chatTemplatePage.getInputBubbleTextCount());
    }

    @Then("Image yang dipilih akan ditambahkan pada box bubble chat {int}")
    public void imageYangDipilihAkanDitambahkanPadaBoxBubbleChat(int arg0) {
        Assertions.assertTrue(chatTemplatePage.isImageAttachmentOnEditorialFormDisplayed());
    }

    @And("pada bagian Preview menampilkan bubble chat {int} dengan pesan Image yang ditambahkan")
    public void padaBagianPreviewMenampilkanBubbleChatDenganPesanImageYangDitambahkan(int arg0) {
        Assertions.assertTrue(chatTemplatePage.isImageAttachmentOnPreviewDisplayed());
    }

    @When("User klik button Add File pada bubble chat {int}")
    public void userKlikButtonAddFilePadaBubbleChat(int formNumber) {
        chatTemplatePage.clickButtonAddFile(formNumber);
    }

    @And("tambah image pada bubble chat {int}")
    public void tambahImagePadaBubbleChat(int formNumber) {
        chatTemplatePage.addImageData();
    }

    @When("User klik dan mengetikkan {string} pada form Template Hotkey")
    public void userKlikDanMengetikkanPromoPadaFormTemplateHotkey(String hotkey) {
        chatTemplatePage.inputHotkey(hotkey);
    }

    @Then("Input form Template Hotkey akan aktif dan terisi {string}")
    public void inputFormTemplateHotkeyAkanAktifDanTerisiPromo(String hotkey) {
        Assertions.assertEquals(hotkey, chatTemplatePage.getHotkeyText());
    }

    @When("user click button create template")
    public void userClickButtonCreateTemplate() {
        chatTemplatePage.clickCreateTemplateBtn();
    }

    @Then("Pop-up akan tertutup")
    public void popUpAkanTertutup() {
        Assertions.assertTrue(chatTemplatePage.isPopUpCreateNewChatTemplateNotDisplayed());
    }

    @And("template akan bertambah pada tabel daftar template dengan isi kolom {string}, {string}, {string}, dan {string}")
    public void templateAkanBertambahPadaTabelDaftarTemplateDenganIsiKolomDan(String templateName, String hotkey, String createdTime, String guideBook) {
        LocalDate localDate = LocalDate.now(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        createdTime = localDate.format(formatter);

        Assertions.assertEquals(templateName, chatTemplatePage.getColumnValue("template name"));
        Assertions.assertEquals(hotkey, chatTemplatePage.getColumnValue("hotkey"));
        Assertions.assertEquals(createdTime, chatTemplatePage.getColumnValue("created time"));
        Assertions.assertEquals(guideBook, chatTemplatePage.getColumnValue("guide book"));
    }

    @And("pada bagian kanan tabel akan terdapat kolom button Edit dan Delete")
    public void padaBagianKananTabelAkanTerdapatKolomButtonEditDanDelete() {
        Assertions.assertTrue(chatTemplatePage.isBtnEditDisplayed());
        Assertions.assertTrue(chatTemplatePage.isBtnDeleteDisplayed());

    }

    @When("User klik button Load Existing")
    public void userKlikButtonLoadExisting() {
        chatTemplatePage.clickLoadExistingBtn();
    }

    @Then("Menampilkan dropdown daftar pilihan Chat Template yang telah dibuat sebelumnya")
    public void menampilkanDropdownDaftarPilihanChatTemplateYangTelahDibuatSebelumnya() {
        Assertions.assertTrue(chatTemplatePage.isOptionTemplateDisplayed());
    }
}
