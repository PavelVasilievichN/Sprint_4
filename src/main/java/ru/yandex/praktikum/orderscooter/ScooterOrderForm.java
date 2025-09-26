package ru.yandex.praktikum.orderscooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScooterOrderForm {
    private final WebDriver driver;

    //кнопка "Заказать" самоката в шапке страницы(header)
    private final By orderButtonInHeader = By.className("Button_Button__ra12g");
    public final String buttonInHeader = "header";

    //кнопка "Заказать" самоката в подвале страницы(Footer)
    private final By orderButtonInFooter = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    public final String buttonInFooter = "footer";

    //поле Имя
    private final By fieldName = By.xpath(".//input[@type='text' and @placeholder='* Имя']");
    //поле Фамилия
    private final By fieldLastName = By.xpath(".//input[@type='text' and @placeholder='* Фамилия']");
    //поле Адрес заказчика
    private final By fieldAddressCustomers = By.xpath(".//input[@type='text' and @placeholder='* Адрес: куда привезти заказ']");

    //поле Станция метро
    private final By fieldMetroStation = By.xpath(".//div[@class='select-search__select']");
    //поле для выбора станции метро
    private final By choosingMetroStation = By.xpath(".//div[@class='select-search__value']/input");
    //поле телефон
    private final By fieldTelephoneNumber = By.xpath(".//input[@type='text' and @placeholder='* Телефон: на него позвонит курьер']");
    //кнопка Далее(переход на следующею форму)
    private final By nextButton = By.xpath(".//button[text()='Далее']");

    //поле когда привезти самокат
    private final By deliveryDateField = By.xpath(".//div[@class='react-datepicker-wrapper']//input");

    //поле срок аренды самоката
    private final By fieldRentalPeriod = By.xpath(".//div[@class='Dropdown-root']//span");
    //раскрывающийся список с элементом под индексом 1
    private final By elementUnderIndexOne = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[1]");
    //раскрывающийся список с элементом под индексом 2
    private final By elementUnderIndexTwo = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[2]");
    //раскрывающийся список с элементом под индексом 3
    private final By elementUnderIndexThree = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[3]");
    //раскрывающийся список с элементом под индексом 4
    private final By elementUnderIndexFour = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[4]");
    //раскрывающийся список с элементом под индексом 5
    private final By elementUnderIndexFive = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[5]");
    //раскрывающийся список с элементом под индексом 6
    private final By elementUnderIndexSix = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[6]");
    //раскрывающийся список с элементом под индексом 7
    private final By elementUnderIndexSeven = By.xpath(".//div[@class='Dropdown-menu' and @aria-expanded]/div[7]");

    //поле цвет самоката
    //включение чекбокса Черный жемчуг поля цвет самоката
    private final By blackPearlCheckbox = By.xpath(".//label/input[@id='black']");
    //включение чекбокса Серая безысходность поля цвет самоката
    private final By grayHopelessnessCheckbox = By.xpath(".//label/input[@id='grey']");
    //поле комментарий для курьера
    private final By  fieldCommentForTheCourier = By.xpath(".//div/input[@placeholder='Комментарий для курьера']");

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

    //метод для переключения между кнопками "Заказать" на главной странице
    public void clickOrderButtonInHeaderOrFooter(String choiceButtonOrder){
        switch(choiceButtonOrder){
            case "header":
                new WebDriverWait(driver, 5)
                        .until(ExpectedConditions.elementToBeClickable(orderButtonInHeader));
                driver.findElement(orderButtonInHeader).click();
                break;

            case "footer":
                new WebDriverWait(driver, 5)
                        .until(ExpectedConditions.elementToBeClickable(orderButtonInFooter));
                driver.findElement(orderButtonInFooter).click();
                break;
        }
    }
    //метод заполнения поля Имя
    public void fillingFieldName(String firstName){
        driver.findElement(fieldName).clear();
        driver.findElement(fieldName).sendKeys(firstName);
    }
    //метод заполнения поля Фамилия
    public void fillingFieldLastName(String lastName){
        driver.findElement(fieldLastName).clear();
        driver.findElement(fieldLastName).sendKeys(lastName);
    }
    //метод заполнения поля Адрес заказчика
    public void fillingInTheCustomerAddressField(String addressCustomers){
        driver.findElement(fieldAddressCustomers).clear();
        driver.findElement(fieldAddressCustomers).sendKeys(addressCustomers);
    }
    //метод заполнения поля Станция метр
    public void fillingInTheMetroStationField(String stationName){
        driver.findElement(choosingMetroStation).click();
        driver.findElement(choosingMetroStation).sendKeys(stationName);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(fieldMetroStation));
        driver.findElement(fieldMetroStation).click();

    }
    //метод заполнения поля номер телефона заказчика
    public void fillingFieldTelephoneNumber(String telephoneNumber){
        driver.findElement(fieldTelephoneNumber).clear();
        driver.findElement(fieldTelephoneNumber).sendKeys(telephoneNumber);
    }
    //метод нажатия на кнопку Далее(переход на следующею форму)
    public void clickOnTheNextButton(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }
    //метод для заполнения поля когда привезти самокат(дата)
    public void FillingInTheScooterOrderDateField(String deliveryDate){
        driver.findElement(deliveryDateField).clear();
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }
    //метод для заполнения поля срок аренды самоката
    public void FillingInTheScooterRentalPeriodField(String rentalPeriod){
        driver.findElement(fieldRentalPeriod).click();
        //выбор элемента раскрывающегося списка под номером один
        switch (rentalPeriod) {
            case "сутки":
                driver.findElement(elementUnderIndexOne).click();
                break;
            case "двое суток":
                driver.findElement(elementUnderIndexTwo).click();
                break;
            case "трое суток":
                driver.findElement(elementUnderIndexThree).click();
                break;
            case "четверо суток":
                driver.findElement(elementUnderIndexFour).click();
                break;
            case "пятеро суток":
                driver.findElement(elementUnderIndexFive).click();
                break;
            case "шестеро суток":
                driver.findElement(elementUnderIndexSix).click();
                break;
            case "семеро суток":
                driver.findElement(elementUnderIndexSeven).click();
                break;
        }

    }
    //метод для включения чекбокса в поле цвет самоката
    public void choosingScooterColor(String checkboxColor){
        if(checkboxColor.equals("Чёрный жемчуг")){
            driver.findElement(blackPearlCheckbox).click();
        }
        else{
            driver.findElement(grayHopelessnessCheckbox).click();
        }
    }
    //метод для заполнения поля комментарий для курьера
    public void FillingOutTheCommentFieldForTheCourier(String comment){
        driver.findElement(fieldCommentForTheCourier).clear();
        driver.findElement(fieldCommentForTheCourier).sendKeys(comment);
    }
    //метод для нажатия кнопки "Заказать" самокат
    public void clickOnTheOrderButton(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderButton).click();
    }

    //метод для кнопки Да(оформления заказа)
    public void selectButtonYes(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(buttonYes));
        driver.findElement(buttonYes).click();
    }

    public String getTextOrderConfirmation(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(popUpWindow));
        return driver.findElement(popUpWindow).getText();
    }

    //метод для заполнения формы заказа самоката
    public void fillingOutTheScooterOrderForm(String firstName, String lastName, String addressCustomers,
                                              String stationName, String telephoneNumber, String deliveryDate,
                                              String rentalPeriod, String checkboxColor, String comment){
        fillingFieldName(firstName);
        fillingFieldLastName(lastName);
        fillingInTheCustomerAddressField(addressCustomers);
        fillingInTheMetroStationField(stationName);
        fillingFieldTelephoneNumber(telephoneNumber);
        clickOnTheNextButton();
        FillingInTheScooterOrderDateField(deliveryDate);
        FillingInTheScooterRentalPeriodField(rentalPeriod);
        choosingScooterColor(checkboxColor);
        FillingOutTheCommentFieldForTheCourier(comment);
        clickOnTheOrderButton();
    }
}
