package tests.hw10;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MyParamTest extends TestsBase {

    @CsvSource (value = {
            "Alfa-bank| Альфа-Банк",
            "bspb | BSPB"
    }, delimiter = '|')
    @ParameterizedTest(name = "Для поисковго запроса {0} в первой карточке должен быть текст {1}")
    @Tag("SMOKE")
    void searchResultShouldContainExpectedText(String searchQuery, String expectedText){
        open("https://www.bing.com/");
        $(".sb_form_q").setValue(searchQuery).pressEnter();
        $(".tptt").shouldHave(text(expectedText));
    }

    @ValueSource(strings =
        {"Частным лицам", "Малому бизнесу и ИП", "Корпорациям", "Финансовым организациям"
    })
    @ParameterizedTest(name = "На главной странице банка должен находится раздел {0}")
    @Tag("SMOKE")
    void successfulSearchTest(String searchQuery){
        open("https://alfabank.ru/");
        $(".l3HYp").shouldHave(text(searchQuery));
    }

}


