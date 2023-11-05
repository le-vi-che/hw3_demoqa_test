import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsSearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void makeSureSolutionPage() {
        open("https://github.com");
        $("ul.d-lg-flex.list-style-none").
                $(byText("Solutions")).
                click();
        $("[href='/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered developer platform."));
    }
}