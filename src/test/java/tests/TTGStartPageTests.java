package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TTGClubStartPage;
import tests.testdata.TestDataTTGClub;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TTGStartPageTests {
    TestDataTTGClub testData = new TestDataTTGClub();
    TTGClubStartPage ttgClubStartPage = new TTGClubStartPage();

    @BeforeEach
    void setUp() {
        open("https://5e14.ttg.club");
    }

    @AfterEach
    void afterEachTest() {closeWebDriver();}

    @Test
    void  displaySearchResult() {
        SelenideElement searchResultPageHeader = ttgClubStartPage.searchFromPage(
          testData.searchQuery,
          testData.searchResultLink
        );
        searchResultPageHeader.shouldHave(text(testData.searchQuery));
    }

    @Test
    void checkOpenNavigationModal() {
        SelenideElement navigationModal = ttgClubStartPage.openNavigationMenu();
        navigationModal.shouldBe(visible);
    }

    @Test
    void checkOpenBookmarksList() {
        SelenideElement bookmarksListTitle = ttgClubStartPage.openBookmarksList();
        bookmarksListTitle.shouldHave(text(testData.bookmarksExpectedTitle));
    }

    @Test
    void checkGoingToTheClassPage() {
        SelenideElement classArchetypesList = ttgClubStartPage.goingToTheClassPage(testData.choosenClass);
        classArchetypesList.shouldHave(visible);
    }

    @Test
    void checkGoingToTheTokenator() {
        SelenideElement tokenatorPageTitle = ttgClubStartPage.goingToTokenator();
        tokenatorPageTitle.shouldHave(visible);
    }

    @Test
    void checkFormulaCalculate() {
        SelenideElement calculateResult = ttgClubStartPage.formulaCalculate(
                testData.formula
        );
        calculateResult.shouldNotBe(empty);
    }

    @Test
    void openVideoPlayerModal() {
        String videoTitle = ttgClubStartPage.getVideoLink().text();
        SelenideElement videoModalTitle = ttgClubStartPage.openVideo();
        videoModalTitle.shouldHave(text(videoTitle));
    }

    @Test
    void checkDarkThemeTurning() {
        SelenideElement background = ttgClubStartPage.turnDarkTheme();
        background.shouldHave(cssValue(
                testData.cssPropertyName,
                testData.cssExpectedValue
        ));
    }

    @Test
    void checkGoingToTheSearchPage() {
        SelenideElement searchedPageTitle = ttgClubStartPage.goingToTheSearchPage();
        searchedPageTitle.shouldHave(text(testData.searchPageTitle));
    }

    @Test
    void reportAboutBug() {
        SelenideElement bugReportModalTitle = ttgClubStartPage.openBugReportModal();
        bugReportModalTitle.shouldHave(text(testData.bugReportModalTitle));
    }

}
