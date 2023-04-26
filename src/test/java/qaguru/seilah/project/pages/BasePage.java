package qaguru.seilah.project.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {
    protected final SelenideElement acceptCookiesBtn = $("[class*='styles_cookieAccept'] button");

    public abstract BasePage openEngVersion();
}