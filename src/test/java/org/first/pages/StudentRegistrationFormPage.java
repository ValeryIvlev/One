package org.first.pages;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.first.pages.component.CalendarComponent;
import org.first.pages.component.ResultComponent;


import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

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

    @Step("Открываем главную страницу")
    public StudentRegistrationFormPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    @Step("Убираем баннеры")
    public StudentRegistrationFormPage killBanner(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    @Step("Вводим Имя")
    public StudentRegistrationFormPage enterFirstName(String firstName){
        inputFirstName.sendKeys(firstName);
        return this;
    }
    @Step("Вводим Фамилию")
    public StudentRegistrationFormPage enterLastName(String LastName){
        inputLastName.sendKeys(LastName);
        return this;
    }
    @Step("Вводим емейл")
    public StudentRegistrationFormPage enterEmail(String email){
        inputEmail.sendKeys(email);
        return this;
    }
    @Step("Выбираем пол")
    public StudentRegistrationFormPage clickButtonGender(String gender){
        $(byText(gender)).click();
        return this;
    }
    @Step("Вводим телефон")
    public StudentRegistrationFormPage enterPhone(String phone){
        phoneNumber.sendKeys(phone);
        return this;
    }
    @Step("Выбираем субъекты")
    public StudentRegistrationFormPage choiceSubjects(String... subjects){
        for (int i = 0; i < subjects.length; i++) {
            inputSubjects.sendKeys(subjects[i]);
            inputSubjects.pressEnter();
        }
        return this;
    }
    @Step("Выбираем хобби")
    public StudentRegistrationFormPage choiceHobbies(String... hobbies){
        for (int i = 0; i < hobbies.length; i++) {
            $(byText(hobbies[i])).click();
        }
        return this;
    }
    @Step("Заполняем Адрес")
    public StudentRegistrationFormPage enterCurrentAddress(String address){
        inputCurrentAddress.sendKeys(address);
        return this;
    }
    @Step("Выбираем штат")
    public StudentRegistrationFormPage enterState(String state){
        inputState.click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }
    @Step("Выбираем город")
    public StudentRegistrationFormPage enterCity(String city){
        inputCity.click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }
    @Step("Загружаем картинку")
    public StudentRegistrationFormPage fileUpLoad(){
        File file = new File("src/test/resources/1.png");
        $("#uploadPicture").uploadFile(file);
        return this;
    }
    @Step("Кликаем по кнопке submit")
    public ResultComponent sendForm(){
        buttonSubmit.click();
        return Selenide.page(ResultComponent.class);
    }
    @Step("Кликаем по календарю")
    public StudentRegistrationFormPage enterDateCalendar(String year, String mouth, String day){
        CalendarComponent calendar = new CalendarComponent();
        inputCalendar.click();
        calendar.setDate(year, mouth, day);
        return this;
    }
}
