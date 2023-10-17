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
                {What_Is_The_Price_Text_Expected, Click_What_Is_The_Price_Text_Actual, What_Is_The_Price_Text_Actual},
                {Several_Scooters_Text_Expected, Click_Several_Scooters_Text_Actual, Several_Scooters_Text_Actual},
                {Rental_Time_Calculation_Text_Expected, Click_Rental_Time_Calculation_Text_Actual, Rental_Time_Calculation_Text_Actual},
                {Order_Today_Text_Expected, Click_Order_Today_Text_Actual, Order_Today_Text_Actual},
                {Extend_Or_Return_Earlier_Text_Expected, Click_Extend_Or_Return_Earlier_Text_Actual, Extend_Or_Return_Earlier_Text_Actual},
                {Charging_With_Scooter_Text_Expected, Click_Charging_With_Scooter_Text_Actual, Charging_With_Scooter_Text_Actual},
                {Cancel_The_Order_Text_Expected, Click_Cancel_The_Order_Text_Actual, Cancel_The_Order_Text_Actual},
                {Outside_The_Moscow_Ring_Road_Text_Expected, Click_Outside_The_Moscow_Ring_Road_Text_Actual, Outside_The_Moscow_Ring_Road_Text_Actual},
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