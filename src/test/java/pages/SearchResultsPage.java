package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private SelenideElement resultTitle = $(".result__title");

    public void checkFirstResultInTheList(String value) {
        resultTitle.shouldHave(text(value));
    }
}