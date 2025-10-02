package ru.yandex.praktikum.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.praktikum.util.EvnConfig;
import static ru.yandex.praktikum.util.EvnConfig.*;

//класс Главная страница Яндекс самоката
public class HomePageYandexScooter {
    private final WebDriver driver;
    private final EvnConfig config = new EvnConfig();
    /*=========================Элементы Выпадающего списка===================*/
    //кнопка раскрывающего списка 1
    private final By dropDownListItemHowMuchCostAndHowPay = By.id("accordion__heading-0");
    //кнопка раскрывающего списка 2
    private final By dropDownListItemWantSeveralScootersAtOnce = By.id("accordion__heading-1");
    //кнопка раскрывающего списка 3
    private final By dropDownListItemHowCalculationTimeRental = By.id("accordion__heading-2");
    //кнопка раскрывающего списка 4
    private final By dropDownListItemPossibleOrderScooterToday = By.id("accordion__heading-3");
    //кнопка раскрывающего списка 5
    private final By dropDownListItemPossibleExtendOrderOrReturnScooterEarlier = By.id("accordion__heading-4");
    //кнопка раскрывающего списка 6
    private final By dropDownListItemChargerWithScooter = By.id("accordion__heading-5");
    //кнопка раскрывающего списка 7
    private final By dropDownListItemPossibleCancelAnOrder = By.id("accordion__heading-6");
    //кнопка раскрывающего списка 8
    private final By dropDownListItemLiveOutsideMoscowRingRoadCanYouBring = By.id("accordion__heading-7");

    //текст появляющийся при нажатии кнопки раскрывающегося списка 1
    private final By dropDownListItemTextHowMuchCostAndHowPay = By.xpath(".//div[@id='accordion__panel-0']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 2
    private final By dropDownListItemTextWantSeveralScootersAtOnce = By.xpath(".//*[@id='accordion__panel-1']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 3
    private final By dropDownListItemTextHowCalculationTimeRental = By.xpath(".//*[@id='accordion__panel-2']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 4
    private final By dropDownListItemTextPossibleOrderScooterToday = By.xpath(".//*[@id='accordion__panel-3']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 5
    private final By dropDownListItemTextPossibleExtendOrderOrReturnScooterEarlier = By.xpath(".//*[@id='accordion__panel-4']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 6
    private final By dropDownListItemTextChargerWithScooter = By.xpath(".//*[@id='accordion__panel-5']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 7
    private final By dropDownListItemTextPossibleCancelAnOrder  = By.xpath(".//*[@id='accordion__panel-6']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 8
    private final By dropDownListItemTextLiveOutsideMoscowRingRoadCanYouBring = By.xpath(".//*[@id='accordion__panel-7']/p");
    /*===============================================================================*/

    public By getDropDownListItemHowMuchCostAndHowPay(){
        return dropDownListItemHowMuchCostAndHowPay;
    }
    public HomePageYandexScooter(WebDriver driver){
        this.driver= driver;
    }

    //метод для перехода на сайт учебного сервиса Яндекс Самокат
    public void openHomePage(WebDriver driver){
        driver.get(BASE_URL);
    }

    //Метод скролить страницу
    public void scrollToTheElement(By elementLocator){
        config.waitVisibilityOfElementLocated(driver, elementLocator);
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor)driver).executeScript(SCROLL_ELEMENT, element);
    }

    //массив для вопросов
    private final By[] question = new By[]{dropDownListItemHowMuchCostAndHowPay, dropDownListItemWantSeveralScootersAtOnce, dropDownListItemHowCalculationTimeRental,
            dropDownListItemPossibleOrderScooterToday, dropDownListItemPossibleExtendOrderOrReturnScooterEarlier, dropDownListItemChargerWithScooter,
            dropDownListItemPossibleCancelAnOrder, dropDownListItemLiveOutsideMoscowRingRoadCanYouBring};
    //массив для ответов
    private final By[] answer = new By[]{dropDownListItemTextHowMuchCostAndHowPay, dropDownListItemTextWantSeveralScootersAtOnce, dropDownListItemTextHowCalculationTimeRental,
            dropDownListItemTextPossibleOrderScooterToday, dropDownListItemTextPossibleExtendOrderOrReturnScooterEarlier, dropDownListItemTextChargerWithScooter,
            dropDownListItemTextPossibleCancelAnOrder, dropDownListItemTextLiveOutsideMoscowRingRoadCanYouBring};

    //метод для проверки выпадающего списка
    public boolean checkDropDownListItemQuestionAndAnswer(int index, String textQuestion, String textAnswer)
    {
        boolean isQuestion = textQuestion.equals(driver.findElement(question[index]).getText());
        driver.findElement(question[index]).click();
        config.waitVisibilityOfElementLocated(driver, answer[index]);
        boolean isAnswer = textAnswer.equals(driver.findElement(answer[index]).getText());
        return isQuestion && isAnswer;
    }
}