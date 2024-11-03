package Lesson_18;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TestMtsBy_Lesson_18 {

    private WebDriver driver;
    private WebDriverWait wait;
    private OnlineReplenishment onlineReplenishment;
    private CommunicationServicesBlock communicationServices;


    @BeforeEach
    public void setUp() {
        try {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 30);
            driver.manage().window().maximize();
            driver.get("https://www.mts.by");

            onlineReplenishment = new OnlineReplenishment(driver, wait);
            communicationServices = new CommunicationServicesBlock(driver, wait);


            communicationServices.acceptCookies();
        } catch (Exception e) {
            fail("Ошибка настройки WebDriver: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (Exception e) {
            fail("Ошибка при закрытии браузера: " + e.getMessage());
        }
    }

    @Epic("Названия блока")
    @Test
    @Owner("Ходунов Илья Александрович")
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    @Description(value = "Тест проверяет наличие названия блока")
    void testBlockTitle() {
        try {
            assertEquals("Онлайн пополнение\nбез комиссии", communicationServices.getTitle());
        } catch (Exception e) {
            fail("Ошибка проверки названия блока: " + e.getMessage());
        }
    }

    @Epic("Логотипы платежных систем")
    @Test
    @Owner("Ходунов Илья Александрович")
    @DisplayName("Проверка наличия логотипов платежных систем")
    @Description(value = "Тест проверяет наличие логотипов платежных систем")
    void testPaymentLogos() {
        try {
            assertFalse(communicationServices.getPaymentLogos().isEmpty(), "Логотипы платежных систем не найдены");
        } catch (Exception e) {
            fail("Ошибка проверки наличия логотипов: " + e.getMessage());
        }
    }

    @Epic("Ссылки")
    @Test
    @Owner("Ходунов Илья Александрович")
    @DisplayName("Проверка работы ссылки 'Подробнее о сервисе'")
    @Description(value = "Тест проверяет работу ссылки 'Подробнее о сервисе'")
    void testMoreInfoLink() {
        try {
            assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", communicationServices.clickMoreInfoLink());
        } catch (Exception e) {
            fail("Ошибка проверки ссылки 'Подробнее о сервисе': " + e.getMessage());
        }
    }


    @Epic("Заполнение полей и работа с всплвыающим окном")
    @Test
    @Owner("Ходунов Илья Александрович")
    @DisplayName("Заполнение полей 'Номер телефона' и 'Сумма', с последующей проверкой в всплывающем окне Суммы" +
            "(в том числе на кнопке), Номера телефона, незаполненных полей, наличие лаготипов платежных систем")
    @Description(value = "Тест проверяет заполнение полей блока 'Услуги связи', с последующей проверкой надписей полей" +
            "всплывающего окна и проверкой номера телефона, суммы, суммы на кнопке")
    void testAppWrapper() {
        try {
            communicationServices.enterPhoneNumber("297777777");
            communicationServices.enterAmount("10");
            communicationServices.clickButtonContinue();

            communicationServices.switchIframe();

            assertEquals("10.00 BYN", communicationServices.correctAmount());
            assertEquals("Оплата: Услуги связи Номер:375297777777", communicationServices.correctPhoneNumber());
            assertEquals("Номер карты", communicationServices.numberCardField());
            assertFalse(communicationServices.paymentLogos().isEmpty());
            assertEquals("Срок действия", communicationServices.validityPeriod());
            assertEquals("CVC", communicationServices.cvcCode());
            assertEquals("Имя держателя (как на карте)", communicationServices.nameCardOwner());
            assertEquals("Оплатить 10.00 BYN", communicationServices.buttonWithAmount());
        } catch (Exception e) {
            fail("Ошибка: " + e.getMessage());
        }
    }

    @Epic("Атрибуты полей")
    @Test
    @Owner("Ходунов Илья Александрович")
    @DisplayName("Тест незаполненных полей вариантов 'Услуги связи','Домашний интернет','Рассрочка', 'Задолженность'")
    void testHomeInternet() {
        try {
            // Проверка незаполненных полей варианта "Услуги сваязи"
            assertEquals("Номер телефона", onlineReplenishment.getPhoneNumberCommunicationServices("placeholder"));
            assertEquals("Сумма", onlineReplenishment.getAmountCommunicationServices("placeholder"));
            assertEquals("E-mail для отправки чека", onlineReplenishment.getEmailCommunicationServices("placeholder"));

            // Проверка незаполненных полей варианта "Домашний интернет"
            assertEquals("Номер абонента", onlineReplenishment.getPhoneNumberHomeInternet("placeholder"));
            assertEquals("Сумма", onlineReplenishment.getAmountHomeInternet("placeholder"));
            assertEquals("E-mail для отправки чека", onlineReplenishment.getEmailHomeInternet("placeholder"));

            // Проверка незаполненных полей варианта "Рассрочка"
            assertEquals("Номер счета на 44", onlineReplenishment.getAccountNumberInstallment("placeholder"));
            assertEquals("Сумма", onlineReplenishment.getAmountInstallment("placeholder"));
            assertEquals("E-mail для отправки чека", onlineReplenishment.getEmailInstallment("placeholder"));

            // Проверка незаполненных полей варианта "Задолженность"
            assertEquals("Номер счета на 2073", onlineReplenishment.getAccountNumberArrears("placeholder"));
            assertEquals("Сумма", onlineReplenishment.getAmountArrears("placeholder"));
            assertEquals("E-mail для отправки чека", onlineReplenishment.getEmailArrears("placeholder"));
        } catch (Exception e) {
            fail("Ошибка: " + e.getMessage());
        }
    }
}