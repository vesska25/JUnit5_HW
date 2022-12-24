package com.vesska;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.*;

public class TestIpotekaCenter {

    @BeforeEach
    void setUp() {
        open("https://ipoteka.center/");
        Configuration.holdBrowserOpen = true;
    }


    @CsvSource(value = { "Цифровая платформа", "Блог", "Ипотечный университет", "Карьера", "Мероприятия",
    })
    @ParameterizedTest(name = "Проверка наличия всех кнопок в шапке меню")
    @Tag("Critical")
    void checkMenuLinks(String link) {
        $$(".header-module--headerLinks--mbXJY").shouldHave(CollectionCondition.texts(link));
    }
}
