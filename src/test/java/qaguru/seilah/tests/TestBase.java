package qaguru.seilah.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://tkt.ge";
        Configuration.browserSize = "1920x1080";
    }
}