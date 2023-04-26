package qaguru.seilah.project.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CityToCityPage extends BasePage {
    private final ElementsCollection quickDestinations = $$("[class*='RailwayListFilterContainer'] [class*='RailwayFilterShortcutChip']");

    @Override
    public CityToCityPage openEngVersion() {
        return null;
    }

    public CityToCityPage checkQuickDestinations(List<String> destinations) {
        quickDestinations.filter(visible)
                .shouldHave(CollectionCondition.texts(destinations));

        return this;
    }
}