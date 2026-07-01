package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class Navbar {

    private final SelenideElement navbarNavigationButton =  $$(".navbar__btn").get(0);
    private final SelenideElement navbarBookmarksButton = $$(".navbar__btn").get(1);

    @Step("Navigation button click")
    public NavigationMenu navigationMenuButtonClick() {
        navbarNavigationButton.click();

        return new NavigationMenu();
    }

    @Step("Bookmarks button click")
    public Bookmarks bookmarksButtonClick() {
        navbarBookmarksButton.click();

        return new Bookmarks();
    }

}
