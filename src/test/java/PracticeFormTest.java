import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 24000;
    }
    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("fill");
        $("#lastName").setValue("good");
        $("#userEmail").setValue("qwerty@ty.ru");
        $("[for='gender-radio-2']").click(); // gender
        $("#userNumber").setValue("8888888888");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("0");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--014").click();

     //   $("#subjectsContainer").;
        $("[for='hobbies-checkbox-2']").click();// hobbies
       // $("#uploadPicture").uploadFromClasspath("picture(2).png");
      //  $("currentAddress").setValue("Spb, 363");
     //   $("").click();
       // $("[id=search]").shouldHave(text("https://ru.selenide.org"));
    }
}
