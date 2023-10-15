package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderScooter {

    private WebDriver driver;

    private By signTopButtonOrder = By.className("Button_Button__ra12g");//верхняя кнопка Заказать
    private By nameField =  By.xpath(".//input[contains(@placeholder, 'Имя')]");//поле *Имя
    private By surnameField = By.xpath(".//input[contains(@placeholder,'* Фамилия')]");//поле *Фамилия
    private By addressField = By.xpath(".//input[contains(@placeholder, '* Адрес: куда привезти заказ')]");//поле *Адрес: куда привезти
    private By metroField = By.className("select-search__input");//поле *Станция метро
    private By phoneField = By.xpath(".//input[contains(@placeholder, '* Телефон: на него позвонит курьер')]");//поле *Телефон: на него позвонит курьер
    private By signFurtherButton = By.xpath(".//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM')]");//кнопка далее
    private By dateField = By.xpath(".//input[contains(@placeholder, '* Когда привезти самокат')]");//поле *Когда привезти самокат
    private By signOnDate = By.xpath(".//div[contains(@aria-label, 'Choose понедельник, 20-е ноября 2023 г.')]");// выбор даты
    private By signRentalPeriod = By.className("Dropdown-placeholder");// поле *Срок аренды
    private By signChoosePeriod = By.xpath(".//div[contains(text(), 'трое суток')]");//выбор срока аренды
    private By signChooseColor = By.xpath(".//label[contains(text(), 'чёрный жемчуг')]");// поле *Цвет самоката
    private By commentField = By.xpath(".//input[contains(@placeholder, 'Комментарий для курьера')]");// поле Комментарий для курьера
    private By signBottomButtonOrder = By.xpath(".//div[3]/button[2]");//кнопка заказать (после ввода всех обязательных данных)
    private By signButtonYesCheckout = By.xpath(".//button[contains(text(), 'Да')]");//кнопка Да
    private String orderIsProcessedExpected = "Посмотреть статус";//ожидаемый результат
    private By orderIsProcessedActual = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");//фактический результат

    public OrderScooter (WebDriver driver){
        this.driver = driver;
    }



    public void setName(String userName){
        driver.findElement(nameField).sendKeys(userName);
    }

    public void setSurname(String userSurname){
        driver.findElement(surnameField).sendKeys(userSurname);
    }

    public void setAddress(String userAddress){
        driver.findElement(addressField).sendKeys(userAddress);
    }

    public void setMetro(String userMetro){
        driver.findElement(metroField).sendKeys(userMetro);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        List<WebElement> metroLists = driver.findElements(By.xpath(String.format(metroOptionTemplate, userMetro)));
        metroLists.get(0).click();
    }

    public void setPhone(String userPhone){
        driver.findElement(phoneField).sendKeys(userPhone);
    }

    public void clickFurtherButton(){
        driver.findElement(signFurtherButton).click();
    }

    public void firstPageOfOrderingScooter(String username, String userSurname, String userAddress, String userMetro, String userPhone){

        setName(username);
        setSurname(userSurname);
        setAddress(userAddress);
        setMetro(userMetro);
        setPhone(userPhone);
        clickFurtherButton();
    }

    public void setDate(String userDate){
        driver.findElement(dateField).sendKeys(userDate);

    }

    public void clickOnDate(){
        driver.findElement(signOnDate).click();
    }

    public void clickRentalPeriod(){
        driver.findElement(signRentalPeriod).click();
    }

    public void clickChoosePeriod(){
        driver.findElement(signChoosePeriod).click();
    }

    public void clickChooseColor(){
        driver.findElement(signChooseColor).click();
    }

    public void setComment(String userComment){
        driver.findElement(commentField).sendKeys(userComment);
    }

    public void clickBottomButtonOrder(){
        driver.findElement(signBottomButtonOrder).click();
    }

    public void clickButtonYesCheckout(){
        driver.findElement(signButtonYesCheckout).click();
    }

    public void orderIsProcessed(String orderIsProcessedExpected ){
        this.orderIsProcessedExpected = orderIsProcessedExpected;
        String orderIsProcessedActual2 = driver.findElement(orderIsProcessedActual).getText();
        assertThat(orderIsProcessedExpected, is(orderIsProcessedActual2));
    }

    public void secondPageOfOrderingScooter(String userDate, String userComment){
        setDate(userDate);
        clickOnDate();
        clickRentalPeriod();
        clickChoosePeriod();
        clickChooseColor();
        setComment(userComment);
        clickBottomButtonOrder();
        clickButtonYesCheckout();
        orderIsProcessed(orderIsProcessedExpected);
    }
}
