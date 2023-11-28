package org.first.allure;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.first.allure.SimpleTests.REPO;
import static org.first.allure.SimpleTests.numberIssues;
import static org.openqa.selenium.By.linkText;

public class StepsPage {
    @Step("Открываем главную страницу")
    public StepsPage openPage(){
        open("https://github.com");
        return this;
    }
    @Step("Ищем репозиторий "+REPO)
    public StepsPage searchRepo(){
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").sendKeys(REPO);
        $("#query-builder-test").pressEnter();
        return this;
    }
    @Step("Кликаем по "+ REPO)
    public StepsPage clickOnRepo(){
        $(linkText(REPO)).click();
        return this;
    }
    @Step("Кликаем по issues")
    public StepsPage clickOnIssues(){
        $("#issues-tab").click();
        return this;
    }
    @Step("Ищем issues с номером " + numberIssues)
    public StepsPage searchIssues(){
        $(withText("#"+numberIssues)).should(exist);
        return this;
    }
}
