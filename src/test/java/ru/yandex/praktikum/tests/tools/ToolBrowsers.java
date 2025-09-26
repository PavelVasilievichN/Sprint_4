package ru.yandex.praktikum.tests.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToolBrowsers {
    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }
}
