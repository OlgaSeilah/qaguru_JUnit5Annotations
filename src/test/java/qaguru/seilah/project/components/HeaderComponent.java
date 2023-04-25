package qaguru.seilah.project.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderComponent {

    private final SelenideElement mainElement = $("[class*='header__HeaderContainer-sc']");
    private final SelenideElement input = mainElement.$("input");
    private final SelenideElement firstResultBlock = mainElement.$$("[class*='SearchItemContainer']").first();
    private final SelenideElement placeNameInFirstResult = firstResultBlock.$$("p").last();

    public HeaderComponent setValueToInput(String placeName) {
        input.setValue(placeName);

        return this;
    }

    public HeaderComponent checkResultInQuickSearchDropdown(String result) {
        placeNameInFirstResult.shouldHave(text(result));

        return this;
    }
}
