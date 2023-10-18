package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OrderScooter {

    private static WebDriver driver;

    private static final By CLICK_EVERYONE_IS_USED_TO_THE_BUTTON = By.className("App_CookieButton__3cvqF");//кнопка ок с куками
    private static final String URL_SITE_ORDER_SCOOTER = "https://qa-scooter.praktikum-services.ru/";//адрес сайта по заказу самокатов
    public static final String SIGN_TOP_BUTTON_ORDER = ".//button[contains(@class, 'Button_Button__ra12g')]";//верхняя кнопка Заказать
    public static final String SIGN_BOTTOM_BUTTON = ".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM')]";//нижняя кнопка заказать
    public static final String NAME_FIELD = ".//input[contains(@placeholder, 'Имя')]";//поле *Имя
    private static final String SURNAME_FIELD = ".//input[contains(@placeholder,'* Фамилия')]";//поле *Фамилия
    private static final String ADDRESS_FIELD = ".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]";//поле *Адрес: куда привезти
    private static final String METRO_FIELD = "select-search__input";//поле *Станция метро
    private static final String PHONE_FIELD = ".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]";//поле *Телефон: на него позвонит курьер
    public static final String SIGN_FURTHER_BUTTON = ".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM')]";//кнопка далее
    private static final String DATE_FIELD = ".//input[contains(@placeholder, '* Когда привезти самокат')]";//поле *Когда привезти самокат
    public final static String SIGN_ON_DATE = ".//div[contains(@aria-label, 'Choose понедельник, 20-е ноября 2023 г.')]";// выбор даты
    public final static String SIGN_RENTAL_PERIOD = "Dropdown-placeholder";// поле *Срок аренды
    public final static String SIGN_CHOOSE_PERIOD = ".//div[contains(text(), 'трое суток')]";//выбор срока аренды
    public final static String SIGN_CHOOSE_COLOR = ".//label[contains(text(), 'чёрный жемчуг')]";// поле *Цвет самоката
    private final static String COMMENT_FIELD = ".//input[contains(@placeholder, 'Комментарий для курьера')]";// поле Комментарий для курьера
    public final static String SIGN_BOTTOM_BUTTON_ORDER = ".//div[3]/button[2]";//кнопка заказать (после ввода всех обязательных данных)
    public final static String SIGN_BUTTON_YES_CHECKOUT = ".//button[contains(text(), 'Да')]";//кнопка Да
    public final static String ORDER_IS_PROCESSED_EXPECTED = "Посмотреть статус";//ожидаемый результат по ВЕРХНЕЙ кнопке заказать
    public final static String ORDER_IS_PROCESSED_ACTUAL = ".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']";//фактический результат по ВЕРХНЕЙ КНОПКЕ

    public OrderScooter(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickTopButton(String clickTopButtonOrder){
        WebElement element = driver.findElement(By.xpath(clickTopButtonOrder));
        element.click();
        return element;
    }

    public WebElement setName(String userName) {
        WebElement element = driver.findElement(By.xpath(NAME_FIELD));
        element.sendKeys(userName);
        return element;
    }//ввод имени

    public WebElement setSurname(String userSurname) {
        WebElement element = driver.findElement(By.xpath(SURNAME_FIELD));
        element.sendKeys(userSurname);
        return element;
    }//ввод фамилии

    public WebElement setAddress(String userAddress) {
        WebElement element = driver.findElement(By.xpath(ADDRESS_FIELD));
        element.sendKeys(userAddress);
        return element;
    }//ввод адреса

    public void setMetro(String userMetro) {
        driver.findElement(By.className(METRO_FIELD)).sendKeys(userMetro);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        List<WebElement> metroLists = driver.findElements(By.xpath(String.format(metroOptionTemplate, userMetro)));
        metroLists.get(0).click();
    }//ввод метро

    public WebElement setPhone(String userPhone) {
        WebElement element = driver.findElement(By.xpath(PHONE_FIELD));
        element.sendKeys(userPhone);
        return element;
    }//ввод номера телефона

    public WebElement clickFurtherButton(String clickFurtherButtonOrder) {
        WebElement element = driver.findElement(By.xpath(clickFurtherButtonOrder));
        element.click();
        return element;
    }//клик на кнопку далее

    public WebElement setDate(String userDate) {
        WebElement element = driver.findElement(By.xpath(DATE_FIELD));
        element.sendKeys(userDate);
        return element;
    }//ввод даты

    public WebElement clickOnDate(String clickOnDateOrder) {
        WebElement element = driver.findElement(By.xpath(clickOnDateOrder));
        element.click();
        return element;
    }//выбор даты из календаря

    public WebElement clickRentalPeriod(String clickRentalPeriodOrder) {
        WebElement element = driver.findElement(By.className(clickRentalPeriodOrder));
        element.click();
        return element;
    }//клик на поле срока аренды

    public WebElement clickChoosePeriod(String clickChoosePeriodOrder) {
        WebElement element = driver.findElement(By.xpath(clickChoosePeriodOrder));
        element.click();
        return element;
    }//выбор срока аренды

    public WebElement clickChooseColor(String clickChooseColorOrder) {
        WebElement element = driver.findElement(By.xpath(clickChooseColorOrder));
        element.click();
        return element;
    }//выбор цвета

    public WebElement setComment(String userComment) {
        WebElement element = driver.findElement(By.xpath(COMMENT_FIELD));
        element.sendKeys(userComment);
        return element;
    }//ввод комментария

    public WebElement clickBottomButtonOrder(String clickBottomButton) {
        WebElement element = driver.findElement(By.xpath(clickBottomButton));
        element.click();
        return element;
    }//клик на заказать после заполнения всех обязательных полей

    public WebElement clickButtonYesCheckout(String clickButtonYesCheckoutOrder) {
        WebElement element = driver.findElement(By.xpath(clickButtonYesCheckoutOrder));
        element.click();
        return element;
    }//клик на да (уверен, что хочу заказать)

    public static String orderDataEntryForm(String orderDataEntryFormActual){
        String ActualResultOrderBottomButton = driver.findElement(By.xpath(orderDataEntryFormActual)).getText();
        return ActualResultOrderBottomButton;
    }

    public void startTest(){
        driver.manage().window().maximize();
        driver.get(URL_SITE_ORDER_SCOOTER);
        WebElement everyoneIsUsedToTheButton = driver.findElement(CLICK_EVERYONE_IS_USED_TO_THE_BUTTON);
        everyoneIsUsedToTheButton.click();
    }

    public void quitBrows(){
        driver.quit();
    }
}
