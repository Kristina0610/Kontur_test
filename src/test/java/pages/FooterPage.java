package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FooterPage {
    private SelenideElement searchField = $(".footer-search__input");

    public void initiateSearch(String value) {
        searchField.setValue(value).pressEnter();
    }
}
