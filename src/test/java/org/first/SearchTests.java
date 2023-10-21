package org.first;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests extends TestBase {

    @Test
    @DisplayName("First test")
    void selenideSerachTest(){
        open("https://www.google.com");
        $("[name=q]").setValue("selenide").pressEnter();
        $("#search").shouldHave(text("selenide.org"));
    }
}
