package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.TTGClubStartPage;
import helpers.Attach;


import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBase {

    TTGClubStartPage ttgClubStartPage = new TTGClubStartPage();

    @BeforeAll
    static void setupSelenideEnv(){
        Configuration.browserSize = System.getProperty("browserSize");
        Configuration.headless = Boolean.parseBoolean(System.getProperty("headless"));
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.browser = System.getProperty("browser");
        Configuration.remote = System.getProperty("remoteBrowserUrl");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEachTest() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotsAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
