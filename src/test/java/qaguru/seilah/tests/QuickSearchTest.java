package qaguru.seilah.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import qaguru.seilah.project.components.HeaderComponent;
import qaguru.seilah.project.pages.TKTMainPage;

public class QuickSearchTest extends TestBase {
    private final TKTMainPage tktMainPage = new TKTMainPage();
    private final HeaderComponent headerComponent = new HeaderComponent();

    @BeforeEach
    public void precondition() {
        tktMainPage.openEngVersion();
    }

    @CsvSource({
            "Monohall, MonoHall (Old Cinema House)",
            "Amirani, Amirani Cinema"
    })

    @ParameterizedTest(name = "При быстром поиске по локации {0}" +
            " в выдаче есть результат с местом проведения {1}")
    public void quickSearchPositiveTest(String searchQuery, String expectedText) {
        headerComponent.setValueToInput(searchQuery)
                        .checkResultInQuickSearchDropdown(expectedText);
    }
}