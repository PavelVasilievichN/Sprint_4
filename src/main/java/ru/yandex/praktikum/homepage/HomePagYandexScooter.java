package ru.yandex.praktikum.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
