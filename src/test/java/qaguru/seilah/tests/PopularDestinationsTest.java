package qaguru.seilah.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import qaguru.seilah.project.pages.CityToCityPage;
import qaguru.seilah.project.pages.RailwayPage;

import java.util.List;
import java.util.stream.Stream;

public class PopularDestinationsTest extends TestBase {
    private final RailwayPage railwayPage = new RailwayPage();
    private final CityToCityPage cityToCityPage = new CityToCityPage();

    @BeforeEach
    public void precondition() {
        railwayPage.openEngVersion();
    }

    static Stream<Arguments> quickSearchPositiveTest() {
        return Stream.of(
                Arguments.of("Tbilisi - Batumi", List.of("Batumi", "Poti", "Tbilisi", "Poti")),
                Arguments.of("Batumi - Tbilisi", List.of("Tbilisi", "Poti", "Batumi", "Poti")),
                Arguments.of("Tbilisi - Poti", List.of("Batumi", "Poti", "Batumi", "Zugdidi"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Быстрый выбор города на странице {0} содержит кнопки: {1} ")
    public void quickSearchPositiveTest(String imgHeader, List<String> expectedQuickDestinations) {
        railwayPage.clickOnPopularDestinationBlock(imgHeader);
        cityToCityPage.checkQuickDestinations(expectedQuickDestinations);
    }
}