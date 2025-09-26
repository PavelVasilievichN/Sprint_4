package ru.yandex.praktikum.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePagYandexScooter {
    private final WebDriver driver;
    /*=========================Элементы Выпадающего списка===================*/
    //кнопка раскрывающего списка 1
    private final By dropDownListButtonOne = By.id("accordion__heading-0");
    //кнопка раскрывающего списка 2
    private final By dropDownListButtonTwo = By.id("accordion__heading-1");
    //кнопка раскрывающего списка 3
    private final By dropDownListButtonThree = By.id("accordion__heading-2");
    //кнопка раскрывающего списка 4
    private final By dropDownListButtonFour = By.id("accordion__heading-3");
    //кнопка раскрывающего списка 5
    private final By dropDownListButtonFive = By.id("accordion__heading-4");
    //кнопка раскрывающего списка 6
    private final By dropDownListButtonSix = By.id("accordion__heading-5");
    //кнопка раскрывающего списка 7
    private final By dropDownListButtonSeven = By.id("accordion__heading-6");
    //кнопка раскрывающего списка 8
    private final By dropDownListButtonEight = By.id("accordion__heading-7");

    //текст появляющийся при нажатии кнопки раскрывающегося списка 1
    private final By openingTextButtonOne = By.xpath(".//*[@id='accordion__panel-0']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 2
    private final By openingTextButtonTwo = By.xpath(".//*[@id='accordion__panel-1']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 3
    private final By openingTextButtonThree = By.xpath(".//*[@id='accordion__panel-2']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 4
    private final By openingTextButtonFour = By.xpath(".//*[@id='accordion__panel-3']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 5
    private final By openingTextButtonFive = By.xpath(".//*[@id='accordion__panel-4']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 6
    private final By openingTextButtonSix = By.xpath(".//*[@id='accordion__panel-5']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 7
    private final By openingTextButtonSeven = By.xpath(".//*[@id='accordion__panel-6']/p");
    //текст появляющийся при нажатии кнопки раскрывающегося списка 8
    private final By openingTextButtonEight = By.xpath(".//*[@id='accordion__panel-7']/p");
    /*===============================================================================*/

    public HomePagYandexScooter(WebDriver driver){
        this.driver= driver;
    }

    public By getDropDownListButtonOne(){
        return dropDownListButtonOne;
    }

    //метод для перехода на сайт учебного сервиса Яндекс Самокат
    public void openHomePage(WebDriver driver){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Метод проскролить страницу
    public void scrollToTheElement(By elementLocator){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод проверки текста раскрывшемся элемента один выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextOne(String textOne){
        driver.findElement(dropDownListButtonOne).click();
        return textOne.equals(driver.findElement(openingTextButtonOne).getText());
    }
    //Метод проверки текста раскрывшемся элемента два выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextTwo(String textTwo){
        driver.findElement(dropDownListButtonTwo).click();
        return textTwo.equals(driver.findElement(openingTextButtonTwo).getText());
    }
    //Метод проверки текста раскрывшемся элемента три выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextThree(String textThree){
        driver.findElement(dropDownListButtonThree).click();
        return textThree.equals(driver.findElement(openingTextButtonThree).getText());
    }
    //Метод проверки текста раскрывшемся элемента четыре выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextFour(String textFour){
        driver.findElement(dropDownListButtonFour).click();
        return textFour.equals(driver.findElement(openingTextButtonFour).getText());
    }
    //Метод проверки текста раскрывшемся элемента пять выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextFive(String textFive){
        driver.findElement(dropDownListButtonFive).click();
        return textFive.equals(driver.findElement(openingTextButtonFive).getText());
    }
    //Метод проверки текста раскрывшемся элемента шесть выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextSix(String textSix){
        driver.findElement(dropDownListButtonSix).click();
        return textSix.equals(driver.findElement(openingTextButtonSix).getText());
    }
    //Метод проверки текста раскрывшемся элемента семь выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextSeven(String textSeven){
        driver.findElement(dropDownListButtonSeven).click();
        return textSeven.equals(driver.findElement(openingTextButtonSeven).getText());
    }
    //Метод проверки текста раскрывшемся элемента восемь выпадающего списка
    public boolean clickingDropDownListButtonOpensCorrespondingTextEight(String textEight){
        driver.findElement(dropDownListButtonEight).click();
        return textEight.equals(driver.findElement(openingTextButtonEight).getText());
    }
    public boolean checkDropDownList(String textOne, String textTwo, String textThree, String textFour,
                                     String textFive, String textSix, String textSeven, String textEight) {
        boolean isOne = clickingDropDownListButtonOpensCorrespondingTextOne(textOne);
        boolean isTwo = clickingDropDownListButtonOpensCorrespondingTextTwo(textTwo);
        boolean isThree = clickingDropDownListButtonOpensCorrespondingTextThree(textThree);
        boolean isFour = clickingDropDownListButtonOpensCorrespondingTextFour(textFour);
        boolean isFive = clickingDropDownListButtonOpensCorrespondingTextFive(textFive);
        boolean isSix = clickingDropDownListButtonOpensCorrespondingTextSix(textSix);
        boolean isSeven = clickingDropDownListButtonOpensCorrespondingTextSeven(textSeven);
        boolean isEight = clickingDropDownListButtonOpensCorrespondingTextEight(textEight);
        boolean[] listElements = {isOne, isTwo, isThree, isFour, isFive, isSix, isSeven, isEight};
        for (boolean element : listElements) {
            if (element) {
                return true;
            }
        }
        return false;
    }
}
