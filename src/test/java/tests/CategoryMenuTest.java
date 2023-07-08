package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrlStartingWith;
import static io.qameta.allure.Allure.step;

public class CategoryMenuTest extends TestBase {
    static Stream<Arguments> checkLinksCategoryMenu() {
        return Stream.of(
                Arguments.of("Отчетность", "https://kontur.ru/products/reporting", "Все для отчетности"),
                Arguments.of("Проверка контрагентов", "https://kontur.ru/products/check", "Контур.Фокус"),
                Arguments.of("Торги и закупки", "https://kontur.ru/products/trades", "Контур.Торги"),
                Arguments.of("Новому бизнесу", "https://kontur.ru/business-start",
                        "Консультации новым бизнесам")
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Переход по элементу {0} в меню категорий")
    void checkLinksCategoryMenu(String element, String link, String heading) {
        step("Открыть главную страницу", () -> {
            open("/");
        });
        step("Нажать на элемент в меню категорий", () -> {
            $(".category-menu-list").$(byText(element)).click();
        });
        step("Проверить, что произошел переход по ссылке", () -> {
            webdriver().shouldHave(currentFrameUrlStartingWith(link));
        });
        step("Проверить заголовок на странице", () -> {
            $("h1").shouldHave(text(heading));
        });
    }
}