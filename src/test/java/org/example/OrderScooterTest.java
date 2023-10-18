package org.example;

import main.OrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static main.OrderScooter.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class OrderScooterTest {

    private static WebDriver driver;

    private final String clickTopButtonOrder;
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String userMetro;
    private final String userPhone;
    private final String clickFurtherButtonOrder;
    private final String userDate;
    private final String clickOnDateOrder;
    private final String clickRentalPeriodOrder;
    private final String clickChoosePeriodOrder;
    private final String clickChooseColorOrder;
    private final String userComment;
    private final String clickBottomButton;
    private final String clickButtonYesCheckoutOrder;
    private final String orderDataEntryFormActual;
    private final String expectedText;

    public OrderScooterTest(String clickTopButtonOrder, String userName, String userSurname, String userAddress, String userMetro, String userPhone, String clickFurtherButtonOrder,
                            String userDate, String clickOnDateOrder, String clickRentalPeriodOrder, String clickChoosePeriodOrder,
                            String clickChooseColorOrder, String userComment, String clickBottomButton, String clickButtonYesCheckoutOrder, String orderDataEntryFormActual, String expectedText){

        this.clickTopButtonOrder = clickTopButtonOrder;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.userMetro = userMetro;
        this.userPhone = userPhone;
        this.clickFurtherButtonOrder = clickFurtherButtonOrder;
        this.userDate = userDate;
        this.clickOnDateOrder = clickOnDateOrder;
        this.clickRentalPeriodOrder = clickRentalPeriodOrder;
        this.clickChoosePeriodOrder = clickChoosePeriodOrder;
        this.clickChooseColorOrder = clickChooseColorOrder;
        this.userComment = userComment;
        this.clickBottomButton = clickBottomButton;
        this.clickButtonYesCheckoutOrder = clickButtonYesCheckoutOrder;
        this.orderDataEntryFormActual = orderDataEntryFormActual;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] testData(){
        return new Object[][]{
                {SIGN_TOP_BUTTON_ORDER, "Иван", "Иванов", "Москва", "Тверская", "89111111111", SIGN_FURTHER_BUTTON, "20.11.2023",
                        SIGN_ON_DATE, SIGN_RENTAL_PERIOD, SIGN_CHOOSE_PERIOD, SIGN_CHOOSE_COLOR, "Отзовниться за час",
                        SIGN_BOTTOM_BUTTON_ORDER, SIGN_BUTTON_YES_CHECKOUT, ORDER_IS_PROCESSED_ACTUAL, ORDER_IS_PROCESSED_EXPECTED},
                {SIGN_TOP_BUTTON_ORDER, "Пётр", "Петров", "Москва, Красная площадь", "Технопарк", "89222222222", SIGN_FURTHER_BUTTON, "21.11.2023",
                        SIGN_ON_DATE, SIGN_RENTAL_PERIOD, SIGN_CHOOSE_PERIOD, SIGN_CHOOSE_COLOR, "Отзовниться за три часа до доставки",
                        SIGN_BOTTOM_BUTTON_ORDER, SIGN_BUTTON_YES_CHECKOUT, ORDER_IS_PROCESSED_ACTUAL, ORDER_IS_PROCESSED_EXPECTED},
                {SIGN_BOTTOM_BUTTON, "Курт", "Кобейн", "Санкт-Петербург", "Маяковская", "89322222222", SIGN_FURTHER_BUTTON, "22.11.2023",
                        SIGN_ON_DATE, SIGN_RENTAL_PERIOD, SIGN_CHOOSE_PERIOD, SIGN_CHOOSE_COLOR, "Пароль: Smells Like Teen Spirit",
                        SIGN_BOTTOM_BUTTON_ORDER, SIGN_BUTTON_YES_CHECKOUT, ORDER_IS_PROCESSED_ACTUAL, ORDER_IS_PROCESSED_EXPECTED},
        };
    }

    @Before
    public void startFirefox() {
        driver = new FirefoxDriver();
        OrderScooter orderScooter = new OrderScooter(driver);
        orderScooter.startTest();
    }

    @Test
    public void firstPositiveScenarioForOrderingScooterTopButton () {
        OrderScooter orderScooter = new OrderScooter(driver);
        orderScooter.clickTopButton(clickTopButtonOrder);
        orderScooter.setName(userName);
        orderScooter.setSurname(userSurname);
        orderScooter.setAddress(userAddress);
        orderScooter.setMetro(userMetro);
        orderScooter.setPhone(userPhone);
        orderScooter.clickFurtherButton(clickFurtherButtonOrder);
        orderScooter.setDate(userDate);
        orderScooter.clickOnDate(clickOnDateOrder);
        orderScooter.clickRentalPeriod(clickRentalPeriodOrder);
        orderScooter.clickChoosePeriod(clickChoosePeriodOrder);
        orderScooter.clickChooseColor(clickChooseColorOrder);
        orderScooter.setComment(userComment);
        orderScooter.clickBottomButtonOrder(clickBottomButton);
        orderScooter.clickButtonYesCheckout(clickButtonYesCheckoutOrder);
        String actualText = OrderScooter.orderDataEntryForm(orderDataEntryFormActual);
        assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        OrderScooter orderScooter = new OrderScooter(driver);
        orderScooter.quitBrows();
    }

}
