package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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

}
