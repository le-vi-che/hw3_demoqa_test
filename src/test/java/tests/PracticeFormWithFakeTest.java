package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithFakeTest extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullCompleteFormTest() {

       registrationPage.openPage()
       .setFirstName("fill")
       .setLastName("good")
       .setUserEmail("qwerty@ty.ru")
       .setGenterWrapper("Male")
       .setUserNumber("8888888888")
       .setDateOfBirth("14", "July", "1992")
       .setSubjectsInput("Hindi")
       .setHobbiesWrapperInput("Reading")
       .setUploadPicture( "picture (2).jpg")
       .setCurrentAddress("Spb, 363")
       .setChooseState("Haryana")
       .setChooseCity("Karnal")
       .pressSubmit();

        registrationPage.checkResult("Student Name", "fill good")
                  .checkResult("Student Email", "qwerty@ty.ru")
                 .checkResult("Gender", "Male")
                .checkResult("Mobile", "8888888888")
                .checkResult("Date of Birth", "14 July,1992")
                .checkResult("Subjects", "Hindi")
                .checkResult("Hobbies","Reading")
                .checkResult("Picture", "picture (2).jpg")
                .checkResult("Address","Spb, 363")
                .checkResult("State and City", "Haryana Karnal");
    }


    @Test
    void partCompleteFormTest() {

        registrationPage.openPage()
                .setFirstName("fill")
                .setLastName("good")
                .setGenterWrapper("Male")
                .setUserNumber("8888888888")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "fill good")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8888888888");
    }

    @Test
    void negativeCompleteFormTest() {

        registrationPage.openPage()
                 .pressSubmit();

        registrationPage.checkNotCompleteForm();
            }
}


