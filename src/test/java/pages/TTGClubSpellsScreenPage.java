package pages;


import com.codeborne.selenide.SelenideElement;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;


public class TTGClubSpellsScreenPage {

    private final SelenideElement sectionHeader = $(".section-header");

    @Step("Get page section header text")
    public String getSectionHeaderText(String searchQuery) {

        return sectionHeader.$(byText(searchQuery)).getText();
    }

}
