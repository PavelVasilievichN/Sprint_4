package ru.yandex.praktikum.tests.tools.dropdownlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.homepage.HomePageYandexScooter;
import ru.yandex.praktikum.homepage.HomePageCookiesButton;
import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.tests.tools.ToolBrowsers.getBrowser;

@RunWith(Parameterized.class)
public class DropDownListItemHowMuchCostAndHowPayTest {
    private WebDriver driver;
    private final String question;
    private final String answer;
    private final boolean expectedResult;

    public DropDownListItemHowMuchCostAndHowPayTest(String question, String answer, boolean expectedResult) {
        this.question = question;
        this.answer = answer;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        driver = getBrowser("chrome");
    }

    @Parameterized.Parameters
    public static Object[][] getTextData(){
        return new Object[][]{ {"Сколько это стоит? И как оплатить?",
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true}
        };
    }

    @Test
    public void shouldAnswerCorrespondQuestionHowMuchCostAndHowPay(){
        var scooter = new HomePageYandexScooter(driver);
        scooter.openHomePage(driver);
        var cookiesButton = new HomePageCookiesButton(driver);
        cookiesButton.clickAcceptCookiesButton();
        scooter.scrollToTheElement(scooter.getDropDownListItemHowMuchCostAndHowPay());
        boolean actualResult = scooter.checkDropDownListItemHowMuchCostAndHowPay(question, answer);
        assertEquals("Ответ несоответствует вопросу", expectedResult, actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}