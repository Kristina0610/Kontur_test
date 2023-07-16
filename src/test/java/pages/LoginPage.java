package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private SelenideElement mail = $("[name=login]"),
            password = $("[type=password]"),
            loginButton = $("[data-tid=btn-login]");

    public void openPage() {
        open("https://auth.kontur.ru/login/");
    }

    public void inputMail(String value) {
        mail.setValue(value);
    }

    public void inputPassword(String value) {
        password.setValue(value);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}