package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;
import static io.qameta.allure.Allure.step;

public class KonturTests extends TestBase{
    @Test
    @DisplayName("Выбор города для отображения вакансий")
    void TestCityVacancies(){
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

    static Stream<Arguments> linksCategoryMenu() {
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
    void linksCategoryMenu(String element, String link, String heading){
        step("Открыть главную страницу", () -> {
            open("/");
        });
        step("Нажать на элемент в меню категорий", () -> {
          $(".category-menu-list").$(byText(element)).click();
        });
        step("Проверить, что открылась ссылка", () -> {
            webdriver().shouldHave(url(link));
        });
        step("Проверить заголовок на странице", () -> {
            $("h1").shouldHave(text(heading));
        });
    }

    @Test
    @DisplayName("Проверка отображения имени и фамилии авторизованного пользователя в выпадающем меню")
    void loginAccount(){
        step("Открыть страницу авторизации", () -> {
            loginPage.openPage();
        });
        step("Ввести значение в поле 'Почта'", () -> {
            loginPage.inputMail();
        });
        step("Ввести значение в поле 'Пароль'", () -> {
            loginPage.inputPassword();
        });
        step("Нажать на кнопку 'Войти'", () -> {
            loginPage.clickLoginButton();
        });
        step("Нажать на иконку пользователя", () -> {
            $(".user-block").click();
        });
        step("Проверить, что в выпадающем меню отображается имя и фамилия пользователя", () -> {
            $(".user-block").sibling(0).shouldBe(visible).shouldHave(text("Name-Йцу Surname-Йцу"));
        });
    }

    @Test
    @DisplayName("Переход в личный кабинет пользователя при нажатии на 'Личный кабинет' в выпадающем меню")
    void footerOpenChat(){
        step("Открыть страницу авторизации", () -> {
            loginPage.openPage();
        });
        step("Ввести значение в поле 'Почта'", () -> {
            loginPage.inputMail();
        });
        step("Ввести значение в поле 'Пароль'", () -> {
            loginPage.inputPassword();
        });
        step("Нажать на кнопку 'Войти'", () -> {
            loginPage.clickLoginButton();
        });
        step("Нажать на иконку пользователя", () -> {
            $(".user-block").click();
        });
        step("Нажать на 'Личный кабинет' в выпадающем меню", () -> {
            $(".user-block").sibling(0).shouldBe(text("Личный кабинет")).click();
            switchTo().window(1);
        });
        step("Проверить, что произошел переход в личный кабинет пользователя", () -> {
            webdriver().shouldHave(urlStartingWith("https://cabinet.kontur.ru/"));
            $("[data-test-id=fullname-label]").shouldHave(text("Surname-Йцу Name-Йцу Patronymic"));
        });
    }

    @Test
    @DisplayName("Работа поиска")
    void testSearch(){
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