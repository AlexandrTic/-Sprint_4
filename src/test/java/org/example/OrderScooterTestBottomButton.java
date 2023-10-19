package org.example;

import main.OrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class OrderScooterTestBottomButton {

    private static WebDriver driver;

    @Before
    public void startFirefox() {
        driver = new FirefoxDriver();
        OrderScooter orderScooter = new OrderScooter(driver);
        orderScooter.startTest();
    }

    @Test
    public void positiveScenarioForOrderingScooterBottomButton () {
        OrderScooter orderScooter = new OrderScooter(driver);
        WebElement clickBottomButton = driver.findElement(By.xpath(orderScooter.SIGN_BOTTOM_BUTTON));
        clickBottomButton.click();
        assertEquals(OrderScooter.ORDER_DATA_ENTRY_FORM_EXPECTED, orderScooter.orderDataEntryFormBottomButton(orderScooter.ORDER_DATA_ENTRY_FORM_ACTUAL));


    }

    @After
    public void tearDown() {
        OrderScooter orderScooter = new OrderScooter(driver);
        orderScooter.quitBrows();
    }
}
