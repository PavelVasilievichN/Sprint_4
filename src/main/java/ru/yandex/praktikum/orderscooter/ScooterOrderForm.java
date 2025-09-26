package ru.yandex.praktikum.orderscooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
