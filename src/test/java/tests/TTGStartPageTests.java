package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TTGClubSpellsScreenPage;
import pages.components.*;
import tests.testdata.TestDataTTGClub;

import static com.codeborne.selenide.Condition.*;


public class TTGStartPageTests extends TestBase {
    TestDataTTGClub testData = new TestDataTTGClub();
    Navbar navbar = new Navbar();


    @Test
    @DisplayName("Checking a simple search script from the main page")
    void  displaySearchResult() {
        MainPageSearchModal searchModal = ttgClubStartPage.callSearchModalFromMainPage();
        searchModal.typeSearchQuery(testData.searchQuery);
        TTGClubSpellsScreenPage resultPage = searchModal.redirectToResultPage(
                testData.searchResultLink,
                testData.searchResultPage
        );
        assert resultPage.getSectionHeaderText(testData.searchQuery).equals(testData.searchQuery);
    }

    @Test
    @DisplayName("Checking the navigation menu display")
    void checkOpenNavigationModal() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        navigationMenu.becomeVisible();
    }

    @Test
    @DisplayName("Checking the display of the bookmarks list")
    void checkOpenBookmarksList() {
        Bookmarks bookmarks = navbar.bookmarksButtonClick();
        bookmarks.becomeVisible();
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
        BugReportModal bugReportModal = navbar.bugReportButtonClick();
        bugReportModal.becomeVisible();
    }

}
