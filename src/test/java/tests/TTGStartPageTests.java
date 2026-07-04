package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ClassesPage;
import pages.SearchPage;
import pages.TTGClubSpellsScreenPage;
import pages.TokenatorPage;
import pages.components.*;
import tests.testdata.TestDataTTGClub;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;


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
        step("The expected title of the resulting page is displayed", () ->
            resultPage.getSectionHeaderText().shouldHave(text(testData.searchQuery))
        );
    }

    @Test
    @DisplayName("Checking the navigation menu display")
    void checkOpenNavigationModal() {
        NavigationMenu navigationMenu = navbar.navigationMenuButtonClick();
        step("The navigation menu is displayed", () ->
            navigationMenu.becomeVisible()
        );
    }

    @Test
    @DisplayName("Checking the display of the bookmarks list")
    void checkOpenBookmarksList() {
        Bookmarks bookmarks = navbar.bookmarksButtonClick();
        step("A list of bookmarks is displayed", () ->
            bookmarks.becomeVisible()
        );
    }

    @Test
    @DisplayName("Checking the script for navigating to a class page from the main page")
    void checkGoingToTheClassPage() {
        ClassesPage classesPage = ttgClubStartPage.goingToTheClassPage();
        step("The class page displays a list of archetypes", () ->
            classesPage.classBardLinkCLick().getBardClassArchetypesList().shouldHave(visible)
        );
    }

    @Test
    @DisplayName("Checking the transition to the Tokenator page")
    void checkGoingToTheTokenator() {
        TokenatorPage tokenatorPage = ttgClubStartPage.redirectToTokenator();
        step("The resulting calculator field displays the calculation result", () ->
            tokenatorPage.getPageTitle().shouldHave(visible)
        );
    }

    @Test
    @DisplayName("Checking the working out of the formula calculator")
    void checkFormulaCalculate() {
        FormulaCalculator formulaCalculator = ttgClubStartPage.formulaCalculatorButtonClick();
        formulaCalculator.calculateFormula(testData.formula);
        step("The resulting calculator field displays the calculation result", () ->
            formulaCalculator.getCalculateResult().shouldNotBe(empty)
        );
    }

    @Test
    @DisplayName("Checking the opening of a modal window with a video on the main page")
    void openVideoPlayerModal() {
        String videoLinkTitle = ttgClubStartPage.getVideoLinkText();
        VideoMadal videoMadal = ttgClubStartPage.openVideo();
        step("The title text of the video window matches the text of the link element", () ->
            videoMadal.getVideoTitle().shouldHave(text(videoLinkTitle))
        );
    }

    @Test
    @DisplayName("Checking to switch to a dark color theme")
    void checkDarkThemeTurning() {
        ColorThemeModal colorThemeModal = navbar.colorThemeButtonClick();
        colorThemeModal.setDarkColorTheme();
        step("The background color has changed to dark", () ->
            ttgClubStartPage.getBackgroundColor().shouldHave(text(testData.cssExpectedValue))
        );
    }

    @Test
    @DisplayName("Checking the transition to the search page")
    void checkGoingToTheSearchPage() {
        SearchModal searchModal = navbar.searchButtonClick();
        SearchPage searchPage = searchModal.redirectToSearchPage();
        step("The search page displayed the expected title", () ->
            searchPage.getPageTitle().shouldHave(text(testData.searchPageTitle))
        );
    }

    @Test
    @DisplayName("Checking the display of the bug message window")
    void reportAboutBug() {
        BugReportModal bugReportModal = navbar.bugReportButtonClick();
        step("The bug report window is displayed", () ->
            bugReportModal.becomeVisible()
        );
    }

}
