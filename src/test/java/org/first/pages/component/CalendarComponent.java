package org.first.pages.component;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    @Step("Выбираем дату")
    public void setDate(String year, String mouth, String day){
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(mouth);
        $(".react-datepicker__day.react-datepicker__day--0"+day+":not(.react-datepicker__day--outside-month)").click();
    }
}
