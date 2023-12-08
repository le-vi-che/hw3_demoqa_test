package tests.hw12;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTests {

        @Test
        public void testIssueNameSearch() {
            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com");

            $(".search-input").click();
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").submit();

            $(linkText("eroshenkoam/allure-example")).click();
            $("#issues-tab").click();
            $(withText("e.sh")).should(Condition.exist);
        }
    }

