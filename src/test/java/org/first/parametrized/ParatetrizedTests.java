package org.first.parametrized;

import org.first.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ParatetrizedTests extends TestBase {

    void enjoyDodoMusic(Long milliseconds){
        sleep(milliseconds);
    }
    @ValueSource(strings = {
            ".NET developer",
            "Fullstack developer",
            "Data Analyst"
    })

    @ParameterizedTest(name = "Проверка перехода к актуальной вакансии {0}")
    void checkingCorrectLinkCurrentVacancies (String vacancy){
        //ВАЖНО УСТАНОВИТЕ ЗНАЧЕНИЕ НАСЛАЖДЕНИЯ ДОДО МУЗЫКОЙ ПЕРЕД ЗАПУСКОМ ТЕСТА! enjoyDodoMusic
        open("https://dodo.dev/");
        $(".audio").click();
        $(".input-wrapper").shouldBe(visible);
        actions().sendKeys("jobs").sendKeys(Keys.ENTER).perform();
        $(byText(vacancy)).click();
        switchTo().window(1);
        $(".position_u720v").shouldHave(text(vacancy));
        enjoyDodoMusic(30000L);
    }

    static Stream<Arguments> checkCorrectTextLanguageOnMainHeader(){
        return Stream.of(
        Arguments.of(
                Language.EN,
                List.of("Brands", "Technology", "Sales", "Investors", "Franchising", "Blog")
        ),
        Arguments.of(
                Language.RU,
                List.of("Бренды", "Технологии", "Продажи", "Инвестору", "Франшиза", "Книга", "Блог")
        )
                );
    }
    @MethodSource
    @ParameterizedTest(name = "Проверка корректного отображения блоков меню для языка {0}")
    void checkCorrectTextLanguageOnMainHeader(Language language, List<String> expectedMenuButtons){
        open("https://dodobrands.io/");
        if( $(".c-header__languages .c-toggle__item:not(.c-toggle__item--active)")
                .getText().equals(String.valueOf(language)) ){
            $(".c-header__languages").$(byText(String.valueOf(language))).click();
        }
        $$(".c-nav__list li").filterBy(visible).shouldHave(texts(expectedMenuButtons));
    }
    @EnumSource(Language.class)
    @ParameterizedTest(name = "Проверка цитаты текста для языка {0}")
    void checkTextPage(Language language){
        open("https://dodobrands.io/");
        if( $(".c-header__languages .c-toggle__item:not(.c-toggle__item--active)")
                .getText().equals(String.valueOf(language)) ){
            $(".c-header__languages").$(byText(String.valueOf(language))).click();
        }
        $(".c-quote").shouldHave(text(language.lang));
    }
}