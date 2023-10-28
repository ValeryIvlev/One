package org.first.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.first.TestConstant.MODAL_WINDOW_LABELS;

public class RegistrationResultPage {

    public void checkResult(String... textsExp){
        for (int i = 0; i < textsExp.length; i++) {
            $("tbody").$(byText(MODAL_WINDOW_LABELS[i])).sibling(0).shouldHave(text(textsExp[i]));
        }
    }
}
