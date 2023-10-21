package org.first;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    @BeforeAll
    static void beforeAll() {

        Configuration.baseUrl = "https://ya.ru";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 120000;
        Configuration.headless = false;
        Configuration.webdriverLogsEnabled = true;
        Configuration.browser = Browsers.CHROME;


    }

    @AfterEach
    void setUp() {

        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }


}

