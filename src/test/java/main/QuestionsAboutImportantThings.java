package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuestionsAboutImportantThings {

    private WebDriver driver;

    public static final By Click_Everyone_Is_Used_To_TheButton = By.className("App_CookieButton__3cvqF");//кнопка ок с куками
    public static final String Url_Site_Order_Scooter = "https://qa-scooter.praktikum-services.ru/";//адрес сайта по заказу самокатов
    public static final By Scroll_To_List_Of_Questions = By.className("accordion");// скролл до вопросов

    public static final String What_Is_The_Price_Text_Expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String Several_Scooters_Text_Expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String Rental_Time_Calculation_Text_Expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String Order_Today_Text_Expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String Extend_Or_Return_Earlier_Text_Expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String Charging_With_Scooter_Text_Expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String Cancel_The_Order_Text_Expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String Outside_The_Moscow_Ring_Road_Text_Expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    public static final String Click_What_Is_The_Price_Text_Actual = ".//div[@id = 'accordion__heading-0']";//xpath для клика на 1-й вопрос
    public static final String Click_Several_Scooters_Text_Actual = ".//div[@id = 'accordion__heading-1']";//xpath для клика на 2-й вопрос
    public static final String Click_Rental_Time_Calculation_Text_Actual = ".//div[@id = 'accordion__heading-2']";//xpath для клика на 3-й вопрос
    public static final String Click_Order_Today_Text_Actual = ".//div[@id = 'accordion__heading-3']";//xpath для клика на 4-й вопрос
    public static final String Click_Extend_Or_Return_Earlier_Text_Actual = ".//div[@id = 'accordion__heading-4']";//xpath для клика на 5-й вопрос
    public static final String Click_Charging_With_Scooter_Text_Actual = ".//div[@id = 'accordion__heading-5']";//xpath для клика на 6-й вопрос
    public static final String Click_Cancel_The_Order_Text_Actual = ".//div[@id = 'accordion__heading-6']";//xpath для клика на 7-й вопрос
    public static final String Click_Outside_The_Moscow_Ring_Road_Text_Actual = ".//div[@id = 'accordion__heading-7']";//xpath для клика на 8-й вопрос

    public static final String What_Is_The_Price_Text_Actual = ".//div[@id = 'accordion__panel-0']";//xpath для ответа на 1-й вопрос
    public static final String Several_Scooters_Text_Actual = ".//div[@id = 'accordion__panel-1']";//xpath для ответа на 2-й вопрос
    public static final String Rental_Time_Calculation_Text_Actual = ".//div[@id = 'accordion__panel-2']";//xpath для ответа на 3-й вопрос
    public static final String Order_Today_Text_Actual = ".//div[@id = 'accordion__panel-3']";//xpath для ответа на 4-й вопрос
    public static final String Extend_Or_Return_Earlier_Text_Actual = ".//div[@id = 'accordion__panel-4']";//xpath для ответа на 5-й вопрос
    public static final String Charging_With_Scooter_Text_Actual = ".//div[@id = 'accordion__panel-5']";//xpath для ответа на 6-й вопрос
    public static final String Cancel_The_Order_Text_Actual = ".//div[@id = 'accordion__panel-6']";//xpath для ответа на 7-й вопрос
    public static final String Outside_The_Moscow_Ring_Road_Text_Actual = ".//div[@id = 'accordion__panel-7']";//xpath для ответа на 8-й вопрос

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
        driver.get(Url_Site_Order_Scooter);
        WebElement everyoneIsUsedToTheButton = driver.findElement(Click_Everyone_Is_Used_To_TheButton);
        everyoneIsUsedToTheButton.click();
        WebElement listQuation = driver.findElement(Scroll_To_List_Of_Questions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", listQuation);
    }

    public void quitBrows(){
        driver.quit();
    }
}