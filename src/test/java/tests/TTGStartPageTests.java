package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.testdata.TestDataTTGClub;

import static com.codeborne.selenide.Condition.*;


public class TTGStartPageTests extends TestBase {
    TestDataTTGClub testData = new TestDataTTGClub();


    @Test
    @DisplayName("Checking a simple search script from the main page")
    void  displaySearchResult() {
        SelenideElement searchResultPageHeader = ttgClubStartPage.searchFromPage(
          testData.searchQuery,
          testData.searchResultLink
        );
        searchResultPageHeader.shouldHave(text(testData.searchQuery));
    }

    @Test
    @DisplayName("Checking the navigation menu display")
    void checkOpenNavigationModal() {
        SelenideElement navigationModal = ttgClubStartPage.openNavigationMenu();
        navigationModal.shouldBe(visible);
    }

    @Test
    @DisplayName("Checking the display of the bookmarks list")
    void checkOpenBookmarksList() {
        SelenideElement bookmarksListTitle = ttgClubStartPage.openBookmarksList();
        bookmarksListTitle.shouldHave(text(testData.bookmarksExpectedTitle));
    }

    @Test
    @DisplayName("Checking the script for navigating to a class page from the main page")
    void checkGoingToTheClassPage() {
        SelenideElement classArchetypesList = ttgClubStartPage.goingToTheClassPage(testData.choosenClass);
        classArchetypesList.shouldHave(visible);
    }

    @Test
    @DisplayName("Checking the transition to the Tokenator page")
    void checkGoingToTheTokenator() {
        SelenideElement tokenatorPageTitle = ttgClubStartPage.goingToTokenator();
        tokenatorPageTitle.shouldHave(visible);
    }

    @Test
    @DisplayName("Checking the working out of the formula calculator")
    void checkFormulaCalculate() {
        SelenideElement calculateResult = ttgClubStartPage.formulaCalculate(
                testData.formula
        );
        calculateResult.shouldNotBe(empty);
    }

    @Test
    @DisplayName("Checking the opening of a modal window with a video on the main page")
    void openVideoPlayerModal() {
        String videoTitle = ttgClubStartPage.getVideoLink().text();
        SelenideElement videoModalTitle = ttgClubStartPage.openVideo();
        videoModalTitle.shouldHave(text(videoTitle));
    }

    @Test
    @DisplayName("Checking to switch to a dark color theme")
    void checkDarkThemeTurning() {
        SelenideElement background = ttgClubStartPage.turnDarkTheme();
        background.shouldHave(cssValue(
                testData.cssPropertyName,
                testData.cssExpectedValue
        ));
    }

    @Test
    @DisplayName("Checking the transition to the search page")
    void checkGoingToTheSearchPage() {
        SelenideElement searchedPageTitle = ttgClubStartPage.goingToTheSearchPage();
        searchedPageTitle.shouldHave(text(testData.searchPageTitle));
    }

    @Test
    @DisplayName("Checking the display of the bug message window")
    void reportAboutBug() {
        SelenideElement bugReportModalTitle = ttgClubStartPage.openBugReportModal();
        bugReportModalTitle.shouldHave(text(testData.bugReportModalTitle));
    }

}
