package ru.yandex.praktikum.orderscooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.util.EvnConfig;

//Класс формы заказа самоката
public class ScooterOrderForm {
    private final WebDriver driver;
    private final EvnConfig config = new EvnConfig();

    //кнопка "Заказать" самоката в шапке страницы(header)
    private final By orderButtonInHeader = By.className("Button_Button__ra12g");
    //кнопка "Заказать" самоката в подвале страницы(Footer)
    private final By orderButtonInFooter = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //поле Имя
    private final By nameField = By.xpath(".//input[@type='text' and @placeholder='* Имя']");
    //поле Фамилия
    private final By lastNameField = By.xpath(".//input[@type='text' and @placeholder='* Фамилия']");
    //поле Адрес заказчика
    private final By addressCustomersField = By.xpath(".//input[@type='text' and @placeholder='* Адрес: куда привезти заказ']");
    //поле Станция метро
    private final By metroStationField = By.xpath(".//div[@class='select-search__select']");
    //поле для выбора станции метро
    private final By choosingMetroStation = By.xpath(".//div[@class='select-search__value']/input");
    //поле телефон
    private final By telephoneNumberField = By.xpath(".//input[@type='text' and @placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее(переход на следующею форму)
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    //поле когда привезти самокат
    private final By deliveryDateField = By.xpath(".//div[@class='react-datepicker-wrapper']//input");
    //поле срок аренды самоката
    private final By rentalPeriodField = By.xpath(".//div[@class='Dropdown-root']//span");
    //раскрывающийся список с элементом под индексом 1
    private final By elementTwentyFourHours = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[1]");
    //раскрывающийся список с элементом под индексом 2
    private final By elementFortyEightHours = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[2]");
    //раскрывающийся список с элементом под индексом 3
    private final By elementSeventyTwoHours = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[3]");
    //раскрывающийся список с элементом под индексом 4
    private final By elementNinetySixHours = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[4]");
    //включение чекбокса Черный жемчуг поля цвет самоката
    private final By blackPearlCheckbox = By.xpath(".//label/input[@id='black']");
    //включение чекбокса Серая безысходность поля цвет самоката
    private final By grayHopelessnessCheckbox = By.xpath(".//label/input[@id='grey']");
    //поле комментарий для курьера
    private final By  commentForTheCourierField = By.xpath(".//div/input[@placeholder='Комментарий для курьера']");
    //кнопка Заказать в форме про аренду
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");
    //кнопка Хотите оформить заказ Да
    private final By buttonYes = By.xpath(".//button[2 and text()='Да']");
    //локатор всплывающее окно Заказ оформлен
    private final By popUpWindow = By.xpath(".//div[@class='Order_Modal__YZ-d3']");

    public ScooterOrderForm(WebDriver driver) {
        this.driver = driver;
    }

    public By getOrderButtonInFooter() { return orderButtonInFooter; }

    //метод для кнопки "Заказать" в Header
    public void clickOrderButtonInHeader(){
        config.waitElementToBeClickable(driver, orderButtonInHeader);
        driver.findElement(orderButtonInHeader).click();
    }

    //метод для кнопки "Заказать" в Footer
    public void clickOrderButtonInFooter(){
        config.waitElementToBeClickable(driver, orderButtonInFooter);
        driver.findElement(orderButtonInFooter).click();
    }

    //метод заполнения поля Имя
    public void setName(String firstName){
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(firstName);
    }
    //метод заполнения поля Фамилия
    public void setLastName(String lastName){
        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    //метод заполнения поля Адрес заказчика
    public void setAddressCustomers(String addressCustomers){
        driver.findElement(addressCustomersField).clear();
        driver.findElement(addressCustomersField).sendKeys(addressCustomers);
    }
    //метод заполнения поля Станция метр
    public void setMetroStation(String stationName){
        driver.findElement(choosingMetroStation).click();
        driver.findElement(choosingMetroStation).sendKeys(stationName);
        config.waitVisibilityOfElementLocated(driver, metroStationField);
        driver.findElement(metroStationField).click();
    }
    //метод заполнения поля номер телефона заказчика
    public void setTelephoneNumber(String telephoneNumber){
        driver.findElement(telephoneNumberField).clear();
        driver.findElement(telephoneNumberField).sendKeys(telephoneNumber);
    }
    //метод нажатия на кнопку Далее(переход на следующею форму)
    public void clickOnTheNextButton(){
        config.waitElementToBeClickable(driver, nextButton);
        driver.findElement(nextButton).click();
    }
    //метод для заполнения поля когда привезти самокат(дата)
    public void setDeliveryDate(String deliveryDate){
        driver.findElement(deliveryDateField).clear();
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }
    //метод для заполнения поля срок аренды самоката
    public void setRentalPeriod(String rentalPeriod){
        driver.findElement(rentalPeriodField).click();
        switch (rentalPeriod) {
            case "сутки":
                driver.findElement(elementTwentyFourHours).click();
                break;
            case "двое суток":
                driver.findElement(elementFortyEightHours).click();
                break;
            case "трое суток":
                driver.findElement(elementSeventyTwoHours).click();
                break;
            case "четверо суток":
                driver.findElement(elementNinetySixHours).click();
                break;
        }
    }
    //метод для включения чекбокса в поле цвет самоката
    public void setScooterColor(String checkboxColor){
        if(checkboxColor.equals("Чёрный жемчуг")){
            driver.findElement(blackPearlCheckbox).click();
        }
        else{
            driver.findElement(grayHopelessnessCheckbox).click();
        }
    }
    //метод для заполнения поля комментарий для курьера
    public void setCommentForTheCourier(String comment){
        driver.findElement(commentForTheCourierField).clear();
        driver.findElement(commentForTheCourierField).sendKeys(comment);
    }
    //метод для нажатия кнопки "Заказать" самокат
    public void clickOnTheOrderButton(){
        config.waitElementToBeClickable(driver, orderButton);
        driver.findElement(orderButton).click();
    }

    //метод для кнопки Да(оформления заказа)
    public void clickButtonYes(){
        config.waitElementToBeClickable(driver, buttonYes);
        driver.findElement(buttonYes).click();
    }

    //исправлено с public String getTextOrderConfirmation()
    public String getModalWindowText(){
        config.waitVisibilityOfElementLocated(driver, popUpWindow);
        return driver.findElement(popUpWindow).getText();
    }

    //метод для заполнения формы заказа самоката
    public void setOutTheScooterOrderForm(String firstName, String lastName, String addressCustomers,
                                          String stationName, String telephoneNumber, String deliveryDate,
                                          String rentalPeriod, String checkboxColor, String comment){
        setName(firstName);
        setLastName(lastName);
        setAddressCustomers(addressCustomers);
        setMetroStation(stationName);
        setTelephoneNumber(telephoneNumber);
        clickOnTheNextButton();
        setDeliveryDate(deliveryDate);
        setRentalPeriod(rentalPeriod);
        setScooterColor(checkboxColor);
        setCommentForTheCourier(comment);
        clickOnTheOrderButton();
        clickButtonYes();
    }
}