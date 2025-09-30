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

    //Метод проверки текста раскрывшемся элемента один выпадающего списка
    public boolean checkDropDownListItemHowMuchCostAndHowPay(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemHowMuchCostAndHowPay).getText());
        driver.findElement(dropDownListItemHowMuchCostAndHowPay).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextHowMuchCostAndHowPay);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextHowMuchCostAndHowPay).getText());
        return isQuestion == isAnswer;
    }
    //Метод проверки текста раскрывшемся элемента два выпадающего списка
    public boolean checkDropDownListItemWantSeveralScootersAtOnce(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemWantSeveralScootersAtOnce).getText());
        driver.findElement(dropDownListItemWantSeveralScootersAtOnce).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextWantSeveralScootersAtOnce);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextWantSeveralScootersAtOnce).getText());
        return isQuestion == isAnswer;
    }
    //Метод проверки текста раскрывшемся элемента три выпадающего списка
    public boolean checkDropDownListItemHowCalculationTimeRental(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemHowCalculationTimeRental).getText());
        driver.findElement(dropDownListItemHowCalculationTimeRental).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextHowCalculationTimeRental);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextHowCalculationTimeRental).getText());
        return isQuestion == isAnswer;
    }
    //Метод проверки текста раскрывшемся элемента четыре выпадающего списка
    public boolean checkDropDownListItemPossibleOrderScooterToday(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemPossibleOrderScooterToday).getText());
        driver.findElement(dropDownListItemPossibleOrderScooterToday).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextPossibleOrderScooterToday);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextPossibleOrderScooterToday).getText());
        return isQuestion == isAnswer;
    }
    //Метод проверки текста раскрывшемся элемента пять выпадающего списка
    public boolean checkDropDownListItemPossibleExtendOrderOrReturnScooterEarlier(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemPossibleExtendOrderOrReturnScooterEarlier).getText());
        driver.findElement(dropDownListItemPossibleExtendOrderOrReturnScooterEarlier).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextPossibleExtendOrderOrReturnScooterEarlier);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextPossibleExtendOrderOrReturnScooterEarlier).getText());
        return isQuestion == isAnswer;
    }
    //Метод проверки текста раскрывшемся элемента шесть выпадающего списка
    public boolean checkDropDownListItemChargerWithScooter(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemChargerWithScooter).getText());
        driver.findElement(dropDownListItemChargerWithScooter).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextChargerWithScooter);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextChargerWithScooter).getText());
        return isQuestion == isAnswer;
    }
    //Метод проверки текста раскрывшемся элемента семь выпадающего списка
    public boolean checkDropDownListItemPossibleCancelAnOrder(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemPossibleCancelAnOrder).getText());
        driver.findElement(dropDownListItemPossibleCancelAnOrder).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextPossibleCancelAnOrder);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextPossibleCancelAnOrder).getText());
        return isQuestion == isAnswer;
    }
    //Метод проверки текста раскрывшемся элемента восемь выпадающего списка
    public boolean checkDropDownListItemLiveOutsideMoscowRingRoadCanYouBring(String textQuestion, String textAnswer){
        boolean isQuestion = textQuestion.equals(driver.findElement(dropDownListItemLiveOutsideMoscowRingRoadCanYouBring).getText());
        driver.findElement(dropDownListItemLiveOutsideMoscowRingRoadCanYouBring).click();
        config.waitVisibilityOfElementLocated(driver, dropDownListItemTextLiveOutsideMoscowRingRoadCanYouBring);
        boolean isAnswer = textAnswer.equals(driver.findElement(dropDownListItemTextLiveOutsideMoscowRingRoadCanYouBring).getText());
        return isQuestion == isAnswer;
    }
}
