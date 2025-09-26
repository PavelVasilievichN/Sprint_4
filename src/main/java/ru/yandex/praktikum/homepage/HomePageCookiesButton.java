package ru.yandex.praktikum.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageCookiesButton {
    private final WebDriver driver;
    //локатор для кнопки принятия кук
    private final By acceptingCookies = By.xpath(".//button[@id='rcc-confirm-button']");

    public HomePageCookiesButton(WebDriver driver) {
        this.driver = driver;
    }

    //Метод принять куки нажатием на кнопку
    public void acceptCookiesButton(){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(acceptingCookies));
        driver.findElement(acceptingCookies).click();
    }
}
