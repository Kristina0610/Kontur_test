package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.FooterPage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTest extends TestBase {
    FooterPage footerPage = new FooterPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @Test
    @DisplayName("Работа поиска")
    void testSearch() {
        step("Открыть главную страницу", () ->
                open("/"));
        step("Ввести 'Контур.Школа' в поле поиска и нажать Enter", () ->
                footerPage.initiateSearch("Контур.Школа"));
        step("Проверить, что в списке результатов есть 'Контур.Школа'", () ->
                searchResultsPage.checkFirstResultInTheList("Контур.Школа"));
    }
}