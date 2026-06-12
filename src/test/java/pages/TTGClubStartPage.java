package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TTGClubStartPage {

    private final SelenideElement pageSearchRow = $(".search_row_g");
    private final SelenideElement navbarNavigationButton =  $$(".navbar__btn").get(0);
    private final SelenideElement navbarBookmarksButton = $$(".navbar__btn").get(1);
    private final SelenideElement classesCard = $("a[href='/classes'][class='card']");
    private final SelenideElement tokenatorChapter = $(".token_library");
    private final SelenideElement videoLink = $("._link_1lg7o_18");
    private final SelenideElement colorThemeToggle = $$(".navbar__btn").get(5);
    private final SelenideElement navbarSearchButton = $$(".navbar__btn").get(2);
    private final SelenideElement navbarBugReportButton = $$(".navbar__btn").get(3);

    public SelenideElement searchFromPage(String searchQuery, String searchResult) {
        pageSearchRow.click();
        $(".n-input__input-el").setValue(searchQuery);
        $("a[href=\"" + searchResult + "\"]").click();
        return $(".section-header");
    }

    public SelenideElement openNavigationMenu() {
        navbarNavigationButton.click();

        return $(".nav-menu");
    }

    public SelenideElement openBookmarksList(String title) {
        navbarBookmarksButton.click();

        return $(".bookmarks__info--title");
    }

    public SelenideElement goingToTheClassPage(String choosenClass) {
        classesCard.click();
        $("a[href='/classes/" + choosenClass + "'][class='link-item-expand__link']").click();

        return $(".link-item-expand__arch-list");
    }

    public SelenideElement goingToTokenator() {
        tokenatorChapter.click();

        return $(".page-layout__title");
    }

    public String getVideoTitle() {
        return videoLink.text();
    }

    public SelenideElement openVideo() {
        videoLink.click();

        return $(".base-modal__title");
    }

    public SelenideElement turnDarkTheme() {
        colorThemeToggle.click();
        $$(".__button-1vhidqx-lmmd").get(1).click();

        return $("#body");
    }

    public SelenideElement goingToTheSearchPage() {
        navbarSearchButton.click();
        $(".search-modal__all").click();

        return $(".page-layout__title");
    }

    public SelenideElement openBugReportModal() {
        navbarBugReportButton.click();

        return $(".bug-report-modal__title");
    }

}
