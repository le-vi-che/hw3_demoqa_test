package tests.hw10;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestsBase {

    @BeforeAll
    public static void setupAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
      }

    @AfterEach
    void closeBrowse() {
        Selenide.closeWebDriver();
    }
}
