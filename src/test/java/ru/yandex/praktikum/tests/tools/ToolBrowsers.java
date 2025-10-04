package ru.yandex.praktikum.tests.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ToolBrowsers {

    public static WebDriver getBrowser(String browserName) {
        WebDriver driver = null;
        switch (browserName){
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "chrome":
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Invalid browser name!");
        }
        return driver;
    }
}