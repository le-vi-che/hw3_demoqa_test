import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
       // Configuration.timeout = 24000;
    }
    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("fill");
        $("#lastName").setValue("good");
        $("#userEmail").setValue("qwerty@ty.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8888888888");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--014").click();

        $("#subjectsInput").val("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        $("#uploadPicture").uploadFromClasspath("picture (2).jpg");
        $("#currentAddress").setValue("Spb, 363");
        $("#react-select-3-input").val("Haryana").pressEnter();
        $("#react-select-4-input").val("Karnal").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(text("fill good"));
        $(".table-responsive").shouldHave(text("qwerty@ty.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8888888888"));
        $(".table-responsive").shouldHave(text("14 January,1992"));
        $(".table-responsive").shouldHave(text("Hindi"));
        $(".table-responsive").shouldHave(text("Reading"));
        $(".table-responsive").shouldHave(text("picture (2).jpg"));
        $(".table-responsive").shouldHave(text("Spb, 363"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }
}



