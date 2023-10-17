package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderScooter {

    private WebDriver driver;

    public static final By Click_Everyone_Is_Used_To_The_Button = By.className("App_CookieButton__3cvqF");//кнопка ок с куками
    public static final String Url_Site_Order_Scooter = "https://qa-scooter.praktikum-services.ru/";//адрес сайта по заказу самокатов
    public static final By Sign_Top_Button_Order = By.className("Button_Button__ra12g");//верхняя кнопка Заказать
    public static final By Sign_Bottom_Button = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_UltraBig__UU3Lp')]");//нижняя кнопка заказать
    private static final By nameField = By.xpath(".//input[contains(@placeholder, 'Имя')]");//поле *Имя
    private static final By surnameField = By.xpath(".//input[contains(@placeholder,'* Фамилия')]");//поле *Фамилия
    private static final By addressField = By.xpath(".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]");//поле *Адрес: куда привезти
    private static final By metroField = By.className("select-search__input");//поле *Станция метро
    private static final By phoneField = By.xpath(".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");//поле *Телефон: на него позвонит курьер
    private static final By signFurtherButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM')]");//кнопка далее
    private static final By dateField = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");//поле *Когда привезти самокат
    private final static By signOnDate = By.xpath(".//div[contains(@aria-label, 'Choose понедельник, 20-е ноября 2023 г.')]");// выбор даты
    private final static By signRentalPeriod = By.className("Dropdown-placeholder");// поле *Срок аренды
    private final static By signChoosePeriod = By.xpath(".//div[contains(text(), 'трое суток')]");//выбор срока аренды
    private final static By signChooseColor = By.xpath(".//label[contains(text(), 'чёрный жемчуг')]");// поле *Цвет самоката
    private final static By commentField = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");// поле Комментарий для курьера
    private final static By signBottomButtonOrder = By.xpath(".//div[3]/button[2]");//кнопка заказать (после ввода всех обязательных данных)
    private final static By signButtonYesCheckout = By.xpath(".//button[contains(text(), 'Да')]");//кнопка Да
    public final static String orderIsProcessedExpected = "Посмотреть статус";//ожидаемый результат по ВЕРХНЕЙ кнопке заказать
    public final static String orderDataEntryFormExpected = "Для кого самокат";//ожидаемый результат по НИЖНЕЙ кнопке заказать
    private final static By orderIsProcessedActual = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");//фактический результат по ВЕРХНЕЙ КНОПКЕ
    private final static By orderDataEntryFormActual = By.className("Order_Header__BZXOb");

    public OrderScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void setName(String userName) {
        driver.findElement(nameField).sendKeys(userName);
    }//ввод имени

    public void setSurname(String userSurname) {

        driver.findElement(surnameField).sendKeys(userSurname);
    }//ввод фамилии

    public void setAddress(String userAddress) {

        driver.findElement(addressField).sendKeys(userAddress);
    }//ввод адреса

    public void setMetro(String userMetro) {
        driver.findElement(metroField).sendKeys(userMetro);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        List<WebElement> metroLists = driver.findElements(By.xpath(String.format(metroOptionTemplate, userMetro)));
        metroLists.get(0).click();
    }//ввод метро

    public void setPhone(String userPhone) {
        driver.findElement(phoneField).sendKeys(userPhone);
    }//ввод номера телефона

    public void clickFurtherButton() {
        driver.findElement(signFurtherButton).click();
    }//клик на кнопку далее

    public void setDate(String userDate) {
        driver.findElement(dateField).sendKeys(userDate);
    }//ввод даты

    public void clickOnDate() {
        driver.findElement(signOnDate).click();
    }//выбор даты из календаря

    public void clickRentalPeriod() {
        driver.findElement(signRentalPeriod).click();
    }//клик на поле срока аренды

    public void clickChoosePeriod() {
        driver.findElement(signChoosePeriod).click();
    }//выбор срока аренды

    public void clickChooseColor() {
        driver.findElement(signChooseColor).click();
    }//выбор цвета

    public void setComment(String userComment) {
        driver.findElement(commentField).sendKeys(userComment);
    }//ввод комментария

    public void clickBottomButtonOrder() {
        driver.findElement(signBottomButtonOrder).click();
    }//клик на заказать после заполнения всех обязательных полей

    public void clickButtonYesCheckout() {
        driver.findElement(signButtonYesCheckout).click();
    }//клик на да (уверен, что хочу заказать)

    public void orderIsProcessed(String orderIsProcessedExpected) {

        String compareExpectedAndActualResultOrder = driver.findElement(orderIsProcessedActual).getText();
        assertThat(orderIsProcessedExpected, is(compareExpectedAndActualResultOrder));
    }//сравнение ожидаемого и фактического результатов для ВЕРХНЕЙ кнопке

    public void orderDataEntryForm (String orderDataEntryFormExpected){
        String compareExpectedAndActualResultOrderBottomButton = driver.findElement(orderDataEntryFormActual).getText();
        assertThat(orderDataEntryFormExpected, is(compareExpectedAndActualResultOrderBottomButton));
    }

    public void startTest(){
        driver.manage().window().maximize();
        driver.get(Url_Site_Order_Scooter);
        WebElement everyoneIsUsedToTheButton = driver.findElement(Click_Everyone_Is_Used_To_The_Button);
        everyoneIsUsedToTheButton.click();
    }

    public void quitBrows(){
        driver.quit();
    }




}
