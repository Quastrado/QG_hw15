package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$$;

public class TTGClubSpellsScreenPage {

    private final SelenideElement sectionHeader = $(".section-header");

    @Step("Get page section header text")
    public String getSectionHeaderText(String searchQuery) {

        return sectionHeader.$(byText(searchQuery)).getText();
    }

}
