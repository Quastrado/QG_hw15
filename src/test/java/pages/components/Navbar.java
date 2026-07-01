package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class Navbar {

    private final SelenideElement navbarNavigationButton =  $$(".navbar__btn").get(0);

    @Step("Navigation button click")
    public NavigationMenu buttonClick() {
        navbarNavigationButton.click();

        return new NavigationMenu();
    }

}
