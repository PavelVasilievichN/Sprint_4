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
public class DropDownListItemPossibleExtendOrderOrReturnScooterEarlierTest {
    private WebDriver driver;
    private final String question;
    private final String answer;
    private final boolean expectedResult;

    public DropDownListItemPossibleExtendOrderOrReturnScooterEarlierTest(String question, String answer, boolean expectedResult) {
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
        return new Object[][]{ {"Можно ли продлить заказ или вернуть самокат раньше?",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true}
        };
    }

    @Test
    public void shouldAnswerCorrespondQuestionPossibleExtendOrderOrReturnScooterEarlier(){
        var scooter = new HomePageYandexScooter(driver);
        scooter.openHomePage(driver);
        var cookiesButton = new HomePageCookiesButton(driver);
        cookiesButton.clickAcceptCookiesButton();
        scooter.scrollToTheElement(scooter.getDropDownListItemHowMuchCostAndHowPay());
        boolean actualResult = scooter.checkDropDownListItemPossibleExtendOrderOrReturnScooterEarlier(question, answer);
        assertEquals("Ответ несоответствует вопросу", expectedResult, actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
