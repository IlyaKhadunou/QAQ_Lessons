package Lesson_15;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestMtsBy_Lesson_15 {
    private static WebDriver driver;


    @BeforeEach
    public void setUp() {
        try {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://www.mts.by");
            // клик на принятие Cookies
            WebElement buttonCookies = driver.findElement(By.xpath("//*[@id='cookie-agree']"));
            if (buttonCookies.isDisplayed() && buttonCookies.isEnabled()) {
                buttonCookies.click();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка настройки WebDriver: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка названия блока")
    void testTitle() {
        try {
            WebElement title =
                    driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2"));
            String expectedTitle = "Онлайн пополнение\nбез комиссии";
            assertEquals(expectedTitle, title.getText());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ошибка при проверке заголовка: " + e.getMessage());
        }
    }


    @Test
    @DisplayName("Проверка наличия логотипов платежных систем")
    void testPaymentLogos() {
        try {
            List<WebElement> paymentLogos =
                    driver.findElements(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]"));
            assertTrue(paymentLogos.size() > 0);

            for (WebElement logo : paymentLogos) {
                assertTrue(logo.isDisplayed());
            }
        } catch (Exception e) {
            System.out.println("Ошибка при проверке логотипов платежных систем: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Проверка работы ссылки")
    public void testLink() {
        try {
            WebElement link = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a"));
            link.click();
            String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
            String actualUrl = driver.getCurrentUrl();
            assertEquals(actualUrl, expectedUrl);
        } catch (Exception e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Заполнение поля 'Номер телефона' и проверка кликабельности кнопки 'Продолжить'")
    public void testFieldAndButton() {
        try {
            WebElement telephoneNumber = driver.findElement(By.xpath("//*[@id='connection-phone']"));
            telephoneNumber.sendKeys("297777777");
            WebElement amount = driver.findElement(By.xpath("//*[@id='connection-sum']"));
            amount.sendKeys("10");
            WebElement button = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
            assertTrue("Button is not displayed", button.isDisplayed());
            button.click();
            assertTrue("Button is not enabled", button.isEnabled());
        } catch (Exception e) {
            System.out.println("Элемент не найден " + e.getMessage());
        }
    }
}