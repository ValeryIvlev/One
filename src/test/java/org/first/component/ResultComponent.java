package org.first.component;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private static final String [] MODAL_WINDOW_LABELS= {"Student Name", "Student Email", "Gender", "Mobile",
            "Date of Birth", "Subjects", "Hobbies", "Picture", "Address", "State and City"};

    public void checkResult(String... textsExp){
        for (int i = 0; i < textsExp.length; i++) {
            $("tbody").$(byText(MODAL_WINDOW_LABELS[i])).sibling(0).shouldHave(text(textsExp[i]));
        }
    }
}
