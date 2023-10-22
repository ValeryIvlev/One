package org.first.helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Calendar {

    public void setDate(String year, String mouth, String day){
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(mouth);
        $(".react-datepicker__day.react-datepicker__day--"+day+":not(.react-datepicker__day--outside-month)").click();
    }
}
