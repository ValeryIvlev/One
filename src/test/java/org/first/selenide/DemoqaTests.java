package org.first.selenide;

import org.first.TestBase;

import org.first.pages.RegistrationResultPage;
import org.first.pages.StudentRegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
                .sendForm()
                .checkResult(new String[]{firstName + " " + lastName, email, gender, phoneNumber,dayBirth+" "+mouthBirth+","+yearBirth,
                String.join(", ",subjects), String.join(", ", hobbies), "1.png", currentAddress, state + " " + city});

    }
}