package com.vesska;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
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
    void checkHeaderModuleLinks(String link) {
        $$(".header-module--headerLinks--mbXJY").shouldHave(CollectionCondition.texts(link));
    }


    static Stream<Arguments> checkQuestionModuleTexts() {
        return Stream.of(
                Arguments.of(0, "Кто может получить доступ к платформе?",
                        "Доступ и возможность заработать на сделках могут получить брокеры, риэлторы и другие эксперты рынка ипотеки и недвижимости." ),
                Arguments.of(1, "Как заработать на новостройках?",
                        "На нашей платформе есть сервис для подбора жилья. Он поможет заработать на продаже новостроек от наших партнеров застройщиков."),
                Arguments.of(2, "Что требуется, чтобы получить доступ?",
                        "Чтобы получить доступ, достаточно зарегистрироваться, указав контактные данные."),
                Arguments.of(3, "Продаю вторичку. Как переквалифицироваться на первичку?",
                        "Посещайте наши вебинары и мастер-классы, посвящённые заработку на новостройках. Регулярно используйте раздел «Новостройки» на платформе «Ипотека.Центр» — в нём много подсказок. Кроме того, за каждым пользователем закрепляется персональный куратор, который поможет разобраться во всех тонкостях."),
                Arguments.of(4, "Сколько это стоит?",
                        "Платформа «Ипотека.Центр» бесплатна. Также вам будут доступны обучающие программы, вебинары и мастер-классы, посвященные заработку на ипотеке. Кроме того, мы проводим закрытые профессиональные мероприятия для участников нашей партнёрской программы, куда обязательно вас пригласим."),
                Arguments.of(5, "Работа на платформе проще, чем напрямую с банком?",
                        "Да, ведь она создана, чтобы упрощать работу ипотечного специалиста. Наш сервис позволит вам:"),
                Arguments.of(6, "Какие ставки по ипотеке вы предлагаете?",
                        "Ставки на платформе соответствуют банковским программам. В некоторых случаях наши партнёрские отношения с банками позволяют предлагать клиентам ставку ниже общедоступных."),
                Arguments.of(7, "Как я буду получать заработанные деньги?",
                        "Ипотека.Центр позволяет получать доход от ипотечных сделок на карту или по реквизитам счёта. Вы можете работать с нами как самозанятый, ИП, юридическое или физическое лицо. Вы можете выводить как всю заработанную вами сумму, так и часть, в любое удобное время."),
                Arguments.of(8, "Что нужно сделать, чтобы заработать на платформе?",
                        "Нужно подобрать для клиента оптимальный банк и организовать сделку. То есть пройти по привычному процессу, но на нашей платформе."),
                Arguments.of(9, "Нужно ли заключать с вами трудовой договор?",
                        "Вам не придётся заключать с нами трудовой договор, чтобы заработать на ипотеке. Достаточно принять условия пользовательского соглашения в нашем сервисе."),
                Arguments.of(10, "А если у меня совсем мало опыта?",
                        "Оставляйте заявку! Мы подскажем альтернативные варианты, как заработать и получить недостающий опыт.")

        );
    }
    @MethodSource
    @ParameterizedTest(name = "Проверка текстовок в пунктах дигитальной ипотеки")
    @Tag("Critical")
    void checkQuestionModuleTexts(int number, String point, String text){
        $(".accordion-module--accordion--o7C1P").hover();
        $("#accordion__title-"+ number).shouldHave(text(point)).click();
        $("#accordion__body-"+ number).shouldHave(text(text));



    }
}
