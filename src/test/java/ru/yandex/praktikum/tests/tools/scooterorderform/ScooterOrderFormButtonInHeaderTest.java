package ru.yandex.praktikum.tests.tools.scooterorderform;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.homepage.HomePageYandexScooter;
import ru.yandex.praktikum.homepage.HomePageCookiesButton;
import ru.yandex.praktikum.orderscooter.ScooterOrderForm;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.praktikum.tests.tools.ToolBrowsers.getBrowser;

@RunWith(Parameterized.class)
public class ScooterOrderFormButtonInHeaderTest {
    private WebDriver driver;

    private final String nameField;
    private final String lastNameField;
    private final String addressCustomersField;
    private final String metroStationField;
    private final String telephoneNumberField;
    private final String deliveryDateField;
    private final String rentalPeriodField;
    private final String blackPearlCheckbox;
    private final String commentForTheCourierField;

    public ScooterOrderFormButtonInHeaderTest(String nameField, String lastNameField, String addressCustomersField, String metroStationField,
                                              String telephoneNumberField, String deliveryDateField, String rentalPeriodField,
                                              String blackPearlCheckbox, String commentForTheCourierField) {
        this.nameField = nameField;
        this.lastNameField = lastNameField;
        this.addressCustomersField = addressCustomersField;
        this.metroStationField = metroStationField;
        this.telephoneNumberField = telephoneNumberField;
        this.deliveryDateField = deliveryDateField;
        this.rentalPeriodField = rentalPeriodField;
        this.blackPearlCheckbox = blackPearlCheckbox;
        this.commentForTheCourierField = commentForTheCourierField;
    }


    @Before
    public void setUp() {
        driver = getBrowser("chrome");
    }

    @Parameterized.Parameters
    public static Object[][]  getOrderFormData() {
        return new Object[][]{
                {"Семен", "Семёнов", "Морская 25", "Лубянка", "+79024445599",
                        "20.08.2025", "трое суток", "Серая безысходность", "Жду в срок"},
                {"Иван", "Иванов", "Ленина 99", "Аэропорт", "+79124445591",
                        "22.10.2025", "четверо суток", "Чёрный жемчуг", "Привозите быстрее, очень жду!"}
        };
    }
    @Test
    public void shouldOrderPlacedPositiveResultHeader(){
        var scooter = new HomePageYandexScooter(driver);
        scooter.openHomePage(driver);
        var cookiesButton = new HomePageCookiesButton(driver);
        cookiesButton.clickAcceptCookiesButton();
        var orderScooter = new ScooterOrderForm(driver);
        orderScooter.clickOrderButtonInHeader();
        orderScooter.setOutTheScooterOrderForm(nameField, lastNameField, addressCustomersField, metroStationField, telephoneNumberField,
                deliveryDateField, rentalPeriodField, blackPearlCheckbox, commentForTheCourierField);
        assertThat("Ожидаемый результат: Заказ оформлен", orderScooter.getModalWindowText(), containsString("Заказ оформлен"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
