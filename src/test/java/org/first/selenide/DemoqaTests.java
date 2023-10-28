package org.first.selenide;

import org.first.TestBase;

import org.first.helpers.UserDate;
import org.first.pages.StudentRegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DemoqaTests extends TestBase {
    @Test
    @DisplayName("Проверка формы регистрации студента")
    void checkFormRegistrationStudent(){
        UserDate date = new UserDate();
        StudentRegistrationFormPage sRFP = new StudentRegistrationFormPage();
        String [] expected = {date.firstName + " " + date.lastName, date.email, date.gender, date.phoneNumber,
                date.dayBirth+" "+date.mouthBirth+","+date.yearBirth, String.join(", ",date.subjects),
                String.join(", ", date.hobbies), "1.png", date.currentAddress, date.state + " " + date.city};
        sRFP.openPage()
                .killBanner()
                .enterLastName(date.lastName)
                .enterFirstName(date.firstName)
                .enterEmail(date.email)
                .clickButtonGender(date.gender)
                .enterPhone(date.phoneNumber)
                .choiceSubjects(date.subjects)
                .choiceHobbies(date.hobbies)
                .enterCurrentAddress(date.currentAddress)
                .enterState(date.state)
                .enterCity(date.city)
                .fileUpLoad()
                .enterDateCalendar(date.yearBirth, date.mouthBirth, date.dayBirth)
                .sendForm()
                .checkResult(expected);
    }
}