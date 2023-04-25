package qaguru.seilah.project.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TKTMainPage extends BasePage {
    private final SelenideElement acceptCookiesBtn = $("[class*='styles_cookieAccept'] button");

    @Override
    public TKTMainPage openEngVersion() {
        Selenide.open("/?culture=en");
        if(acceptCookiesBtn.is(visible)) {
            acceptCookiesBtn.click();
        }

        return this;
    }
}