package tests;

import com.codeborne.selenide.Configuration;
import data.hw10.Lang;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


@DisplayName("Тесты к заданию по Junit5")
public class MguParamTest  {

    @BeforeEach
        void beforeEach() {
            Configuration.browserSize = "1920x1080";
            Configuration.browser = "chrome";
            Configuration.pageLoadStrategy = "eager";
            Configuration.baseUrl = "https://www.msu.ru/";
    }

    @CsvSource(value = {
            "en/index.html | Home Page",
            "ch/index.php | 主頁"
      }, delimiter = '|')
    @ParameterizedTest(name = "Для url {0},должен быть текст{1}")
    @Tag("WEB")
    @Tag("Regression")
    void searchResultsShouldContainExpectedUrlTest(String urlChapter, String expectedText) {
        open("");
        open(urlChapter);
        $(".menu-left li a").shouldHave(text(expectedText));
    }


    @Tag("REGRESSION")
    @Tag("WEB")
    @EnumSource(Lang.class)
    @ParameterizedTest(name = "Проверка языка названия университета")
    void mainPageHasCorrectChapterDiscriptionMgu(Lang lang) {
        open("");
        $(".lang-choose").find(byText(lang.name())).click();
        $(".logo a").shouldHave(text(lang.description));

    }
}