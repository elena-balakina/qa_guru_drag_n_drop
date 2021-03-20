package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class GithubTests {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void softAssertionsTest() {
        open("https://github.com/selenide/selenide");
        $("[data-content='Wiki']").click();
        $(byText("Soft assertions")).click();
        $("ol[start='3']").shouldHave(text("JUnit5"));
        $("ol[start='3'] + .highlight-source-java").should(visible);
    }
}
