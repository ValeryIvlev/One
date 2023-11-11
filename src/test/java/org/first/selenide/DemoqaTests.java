package org.first.selenide;

import org.first.TestBase;

import org.first.testdata.UserDate;
import org.first.pages.StudentRegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DemoqaTests extends TestBase {
    @Test
    @DisplayName("Проверка формы регистрации студента заполнены все поля")
    void checkFormRegistrationStudent(){
        UserDate date = new UserDate();
        StudentRegistrationFormPage sRFP = new StudentRegistrationFormPage();
        String [] paramName= {"Student Name", "Student Email", "Gender", "Mobile",
                "Date of Birth", "Subjects", "Hobbies", "Picture", "Address", "State and City"};
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
                .checkResult(paramName, expected);
    }
    @Test
    @DisplayName("Проверка формы регистрации студента заполнены только обязательные поля")
    void checkFormRegistrationStudentRequiredFields(){
        UserDate date = new UserDate();
        StudentRegistrationFormPage sRFP = new StudentRegistrationFormPage();
        String [] paramName= {"Student Name", "Student Email", "Gender", "Mobile",
                "Date of Birth"};
        String [] expected = {date.firstName + " " + date.lastName, date.email, date.gender, date.phoneNumber,
                date.dayBirth+" "+date.mouthBirth+","+date.yearBirth};
        sRFP.openPage()
                .killBanner()
                .enterLastName(date.lastName)
                .enterFirstName(date.firstName)
                .enterEmail(date.email)
                .clickButtonGender(date.gender)
                .enterPhone(date.phoneNumber)
                .enterDateCalendar(date.yearBirth, date.mouthBirth, date.dayBirth)
                .sendForm()
                .checkResult(paramName, expected);
    }
    @Test
    @DisplayName("Проверка отображения ошибки при незаполнении обязательных полей")
    void checkRequiredFieldsFail(){
        StudentRegistrationFormPage sRFP = new StudentRegistrationFormPage();
        sRFP.openPage()
                .killBanner()
                .sendForm()
                .checkFailResult();
    }
}