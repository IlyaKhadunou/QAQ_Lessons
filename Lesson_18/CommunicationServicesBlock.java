package Lesson_18;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class CommunicationServicesBlock {

    private WebDriver driver;

    private WebDriverWait wait;

    public CommunicationServicesBlock(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Локаторы
    private By buttonAcceptCookiesLocator = By.id("cookie-agree");
    private By titleLocator = By.xpath("//*[contains(text(), 'Онлайн пополнение ')]");
    private By paymentLogosLocator = By.className("pay__partners");
    private By moreInfoLinkLocator = By.xpath("//*[@id='pay-section']//section//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
    private By phoneNumberFieldLocator = By.id("connection-phone");
    private By amountFieldLocator = By.id("connection-sum");
    private By buttonContinueLocator = By.xpath("//*[@id='pay-connection']/button");

    //Локатор для перехода на iframe
    private By iframeLocator = By.xpath("//div[@class='bepaid-app__container']//iframe");
    //Локаторы полей всплывающего окна
    private By correctAmountLocator = By.xpath("//span[contains(text(), '10.00 BYN')]");
    private By correctPhoneNumberLocator = By.xpath("//span[contains(text(), '375297777777')]");
    private By numberCardFieldLocator = By.xpath("//label[contains(text(), 'Номер карты')]");

    private By correctPaymentLogosLocator = By.xpath("//div[@class='cards-brands ng-tns-c46-1']/div");
    private By validityPeriodLocator = By.xpath("//label[contains(text(), 'Срок действия')]");
    private By cvcCodeLocator = By.xpath("//label[contains(text(), 'CVC')]");
    private By nameCardOwnerLocator = By.xpath("//label[contains(text(), 'Имя держателя (как на карте)')]");
    private By buttonWithAmountLocator = By.xpath("//button[contains(text(), ' Оплатить  10.00 BYN ')]");


    //приняте Cookies
    @Step("Приняте Cookies")
    public void acceptCookies() {
        WebElement buttonCookies = driver.findElement(buttonAcceptCookiesLocator);
        if (wait.until(d -> buttonCookies.isDisplayed() && buttonCookies.isEnabled())) {
            buttonCookies.click();
        }
    }

    @Step("Получение названия блока 'Онлайн пополнение без комиссии'")
    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleLocator));
        WebElement titleBlock = driver.findElement(titleLocator);
        return titleBlock.getText();
    }

    @Step("Получение логотипов платежных систем")
    public List<WebElement> getPaymentLogos() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentLogosLocator));
        return driver.findElements(paymentLogosLocator);
    }

    @Step("Клик по ссылке 'Подробнее о сервисе'")
    public String clickMoreInfoLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(moreInfoLinkLocator));
        WebElement clickInfoLink = driver.findElement(moreInfoLinkLocator);
        clickInfoLink.click();
        return driver.getCurrentUrl();
    }

    @Step("Ввод номера телефона")
    public void enterPhoneNumber(String phoneNumber) {
        WebElement phoneNumberFiled = driver.findElement(phoneNumberFieldLocator);
        phoneNumberFiled.sendKeys(phoneNumber);
    }

    @Step("Ввод суммы")
    public void enterAmount(String amount) {
        WebElement amountField = driver.findElement(amountFieldLocator);
        amountField.sendKeys(amount);
    }

    @Step("Клик по кнопке 'Продолжить'")
    public void clickButtonContinue() {
        WebElement clickButton = driver.findElement(buttonContinueLocator);
        wait.until(d -> clickButton.isDisplayed() && clickButton.isEnabled());
        clickButton.click();
    }

    @Step("Переключение на iframe всплывающего окна")
    public void switchIframe() {
        wait.until(ExpectedConditions.presenceOfElementLocated(iframeLocator));
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
    }

    @Step("Получения значения суммы в всплывающем окне")
    public String correctAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(correctAmountLocator));
        WebElement amount = driver.findElement(correctAmountLocator);
        return amount.getText();
    }

    @Step("Получение значения номера телефона в всплывающем окне")
    public String correctPhoneNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(correctPhoneNumberLocator));
        WebElement phoneNumber = driver.findElement(correctPhoneNumberLocator);
        return phoneNumber.getText();
    }

    @Step("Получение надписи в поле 'Номер карты'")
    public String numberCardField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberCardFieldLocator));
        WebElement card = driver.findElement(numberCardFieldLocator);
        return card.getText();
    }

    @Step("Получение логотипов платежных систем'")
    public List<WebElement> paymentLogos() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(correctPaymentLogosLocator));
        return driver.findElements(correctPhoneNumberLocator);
    }

    @Step("Получение надписи в поле 'Срок действия'")
    public String validityPeriod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(validityPeriodLocator));
        WebElement validityPeriod = driver.findElement(validityPeriodLocator);
        return validityPeriod.getText();
    }

    @Step("Проверка надписи в поле 'CVC'")
    public String cvcCode() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cvcCodeLocator));
        WebElement cvcCode = driver.findElement(cvcCodeLocator);
        return cvcCode.getText();
    }

    @Step("Получение надписи в поле 'Имя владельца'")
    public String nameCardOwner() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameCardOwnerLocator));
        WebElement nameCardOwner = driver.findElement(nameCardOwnerLocator);
        return nameCardOwner.getText();
    }

    @Step("Получение надписи в кнопке ' Оплатить  10.00 BYN '")
    public String buttonWithAmount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonWithAmountLocator));
        WebElement buttonWithAmount = driver.findElement(buttonWithAmountLocator);
        return buttonWithAmount.getText();
    }
}