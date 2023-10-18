package org.example;

import main.QuestionsAboutImportantThings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static main.QuestionsAboutImportantThings.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class QuestionsAboutImportantThingsTest {

    private static WebDriver driver;


    private final String expectedText;
    private final String elementForClick;
    private final String receivedText;


    public QuestionsAboutImportantThingsTest (String expectedText, String elementForClick, String receivedText){

        this.expectedText = expectedText;
        this.elementForClick = elementForClick;
        this.receivedText = receivedText;

    }

    @Parameterized.Parameters

    public static Object[][] testData(){
        return new Object[][]{
                {WHAT_IS_THE_PRICE_TEXT_EXPECTED, CLICK_WHAT_IS_THE_PRICE_TEXT_ACTUAL, WHAT_IS_THE_PRICE_TEXT_ACTUAL},
                {SEVERAL_SCOOTERS_TEXT_EXPECTED, CLICK_SEVERAL_SCOOTERS_TEXT_ACTUAL, SEVERAL_SCOOTERS_TEXT_ACTUAL},
                {RENTAL_TIME_CALCULATION_TEXT_EXPECTED, CLICK_RENTAL_TIME_CALCULATION_TEXT_ACTUAL, RENTAL_TIME_CALCULATION_TEXT_ACTUAL},
                {ORDER_TODAY_TEXT_EXPECTED, CLICK_ORDER_TODAY_TEXT_ACTUAL, ORDER_TODAY_TEXT_ACTUAL},
                {EXTEND_OR_RETURN_EARLIER_TEXT_EXPECTED, CLICK_EXTEND_OR_RETURN_EARLIER_TEXT_ACTUAL, EXTEND_OR_RETURN_EARLIER_TEXT_ACTUAL},
                {CHARGING_WITH_SCOOTER_TEXT_EXPECTED, CLICK_CHARGING_WITH_SCOOTER_TEXT_ACTUAL, CHARGING_WITH_SCOOTER_TEXT_ACTUAL},
                {CANCEL_THE_ORDER_TEXT_EXPECTED, CLICK_CANCEL_THE_ORDER_TEXT_ACTUAL, CANCEL_THE_ORDER_TEXT_ACTUAL},
                {OUTSIDE_THE_MOSCOW_RING_ROAD_TEXT_EXPECTED, CLICK_OUTSIDE_THE_MOSCOW_RING_ROAD_TEXT_ACTUAL, OUTSIDE_THE_MOSCOW_RING_ROAD_TEXT_ACTUAL},
        };
    }

    @Before
    public void startChrome(){
        driver = new ChromeDriver();
        QuestionsAboutImportantThings questionsAboutImportantThings = new QuestionsAboutImportantThings(driver);
        questionsAboutImportantThings.startTest();
    }

    @Test
    public void questionsAboutImportantThingsNotExistTest () {

        QuestionsAboutImportantThings questionsAboutImportantThings = new QuestionsAboutImportantThings(driver);
        questionsAboutImportantThings.clickElementToAnswerTheQuestion(elementForClick);
        String actualText = questionsAboutImportantThings.findElementActualText(receivedText);
        assertEquals(expectedText, actualText);
    }

    @After

    public void tearDown(){
        QuestionsAboutImportantThings questionsAboutImportantThings = new QuestionsAboutImportantThings(driver);
        questionsAboutImportantThings.quitBrows();

    }
}