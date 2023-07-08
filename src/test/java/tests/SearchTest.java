package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {
    @Test
    @DisplayName("Работа поиска")
    void checkSearch() {
        step("Открыть главную страницу", () -> {
            open("/");
        });
        step("Ввести 'Контур.Школа' в поле поиска и нажать Enter", () -> {
            $(".footer-search__input").setValue("Контур.Школа").pressEnter();
        });
        step("Проверить, что в списке результатов есть 'Контур.Школа'", () -> {
            $(".result__title").shouldHave(text("Контур.Школа"));
        });
    }
}