package ru.yandex.praktikum.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.homepage.HomePagYandexScooter;
import ru.yandex.praktikum.homepage.HomePageCookiesButton;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.tests.tools.ToolBrowsers.getBrowser;

@RunWith(Parameterized.class)
public class DropDownListTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = getBrowser("chrome");
    }

    private final String textOne;
    private final String textTwo;
    private final String textThree;
    private final String textFour;
    private final String textFive;
    private final String textSix;
    private final String textSeven;
    private final String textEight;
    private final boolean expectedResult;

    public DropDownListTest(String textOne, String textTwo, String textThree, String textFour, String textFive,
                            String textSix, String textSeven, String textEight, boolean expectedResult) {
        this.textOne = textOne;
        this.textTwo = textTwo;
        this.textThree = textThree;
        this.textFour = textFour;
        this.textFive = textFive;
        this.textSix = textSix;
        this.textSeven = textSeven;
        this.textEight = textEight;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData(){
        return new Object[][]{ {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
                {"Сутки — 555 рублей. Оплата курьеру — наличными или картой.",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области.", false}
        };
    }

    @Test
    public void fillingOutTheScooterOrderForm(){
        var scooter = new HomePagYandexScooter(driver);
        scooter.openHomePage(driver);
        var cookiesButton = new HomePageCookiesButton(driver);
        cookiesButton.acceptCookiesButton();
        scooter.scrollToTheElement(scooter.getDropDownListButtonOne());
        boolean actualText = scooter.checkDropDownList(textOne, textTwo, textThree, textFour, textFive, textSix, textSeven, textEight);
        assertEquals("Текст не совпадает с ожидаемым", expectedResult, actualText);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
