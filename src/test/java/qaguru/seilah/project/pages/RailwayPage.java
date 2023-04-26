package qaguru.seilah.project.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class RailwayPage extends BasePage {
    private final ElementsCollection popularDestinationBlocksHeaders = $$("[class*='railwayItem__RailwayItemContainer'] h4");

    @Override
    public RailwayPage openEngVersion() {
        Selenide.open("/railway?culture=en");
        if(acceptCookiesBtn.is(visible)) {
            acceptCookiesBtn.click();
        }

        return this;
    }

    public RailwayPage clickOnPopularDestinationBlock(String header) {
        popularDestinationBlocksHeaders.findBy(text(header))
                .parent().parent().click();

        return this;
    }
}