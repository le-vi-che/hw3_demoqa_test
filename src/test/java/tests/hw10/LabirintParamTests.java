package tests.hw10;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class LabirintParamTests  extends TestBase{

    @ValueSource(strings = {
            "java", "python"
    })
    @ParameterizedTest(name = "Поисковый запрос {0} не должен отдавать пустой список результатов")
    @Tag("SMOKE")
    void searchResultsShouldNotBeEmptyTest(String searchQuery) {
        open("https://www.labirint.ru/");
        $("#search-field").setValue(searchQuery).pressEnter();
        $$("[class='product-card need-watch watched gtm-watched']")
                .shouldBe(sizeGreaterThan(0));
    }
}
