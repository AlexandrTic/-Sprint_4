package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionsAboutImportantThings {

    private WebDriver driver;

    public static final String whatIsThePriceTextExpected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String severalScootersTextExpected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String rentalTimeCalculationTextExpected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String orderTodayTextExpected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String extendOrReturnEarlierTextExpected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String chargingWithScooterTextExpected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String cancelTheOrderTextExpected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String outsideTheMoscowRingRoadTextExpected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public static final String clickWhatIsThePriceTextActual = ".//div[@id = 'accordion__heading-0']";//xpath для клика на 1-й вопрос
    public static final String clickSeveralScootersTextActual = ".//div[@id = 'accordion__heading-1']";//xpath для клика на 2-й вопрос
    public static final String clickRentalTimeCalculationTextActual = ".//div[@id = 'accordion__heading-2']";//xpath для клика на 3-й вопрос
    public static final String clickOrderTodayTextActual = ".//div[@id = 'accordion__heading-3']";//xpath для клика на 4-й вопрос
    public static final String clickExtendOrReturnEarlierTextActual = ".//div[@id = 'accordion__heading-4']";//xpath для клика на 5-й вопрос
    public static final String clickChargingWithScooterTextActual = ".//div[@id = 'accordion__heading-5']";//xpath для клика на 6-й вопрос
    public static final String clickCancelTheOrderTextActual = ".//div[@id = 'accordion__heading-6']";//xpath для клика на 7-й вопрос
    public static final String clickOutsideTheMoscowRingRoadTextActual = ".//div[@id = 'accordion__heading-7']";//xpath для клика на 8-й вопрос

    public static final String WhatIsThePriceTextActual = ".//div[@id = 'accordion__panel-0']";//xpath для ответа на 1-й вопрос
    public static final String SeveralScootersTextActual = ".//div[@id = 'accordion__panel-1']";//xpath для ответа на 2-й вопрос
    public static final String RentalTimeCalculationTextActual = ".//div[@id = 'accordion__panel-2']";//xpath для ответа на 3-й вопрос
    public static final String OrderTodayTextActual = ".//div[@id = 'accordion__panel-3']";//xpath для ответа на 4-й вопрос
    public static final String ExtendOrReturnEarlierTextActual = ".//div[@id = 'accordion__panel-4']";//xpath для ответа на 5-й вопрос
    public static final String ChargingWithScooterTextActual = ".//div[@id = 'accordion__panel-5']";//xpath для ответа на 6-й вопрос
    public static final String CancelTheOrderTextActual = ".//div[@id = 'accordion__panel-6']";//xpath для ответа на 7-й вопрос
    public static final String OutsideTheMoscowRingRoadTextActual = ".//div[@id = 'accordion__panel-7']";//xpath для ответа на 8-й вопрос

    public QuestionsAboutImportantThings (WebDriver driver){
        this.driver = driver;
    }


    public WebElement clickElementToAnswerTheQuestion(String elementForClick){
        WebElement element = driver.findElement(By.xpath(String.valueOf(elementForClick)));
        element.click();
        return element;
    }

    public String findElementActualText (String receivedText){

        String textActual = driver.findElement(By.xpath(receivedText)).getAttribute("innerHTML").replace("<p>", "").replace("</p>", "");
        return textActual;
    }
}