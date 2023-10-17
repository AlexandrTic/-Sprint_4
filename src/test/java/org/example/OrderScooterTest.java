package org.example;

import main.OrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderScooterTest {

    private static WebDriver driver;



    @Before
    public void startFirefox() {
        driver = new FirefoxDriver();
        OrderScooter orderScooter = new OrderScooter(driver);
        orderScooter.startTest();
    }

    @Test
    public void firstPositiveScenarioForOrderingScooterTopButton () {
        OrderScooter orderScooter = new OrderScooter(driver);
        WebElement clickTopButtonOrder = driver.findElement(OrderScooter.Sign_Top_Button_Order);
        clickTopButtonOrder.click();

        orderScooter.setName("Иван");
        orderScooter.setSurname("Иванов");
        orderScooter.setAddress("Москва");
        orderScooter.setMetro("Тверская");
        orderScooter.setPhone("89111111111");
        orderScooter.clickFurtherButton();

        orderScooter.setDate("20.11.2023");
        orderScooter.clickOnDate();
        orderScooter.clickRentalPeriod();
        orderScooter.clickChoosePeriod();
        orderScooter.clickChooseColor();
        orderScooter.setComment("Отзовниться за час");
        orderScooter.clickBottomButtonOrder();
        orderScooter.clickButtonYesCheckout();
        orderScooter.orderIsProcessed(OrderScooter.orderIsProcessedExpected);
    }

    @Test
    public void secondPositiveScenarioForOrderingScooterTopButton () {
        OrderScooter orderScooter = new OrderScooter(driver);
        WebElement clickTopButtonOrder = driver.findElement(OrderScooter.Sign_Top_Button_Order);
        clickTopButtonOrder.click();

        orderScooter.setName("Пётр");
        orderScooter.setSurname("Петров");
        orderScooter.setAddress("Москва, Красная площадь");
        orderScooter.setMetro("Технопарк");
        orderScooter.setPhone("89222222222");
        orderScooter.clickFurtherButton();

        orderScooter.setDate("21.11.2023");
        orderScooter.clickOnDate();
        orderScooter.clickRentalPeriod();
        orderScooter.clickChoosePeriod();
        orderScooter.clickChooseColor();
        orderScooter.setComment("Отзовниться за три часа до доставки");
        orderScooter.clickBottomButtonOrder();
        orderScooter.clickButtonYesCheckout();
        orderScooter.orderIsProcessed(OrderScooter.orderIsProcessedExpected);
    }

    @Test
    public void positiveScenarioForOrderingScooterBottomButton () {
        OrderScooter orderScooter = new OrderScooter(driver);
        WebElement clickBottomButton = driver.findElement(OrderScooter.Sign_Bottom_Button);
        clickBottomButton.click();

        orderScooter.orderDataEntryForm(orderScooter.orderDataEntryFormExpected);

    }

    @After
    public void tearDown() {
        OrderScooter orderScooter = new OrderScooter(driver);
        orderScooter.quitBrows();
    }

}
