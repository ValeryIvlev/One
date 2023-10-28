package org.first.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormPage {
    private final SelenideElement inputFirstName = $("#firstName");
    private final SelenideElement inputLastName = $("#lastName");
    private final SelenideElement inputEmail = $("#userEmail");
    private final SelenideElement phoneNumber = $("#userNumber");
    private final SelenideElement inputSubjects = $("#subjectsInput");
    private final SelenideElement inputCurrentAddress = $("#currentAddress");
    private final SelenideElement inputState = $("#state");
    private final SelenideElement inputCity = $("#city");
    private final SelenideElement buttonSubmit = $("#submit");
    private final SelenideElement inputCalendar = $("#dateOfBirthInput");


    public StudentRegistrationFormPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public StudentRegistrationFormPage killBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public StudentRegistrationFormPage enterFirstName(String firstName){
        inputFirstName.sendKeys(firstName);
        return this;
    }
    public StudentRegistrationFormPage enterLastName(String LastName){
        inputLastName.sendKeys(LastName);
        return this;
    }
    public StudentRegistrationFormPage enterEmail(String Email){
        inputEmail.sendKeys(Email);
        return this;
    }
    public StudentRegistrationFormPage clickButtonGender(String gender){
        $(byText(gender)).click();
        return this;
    }
    public StudentRegistrationFormPage enterPhone(String phone){
        phoneNumber.sendKeys(phone);
        return this;
    }
    public StudentRegistrationFormPage choiceSubjects(String... subjects){
        for (int i = 0; i < subjects.length; i++) {
            inputSubjects.sendKeys(subjects[i]);
            inputSubjects.pressEnter();
        }
        return this;
    }
    public StudentRegistrationFormPage choiceHobbies(String... hobbies){
        for (int i = 0; i < hobbies.length; i++) {
            $(byText(hobbies[i])).click();
        }
        return this;
    }
    public StudentRegistrationFormPage enterCurrentAddress(String address){
        inputCurrentAddress.sendKeys(address);
        return this;
    }
    public StudentRegistrationFormPage enterState(String state){
        inputState.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }
    public StudentRegistrationFormPage enterCity(String city){
        inputCity.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }
    public StudentRegistrationFormPage fileUpLoad(){
        File file = new File("src/test/resources/1.png");
        $("#uploadPicture").uploadFile(file);
        return this;
    }
    public RegistrationResultPage sendForm(){
        buttonSubmit.click();
        return Selenide.page(RegistrationResultPage.class);
    }
    public StudentRegistrationFormPage enterDateCalendar(String year, String mouth, String day){
        CalendarPage calendar = new CalendarPage();
        inputCalendar.click();
        calendar.setDate(year, mouth, day);
        return this;
    }
}
