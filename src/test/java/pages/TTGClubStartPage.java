package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.MainPageSearchModal;

import static com.codeborne.selenide.Selenide.$;


public class TTGClubStartPage {

    private final String backgroundColor = $("#body").getCssValue("background-color");
    private final SelenideElement pageSearchRow = $(".search_row_g");
    private final SelenideElement classesCard = $("a[href='/classes'][class='card']");
    private final SelenideElement tokenatorChapter = $(".token_library");
    private final SelenideElement formulaCalculator = $(".n-float-button");
    private final SelenideElement videoLink = $("._link_1lg7o_18");


    @Step("Call search modal from the main page")
    public MainPageSearchModal callSearchModalFromMainPage() {
        pageSearchRow.click();

        return new MainPageSearchModal();
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

    @Step("Get background color")
    public String getBackgroundColor() {
        return backgroundColor;
    }

    @Step("Calculate the formula")
    public SelenideElement formulaCalculate(String formula) {
        formulaCalculator.click();
        $(".n-input__input-el").setValue(formula);
        $(".n-input__input-el").pressEnter();

        return $("._dice-history-item__result_f039v_10");
    }


}
