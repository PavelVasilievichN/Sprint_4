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

public class ScooterOrderFormButtonInFooterTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = getBrowser("firefox");
    }

    @Test
    public void CheckingTheScooterOrderForm(){
        var scooter = new HomePagYandexScooter(driver);
        scooter.openHomePage(driver);
        var cookiesButton = new HomePageCookiesButton(driver);
        cookiesButton.acceptCookiesButton();
        var orderScooter = new ScooterOrderForm(driver);
        scooter.scrollToTheElement(orderScooter.getOrderButtonInFooter());
        orderScooter.clickOrderButtonInHeaderOrFooter(orderScooter.buttonInFooter);
        orderScooter.fillingOutTheScooterOrderForm( "Глеб", "Глебов", "Советская 105", "Сокольники", "+79024445599",
                "20.08.2025", "двое суток", "Серая безысходность", "Жду в срок");
        orderScooter.selectButtonYes();
        assertThat("Ожидаемый результат: окно Заказ оформлен", orderScooter.getTextOrderConfirmation(), containsString("Заказ оформлен"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
