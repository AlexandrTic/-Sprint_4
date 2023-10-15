package org.example;

import main.QuestionsAboutImportantThings;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
                {whatIsThePriceTextExpected, clickWhatIsThePriceTextActual, WhatIsThePriceTextActual},
                {severalScootersTextExpected, clickSeveralScootersTextActual, SeveralScootersTextActual},
                {rentalTimeCalculationTextExpected, clickRentalTimeCalculationTextActual, RentalTimeCalculationTextActual},
                {orderTodayTextExpected, clickOrderTodayTextActual, OrderTodayTextActual},
                {extendOrReturnEarlierTextExpected, clickExtendOrReturnEarlierTextActual, ExtendOrReturnEarlierTextActual},
                {chargingWithScooterTextExpected, clickChargingWithScooterTextActual, ChargingWithScooterTextActual},
                {cancelTheOrderTextExpected, clickCancelTheOrderTextActual, CancelTheOrderTextActual},
                {outsideTheMoscowRingRoadTextExpected, clickOutsideTheMoscowRingRoadTextActual, OutsideTheMoscowRingRoadTextActual},
        };
    }

    @Before
    public void startChrome(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement everyoneIsUsedToTheButton = driver.findElement(By.className("App_CookieButton__3cvqF"));
        everyoneIsUsedToTheButton.click();
        WebElement listQuation = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", listQuation);
    }

    @Test
    public void QuestionsAboutImportantThingsNotExistTest () {

        QuestionsAboutImportantThings questionsAboutImportantThings = new QuestionsAboutImportantThings(driver);
        questionsAboutImportantThings.clickElementToAnswerTheQuestion(elementForClick);
        String actualText = questionsAboutImportantThings.findElementActualText(receivedText);
        assertEquals(expectedText, actualText);
    }

    @After

    public void tearDown(){

        driver.quit();

    }
}