package qaguru.seilah.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import qaguru.seilah.project.pages.CityToCityPage;
import qaguru.seilah.project.pages.RailwayPage;

import java.util.List;
import java.util.stream.Stream;

public class PopularDestinationsHeadersTest extends TestBase {
    private final RailwayPage railwayPage = new RailwayPage();
    private final CityToCityPage cityToCityPage = new CityToCityPage();

    @BeforeEach
    public void precondition() {
        railwayPage.openEngVersion();
    }

    @CsvFileSource(resources = "/headerTestTexts.csv")
    @ParameterizedTest(name = "Заголовок на странице {0} содержзит текст {1}")
    public void quickSearchPositiveTest(String imgHeader, String headerText) {
        railwayPage.clickOnPopularDestinationBlock(imgHeader);
        cityToCityPage.checkHeader(headerText);
    }
}