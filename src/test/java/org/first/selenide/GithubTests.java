package org.first.selenide;

import com.codeborne.selenide.Selenide;
import org.first.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubTests extends TestBase {

    @Test
    @DisplayName("Проверка наличия примера кода для JUnit5")
    void checkJUnit5BlockText(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#user-content-chapters").sibling(0).$("li").shouldBe(visible);
        $("#user-content-chapters").sibling(0).$$("li")
                .filterBy(text("Soft assertions")).shouldHave(size(1));
        $("#user-content-chapters").sibling(0).$$("li")
                .findBy(text("Soft assertions")).$(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
    @Test
    @DisplayName("Проверка наличия примера кода для JUnit5")
    void checkJUnit5BlockText2(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-box").$(byText("Show 3 more pages…")).click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));
    }
}
