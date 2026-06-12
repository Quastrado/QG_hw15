package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TTGStartPageTests {

    @BeforeEach
    void setUp() {
        open("https://5e14.ttg.club");
    }

    @Test
    void  displaySearchResult() {
        $(".search_row_g").click();
        $(".n-input__input-el").setValue("Заклинания");
        $("a[href=\"/screens/spells\"]").click();
        $(".section-header").shouldHave(text("Заклинания"));
    }

    @Test
    void openNavigationWindow() {
        $$(".navbar__btn").get(0).click();
        $(".nav-menu").shouldBe(visible);
    }

    @Test
    void openBookmarksList() {
        $$(".navbar__btn").get(1).click();
        $(".bookmarks__info--title").shouldHave(text("Закладки"));
    }

    @Test
    void goingToTheClassPage() {
        $("a[href='/classes'][class='card']").click();
        $("a[href='/classes/bard'][class='link-item-expand__link']").click();
        $(".link-item-expand__arch-list").shouldBe(visible);
    }

    @Test
    void goingToTheTokenator() {
        $(".token_library").click();
        $(".page-layout__title").shouldBe(visible);
    }

    @Test
    void formulaCalculator() {
        $(".n-float-button").click();
        $(".n-input__input-el").setValue("d20");
        $(".n-input__input-el").pressEnter();
        $("._dice-history-item__result_f039v_10").shouldNotBe(empty);
    }

    @Test
    void openVideoPlayerModal() {
        String videoTitle = $("._link_1lg7o_18").text();
        $("._link_1lg7o_18").click();
        $(".base-modal__title").shouldHave(text(videoTitle));
    }

    @Test
    void turnDarkTheme() {
        $$(".navbar__btn").get(5).click();
        $$(".__button-1vhidqx-lmmd").get(1).click();
        $("#body")
                .shouldHave(cssValue("background-color", "rgba(19, 26, 32, 1)"));
    }

    @Test
    void goingToTheSearchPage() {
        $$(".navbar__btn").get(2).click();
        $(".search-modal__all").click();
        $(".page-layout__title").shouldHave(text(" Поиск по сайту "));
    }

    @Test
    void reportAboutBug() {
        $$(".navbar__btn").get(3).click();
        $(".bug-report-modal__title").shouldHave(text("Сообщить о баге"));
    }

}
