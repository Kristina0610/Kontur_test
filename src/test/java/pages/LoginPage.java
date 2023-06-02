package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    SelenideElement mail = $("[name=login]"),
            password = $("[type=password]"),
            loginButton = $("[data-tid=btn-login]");
    public LoginPage openPage() {
        open("https://auth.kontur.ru/login/");
        return this;
    }
    public LoginPage inputMail() {
        mail.sendKeys(Keys.CONTROL + "A");
        mail.sendKeys(Keys.BACK_SPACE);
        mail.setValue("test_kontur2023@mail.ru");
        return this;
    }
    public LoginPage inputPassword() {
        password.setValue("TLr43V4bG9GGML7");
        return this;
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }
}