package org.first.selenide;

import org.first.TestBase;

import org.first.pages.StudentRegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;
import static org.first.helpers.UserDate.*;


public class DemoqaTests extends TestBase {

    @Test
    @DisplayName("Проверка формы регистрации студента")
    void checkFormRegistrationStudent(){
        StudentRegistrationFormPage sRFP = new StudentRegistrationFormPage();
        sRFP.openPage()
                .enterLastName(lastName)
                .enterFirstName(firstName)
                .enterEmail(email)
                .clickButtonGender()
                .enterPhone(phoneNumber)
                .choiceSubjects(subjects)
                .choiceHobbies(hobbies)
                .enterCurrentAddress(currentAddress)
                .enterState(state)
                .enterCity(city)
                .fileUpLoad()
                .enterDateCalendar(yearBirth, mouthBirth, dayBirth)
                .sendForm();
        //Selenide.sleep(1000000);

    }
}