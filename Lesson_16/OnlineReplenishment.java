package Lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineReplenishment {

    private WebDriver driver;

    private WebDriverWait wait;

    public OnlineReplenishment(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Локаторы для варианта "Услуги свзяи"
    private By phoneNumberCommunicationServicesLocator = By.id("connection-phone");
    private By amountCommunicationServicesLocator = By.id("connection-sum");
    private By emailCommunicationServicesLocator = By.id("connection-email");

    //Локаторы для варианта "Домашний интернет"
    private By phoneNumberHomeInternetLocator = By.id("internet-phone");
    private By amountHomeInternetLocator = By.id("internet-sum");
    private By emailHomeInternetLocator = By.id("internet-email");

    //Локаторы для варианта "Рассрочка"
    private By accountNumberInstallmentLocator = By.id("score-instalment");
    private By amountInstallmentLocator = By.id("instalment-sum");
    private By emailInstallmentLocator = By.id("instalment-email");

    //Локаторы для варианта "Рассрочка"
    private By accountNumberArrearsLocator = By.id("score-arrears");
    private By amountArrearsLocator = By.id("arrears-sum");
    private By emailArrearsLocator = By.id("arrears-email");

    // Получаем значниея плейсхолдеров "Услуги сваязи"
    public String getPhoneNumberCommunicationServices(String placeholder) {
        WebElement placeholderPhoneNumber = driver.findElement(phoneNumberCommunicationServicesLocator);
        return placeholderPhoneNumber.getAttribute(placeholder);
    }

    public String getAmountCommunicationServices(String placeholder) {
        WebElement placeholderAmountCommunicationServices = driver.findElement(amountCommunicationServicesLocator);
        return placeholderAmountCommunicationServices.getAttribute(placeholder);
    }

    public String getEmailCommunicationServices(String placeholder) {
        WebElement placeholderEmailCommunicationServices = driver.findElement(emailCommunicationServicesLocator);
        return placeholderEmailCommunicationServices.getAttribute(placeholder);
    }
    // Получаем значниея плейсхолдеров "Домашний интернет"
    public String getPhoneNumberHomeInternet(String placeholder) {
        WebElement placeholderPhoneNumberField = driver.findElement(phoneNumberHomeInternetLocator);
        return placeholderPhoneNumberField.getAttribute(placeholder);
    }

    public String getAmountHomeInternet(String placeholder) {
        WebElement placeholderAmountField = driver.findElement(amountHomeInternetLocator);
        return placeholderAmountField.getAttribute(placeholder);
    }

    public String getEmailHomeInternet(String placeholder) {
        WebElement placeholderEmailField = driver.findElement(emailHomeInternetLocator);
        return placeholderEmailField.getAttribute(placeholder);
    }
    // Получаем значниея плейсхолдеров "Рассрочка"
    public String getAccountNumberInstallment(String placeholder) {
        WebElement placeholderAccountNumberInstallment = driver.findElement(accountNumberInstallmentLocator);
        return placeholderAccountNumberInstallment.getAttribute(placeholder);
    }

    public String getAmountInstallment(String placeholder) {
        WebElement placeholderAmountInstallment = driver.findElement(amountInstallmentLocator);
        return placeholderAmountInstallment.getAttribute(placeholder);
    }

    public String getEmailInstallment(String placeholder) {
        WebElement placeholderEmailInstallment = driver.findElement(emailInstallmentLocator);
        return placeholderEmailInstallment.getAttribute(placeholder);
    }
    // Получаем значниея плейсхолдеров "Задолженность"
    public String getAccountNumberArrears(String placeholder) {
        WebElement placeholderAccountNumberArrears = driver.findElement(accountNumberArrearsLocator);
        return placeholderAccountNumberArrears.getAttribute(placeholder);
    }

    public String getAmountArrears(String placeholder) {
        WebElement placeholderAmountArrears = driver.findElement(amountArrearsLocator);
        return placeholderAmountArrears.getAttribute(placeholder);
    }

    public String getEmailArrears(String placeholder) {
        WebElement placeholderEmailArrears = driver.findElement(emailArrearsLocator);
        return placeholderEmailArrears.getAttribute(placeholder);
    }
}
