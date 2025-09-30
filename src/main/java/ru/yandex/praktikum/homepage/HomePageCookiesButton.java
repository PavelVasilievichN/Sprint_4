
package ru.yandex.praktikum.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.util.EvnConfig;

public class HomePageCookiesButton {
    private final WebDriver driver;
    private final EvnConfig config = new EvnConfig();
    //локатор для кнопки принятия кук
    private final By acceptingCookies = By.xpath(".//button[@id='rcc-confirm-button']");

    public HomePageCookiesButton(WebDriver driver) {
        this.driver = driver;
    }
    //Метод принять куки нажатием на кнопку
    public void clickAcceptCookiesButton(){
        config.waitElementToBeClickable(driver, acceptingCookies);
        driver.findElement(acceptingCookies).click();
    }
}
