package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionsAboutImportantThings {

    private WebDriver driver;

    public static final By CLICK_EVERYONE_IS_USED_TO_THE_BUTTON = By.className("App_CookieButton__3cvqF");//кнопка ок с куками
    public static final String URL_SITE_ORDER_SCOOTER = "https://qa-scooter.praktikum-services.ru/";//адрес сайта по заказу самокатов
    public static final By SCROLL_TO_LIST_OF_QUESTIONS = By.className("accordion");// скролл до вопросов

    public static final String WHAT_IS_THE_PRICE_TEXT_EXPECTED = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String SEVERAL_SCOOTERS_TEXT_EXPECTED = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String RENTAL_TIME_CALCULATION_TEXT_EXPECTED = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ORDER_TODAY_TEXT_EXPECTED = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String EXTEND_OR_RETURN_EARLIER_TEXT_EXPECTED = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String CHARGING_WITH_SCOOTER_TEXT_EXPECTED = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String CANCEL_THE_ORDER_TEXT_EXPECTED = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String OUTSIDE_THE_MOSCOW_RING_ROAD_TEXT_EXPECTED = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public static final String CLICK_WHAT_IS_THE_PRICE_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-0']";//xpath для клика на 1-й вопрос
    public static final String CLICK_SEVERAL_SCOOTERS_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-1']";//xpath для клика на 2-й вопрос
    public static final String CLICK_RENTAL_TIME_CALCULATION_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-2']";//xpath для клика на 3-й вопрос
    public static final String CLICK_ORDER_TODAY_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-3']";//xpath для клика на 4-й вопрос
    public static final String CLICK_EXTEND_OR_RETURN_EARLIER_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-4']";//xpath для клика на 5-й вопрос
    public static final String CLICK_CHARGING_WITH_SCOOTER_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-5']";//xpath для клика на 6-й вопрос
    public static final String CLICK_CANCEL_THE_ORDER_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-6']";//xpath для клика на 7-й вопрос
    public static final String CLICK_OUTSIDE_THE_MOSCOW_RING_ROAD_TEXT_ACTUAL = ".//div[@id = 'accordion__heading-7']";//xpath для клика на 8-й вопрос

    public static final String WHAT_IS_THE_PRICE_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-0']";//xpath для ответа на 1-й вопрос
    public static final String SEVERAL_SCOOTERS_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-1']";//xpath для ответа на 2-й вопрос
    public static final String RENTAL_TIME_CALCULATION_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-2']";//xpath для ответа на 3-й вопрос
    public static final String ORDER_TODAY_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-3']";//xpath для ответа на 4-й вопрос
    public static final String EXTEND_OR_RETURN_EARLIER_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-4']";//xpath для ответа на 5-й вопрос
    public static final String CHARGING_WITH_SCOOTER_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-5']";//xpath для ответа на 6-й вопрос
    public static final String CANCEL_THE_ORDER_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-6']";//xpath для ответа на 7-й вопрос
    public static final String OUTSIDE_THE_MOSCOW_RING_ROAD_TEXT_ACTUAL = ".//div[@id = 'accordion__panel-7']";//xpath для ответа на 8-й вопрос

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

    public void startTest(){
        driver.manage().window().maximize();
        driver.get(URL_SITE_ORDER_SCOOTER);
        WebElement everyoneIsUsedToTheButton = driver.findElement(CLICK_EVERYONE_IS_USED_TO_THE_BUTTON);
        everyoneIsUsedToTheButton.click();
        WebElement listQuation = driver.findElement(SCROLL_TO_LIST_OF_QUESTIONS);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", listQuation);
    }

    public void quitBrows(){
        driver.quit();
    }
}