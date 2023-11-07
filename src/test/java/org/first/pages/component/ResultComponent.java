package org.first.pages.component;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private SelenideElement reusltModalForm = $("tbody");

    public void checkResult(String[] paramName, String[] paramResult){
        for (int i = 0; i < paramResult.length; i++) {
            reusltModalForm.$(byText(paramName[i])).sibling(0).shouldHave(text(paramResult[i]));
        }
    }
    public void checkFailResult(){
        $("#userForm.was-validated").shouldBe(visible);
        reusltModalForm.shouldBe(hidden);
    }
}
