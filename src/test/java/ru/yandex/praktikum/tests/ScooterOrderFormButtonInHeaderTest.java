package ru.yandex.praktikum.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.homepage.HomePagYandexScooter;
import ru.yandex.praktikum.homepage.HomePageCookiesButton;
import ru.yandex.praktikum.orderscooter.ScooterOrderForm;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.praktikum.tests.tools.ToolBrowsers.getBrowser;

public class ScooterOrderFormButtonInHeaderTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = getBrowser("chrome");
    }

    @Test
    public void CheckingTheScooterOrderForm(){
        var scooter = new HomePagYandexScooter(driver);
        scooter.openHomePage(driver);
        var cookiesButton = new HomePageCookiesButton(driver);
        cookiesButton.acceptCookiesButton();
        var orderScooter = new ScooterOrderForm(driver);
        orderScooter.clickOrderButtonInHeaderOrFooter(orderScooter.buttonInHeader);
        orderScooter.fillingOutTheScooterOrderForm("Константин", "Смирнов", "Кирова 195", "Сокольники", "+79993334455", "01.01.2025",
                "трое суток", "Чёрная жемчужина", "Просьба, без опоздания!");
        orderScooter.selectButtonYes();
        System.out.println(orderScooter.getTextOrderConfirmation());
        assertThat("Ожидаемый результат: окно Заказ оформлен", orderScooter.getTextOrderConfirmation(), containsString("Заказ оформлен"));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
