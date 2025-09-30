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
public class DropDownListItemChargerWithScooterTest {
    private WebDriver driver;
    private final String question;
    private final String answer;
    private final boolean expectedResult;

    public DropDownListItemChargerWithScooterTest(String question, String answer, boolean expectedResult) {
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
        return new Object[][]{ {"Вы привозите зарядку вместе с самокатом?",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},

        };
    }

    @Test
    public void shouldAnswerCorrespondQuestionChargerWithScooter(){
        var scooter = new HomePageYandexScooter(driver);
        scooter.openHomePage(driver);
        var cookiesButton = new HomePageCookiesButton(driver);
        cookiesButton.clickAcceptCookiesButton();
        scooter.scrollToTheElement(scooter.getDropDownListItemHowMuchCostAndHowPay());
        boolean actualResult = scooter.checkDropDownListItemChargerWithScooter(question, answer);
        assertEquals("Ответ несоответствует вопросу", expectedResult, actualResult);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

