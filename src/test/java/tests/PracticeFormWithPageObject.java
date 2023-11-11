package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithPageObject extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

    private String FIRST_NAME = "fill",
            LAST_NAME = "good",
            USER_EMAIL = "qwerty@ty.ru",
            GENDER = "Male",
            USER_NUMBER = "8888888888",
            DAY_BIRTH = "14",
            MONTH_BIRTH = "July",
            YEAR_BIRTH = "1992",
            SUBJECTS = "Hindi",
            HOBBIES = "Reading",
            PICTURE = "picture (2).jpg",
            CURRENT_ADDRESS = "Spb, 363",
            STATE = "Haryana",
            CITY = "Karnal";

    @Test
    void fullCompleteFormTest() {

       registrationPage.openPage()
       .setFirstName(FIRST_NAME)
       .setLastName(LAST_NAME)
       .setUserEmail(USER_EMAIL)
       .setGenterWrapper(GENDER)
       .setUserNumber(USER_NUMBER)
       .setDateOfBirth(DAY_BIRTH, MONTH_BIRTH, YEAR_BIRTH)
       .setSubjectsInput(SUBJECTS)
       .setHobbiesWrapperInput(HOBBIES)
       .setUploadPicture( PICTURE)
       .setCurrentAddress(CURRENT_ADDRESS)
       .setChooseState(STATE)
       .setChooseCity(CITY)
       .pressSubmit();

        registrationPage.checkResult("Student Name", FIRST_NAME + " " +LAST_NAME)
                  .checkResult("Student Email", USER_EMAIL)
                 .checkResult("Gender", GENDER)
                .checkResult("Mobile", USER_NUMBER)
                .checkResult("Date of Birth", DAY_BIRTH +" " + MONTH_BIRTH + "," + YEAR_BIRTH)
                .checkResult("Subjects", "Hindi")
                .checkResult("Hobbies","Reading")
                .checkResult("Picture", PICTURE)
                .checkResult("Address", CURRENT_ADDRESS)
                .checkResult("State and City", STATE + " " + CITY);
    }


    @Test
    void partCompleteFormTest() {

        registrationPage.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGenterWrapper(GENDER)
                .setUserNumber(USER_NUMBER)
                .pressSubmit();

        registrationPage.checkResult("Student Name", FIRST_NAME + " " +LAST_NAME)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", USER_NUMBER);
    }

    @Test
    void negativeCompleteFormTest() {

        registrationPage.openPage()
                 .pressSubmit()
                 .checkNotCompleteForm();
            }
}


