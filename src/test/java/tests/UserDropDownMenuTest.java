package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;
import static io.qameta.allure.Allure.step;

public class UserDropDownMenuTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Проверка отображения имени и фамилии авторизованного пользователя в выпадающем меню")
    void checkFullNameInDropDownMenu() {
        step("Открыть страницу авторизации", () -> {
            loginPage.openPage();
        });
        step("Ввести значение в поле 'Почта'", () -> {
            loginPage.inputMail("test_kontur2023@mail.ru");
        });
        step("Ввести значение в поле 'Пароль'", () -> {
            loginPage.inputPassword("TLr43V4bG9GGML7");
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
    void checkLinkPersonalAccountInDropDownMenu() {
        step("Открыть страницу авторизации", () -> {
            loginPage.openPage();
        });
        step("Ввести значение в поле 'Почта'", () -> {
            loginPage.inputMail("test_kontur2023@mail.ru");
        });
        step("Ввести значение в поле 'Пароль'", () -> {
            loginPage.inputPassword("TLr43V4bG9GGML7");
        });
        step("Нажать на кнопку 'Войти'", () -> {
            loginPage.clickLoginButton();
        });
        step("Нажать на иконку пользователя", () -> {
            $(".user-block").click();
        });
        step("Нажать на 'Личный кабинет' в выпадающем меню", () -> {
            $(".user-block").sibling(0).$(byText("Личный кабинет")).click();
            switchTo().window(1);
        });
        step("Проверить, что произошел переход в личный кабинет пользователя", () -> {
            webdriver().shouldHave(urlStartingWith("https://cabinet.kontur.ru/"));
            $("[data-test-id=fullname-label]").shouldHave(text("Surname-Йцу Name-Йцу Patronymic"));
        });
    }

    @Test
    @DisplayName("Выход из системы из выпадающего меню")
    void logOutThroughDropDownMenu() {
        step("Открыть страницу авторизации", () -> {
            loginPage.openPage();
        });
        step("Ввести значение в поле 'Почта'", () -> {
            loginPage.inputMail("test_kontur2023@mail.ru");
        });
        step("Ввести значение в поле 'Пароль'", () -> {
            loginPage.inputPassword("TLr43V4bG9GGML7");
        });
        step("Нажать на кнопку 'Войти'", () -> {
            loginPage.clickLoginButton();
        });
        step("Нажать на иконку пользователя", () -> {
            $(".user-block").click();
        });
        step("Нажать на кнопку 'Выход' в выпадающем меню", () -> {
            $(".user-block").sibling(0).$(byText("Выход")).click();
        });
        step("Проверить, что иконка пользователя исчезла", () -> {
            $(".user-block").shouldNotBe(visible);
        });
        step("Перейти по ссылке https://cabinet.kontur.ru/ и убедиться, что пользователь разлогинен", () -> {
            open("https://cabinet.kontur.ru/");
            webdriver().shouldHave(urlStartingWith("https://auth.kontur.ru/"));
        });
    }
}