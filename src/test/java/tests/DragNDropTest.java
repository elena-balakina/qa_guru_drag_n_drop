package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragNDropTest {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void dragNDropActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement rectangleA = $("#column-a").shouldHave(text("A"));
        SelenideElement rectangleB = $("#column-b").shouldHave(text("B"));

        // option 1 - does not work
//        actions().dragAndDrop(rectangleA, rectangleB);

        // option 2 - does not work
//        actions().clickAndHold(rectangleA).build().perform();
//        actions().moveToElement(rectangleB).release(rectangleA).build().perform();

        // option 3 - does not work
//        actions().clickAndHold(rectangleA).moveToElement(rectangleB).release().perform();

        rectangleA.$("header").shouldHave(text("B"));
        rectangleB.$("header").shouldHave(text("A"));
    }

    @Test
    public void dragNDropNoActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement rectangleA = $("#column-a").shouldHave(text("A"));
        SelenideElement rectangleB = $("#column-b").shouldHave(text("B"));

        rectangleA.dragAndDropTo(rectangleB);

        rectangleA.$("header").shouldHave(text("B"));
        rectangleB.$("header").shouldHave(text("A"));
    }
}
