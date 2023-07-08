package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class VacanciesSectionTest extends TestBase {
    @Test
    @DisplayName("Выбор города для отображения вакансий")
    void checkChoosingCityDisplayVacancies() {
        step("Открыть страницу с вакансиями", () -> {
            open("/career/vacancies/");
        });
        step("Открыть список городов", () -> {
            $(".selectRegion").$(".arrow-control ").click();
        });
        step("Выбрать город 'Стерлитамак'", () -> {
            $("#careerCityPopup").$(byText("Стерлитамак")).click();
        });
        step("Проверить, что выбран город 'Стерлитамак'", () -> {
            $(".selectRegion").$(".link").shouldHave(text("Стерлитамак"));
            webdriver().shouldHave(url("https://kontur.ru/career/vacancies/city-6345"));
        });
    }

    @Test
    @DisplayName("Открытие формы с вопросом к HR по вакансии")
    void openingFormWithQuestionToHrAboutVacancy() {
        step("Открыть страницу с вакансиями", () -> {
            open("/career/vacancies/");
        });
        step("Перейти на карточку ванкасии", () -> {
            $(".vacancy__title").click();
        });
        step("Нажать на кнопку 'пишите', которая открывает форму с вопросом к HR о вакансии", () -> {
            $(".specialist__text").$(byText("пишите.")).click();
        });
        step("Проверить, что форма открылась", () -> {
            $("#tinyFeedbackLightboxContent").$(".lightbox-title").shouldHave(text("Напишите нам"));
        });
    }
}
