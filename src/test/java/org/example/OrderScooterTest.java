package org.example;

import main.OrderScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OrderScooterTest {

    private WebDriver driver;

    @Before
    public void startFirefox() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebElement everyoneIsUsedToTheButton = driver.findElement(By.className("App_CookieButton__3cvqF"));
        everyoneIsUsedToTheButton.click();
    }

    @Test
    public void positiveScenarioForOrderingScooterTopButton () {
        WebElement clickTopButtonOrder = driver.findElement(By.className("Button_Button__ra12g"));
        clickTopButtonOrder.click();
        OrderScooter objScooter = new OrderScooter(driver);
        objScooter.firstPageOfOrderingScooter("Иван", "Иванов", "Москва", "Тверская", "89111111111");
        objScooter.secondPageOfOrderingScooter("20.11.2023", "Отзовниться за час");
    }

    @Test
    public void positiveScenarioForOrderingScooterBottomButton () {
        WebElement clickBottomButton = driver.findElement(By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM')]"));
        clickBottomButton.click();
        OrderScooter objScooter = new OrderScooter(driver);
        objScooter.firstPageOfOrderingScooter("Пётр", "Петров", "Москва, Красная площадь", "Технопарк", "89222222222");
        objScooter.secondPageOfOrderingScooter("21.11.2023", "Отзовниться за три часа до доставки");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
