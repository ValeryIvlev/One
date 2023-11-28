package org.first.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.first.TestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SimpleTests extends TestBase {
    public static final String REPO = "eroshenkoam/allure-example";
    public static final int numberIssues = 80;
    @Test
    void selenideListenerTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(REPO);
        $("#query-builder-test").pressEnter();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#"+numberIssues)).should(exist);
    }
    @Test
    void selenideListenerTestWithLambdaSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPO, () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").sendKeys(REPO);
            $("#query-builder-test").pressEnter();
        });

        step("Кликаем по " + REPO, () -> {
            $(linkText(REPO)).click();
        });

        step("Кликаем по issues", () -> {
            $("#issues-tab").click();
        });

        step("Ищем issues с номером " + numberIssues, () -> {
            $(withText("#"+numberIssues)).should(exist);
        });
    }

    @Test
    void selenideListenerTestWithSteps(){
        StepsPage stepsPage = new StepsPage();
        stepsPage.openPage()
                .searchRepo()
                .clickOnRepo()
                .clickOnIssues()
                .searchIssues();
    }

}
