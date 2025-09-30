package ru.yandex.praktikum.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EvnConfig {
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String SCROLL_ELEMENT = "arguments[0].scrollIntoView();";
    public static final int EXPLICIT_TIMEOUT = 5;

    public void waitVisibilityOfElementLocated(WebDriver driver, By elementLocator){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void waitElementToBeClickable(WebDriver driver, By elementLocator){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(elementLocator));
    }
}
