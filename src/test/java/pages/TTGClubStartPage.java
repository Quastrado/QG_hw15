package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TTGClubStartPage {

    private final SelenideElement pageSearchRow = $(".search_row_g");
    private final SelenideElement navbarNavigationButton =  $$(".navbar__btn").get(0);
    private final SelenideElement navbarBookmarksButton = $$(".navbar__btn").get(1);
    private final SelenideElement classesCard = $("a[href='/classes'][class='card']");
    private final SelenideElement tokenatorChapter = $(".token_library");
    private final SelenideElement formulaCalculator = $(".n-float-button");
    private final SelenideElement videoLink = $("._link_1lg7o_18");
    private final SelenideElement colorThemeToggle = $$(".navbar__btn").get(5);
    private final SelenideElement navbarSearchButton = $$(".navbar__btn").get(2);
    private final SelenideElement navbarBugReportButton = $$(".navbar__btn").get(3);

    @Step("Execute a search query from the main page")
    public SelenideElement searchFromPage(String searchQuery, String searchResult) {
        pageSearchRow.click();
        $(".n-input__input-el").setValue(searchQuery);
        $("a[href=\"" + searchResult + "\"]").click();
        return $(".section-header");
    }

    @Step("Open the navigation menu")
    public SelenideElement openNavigationMenu() {
        navbarNavigationButton.click();

        return $(".nav-menu");
    }

    @Step("Open the bookmarks list")
    public SelenideElement openBookmarksList() {
        navbarBookmarksButton.click();

        return $(".bookmarks__info--title");
    }

    @Step("Go to the class page from the main page")
    public SelenideElement goingToTheClassPage(String choosenClass) {
        classesCard.click();
        $("a[href='/classes/" + choosenClass + "'][class='link-item-expand__link']").click();

        return $(".link-item-expand__arch-list");
    }

    @Step("Go to the tokenizer page from the main page")
    public SelenideElement goingToTokenator() {
        tokenatorChapter.click();

        return $(".page-layout__title");
    }

    @Step("Interaction with the video link")
    public SelenideElement getVideoLink() {
        return videoLink;
    }

    @Step("Open video")
    public SelenideElement openVideo() {
        videoLink.click();

        return $(".base-modal__title");
    }

    @Step("Change the theme to dark")
    public SelenideElement turnDarkTheme() {
        colorThemeToggle.click();
        $$(".__button-1vhidqx-lmmd").get(1).click();

        return $("#body");
    }

    @Step("Execute a search query from the navigation bar")
    public SelenideElement goingToTheSearchPage() {
        navbarSearchButton.click();
        $(".search-modal__all").click();

        return $(".page-layout__title");
    }

    @Step("Open the bug notification page")
    public SelenideElement openBugReportModal() {
        navbarBugReportButton.click();

        return $(".bug-report-modal__title");
    }

    @Step("Calculate the formula")
    public SelenideElement formulaCalculate(String formula) {
        formulaCalculator.click();
        $(".n-input__input-el").setValue(formula);
        $(".n-input__input-el").pressEnter();

        return $("._dice-history-item__result_f039v_10");
    }


}
