package pages.comonents;

import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year){
      ;
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--014").click();

    }
}
