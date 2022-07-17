package com.gmail.cage7676.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderDetailsFormPage extends BaseUITest {
    private final WebDriver driver;
    public OrderDetailsFormPage(WebDriver driver) {
        this.driver = driver;
    }
    // Поле имя
    private final By customerName = By.xpath(".//input[@placeholder = '* Имя']");
    // Поле фамилия
    private final By customerLastName = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Поле адрес
    private final By customerAddress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Выбор метро
    private final By metroStationList = By.xpath(".//input[@class='select-search__input']");
    // Поле телефон
    private final By customerPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка продолжить оформление заказа
    private final By furtherButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Форма 2. Поле 'Когда привезти самокат'
    private final By customerOrderDate = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    // Форма 2. Выбор даты
    private final By rentalPeriodField = By.className("Dropdown-placeholder");
    // Форма 2. Динамическая подстановка даты
    private String rentalPeriodDropDown = "//div[@class ='Dropdown-option' and text()='%s']";
    // Форма 2. Выбор цвета
    private String colorScooter = "//label[@for='%s']";
    // Форма 2. Комментарий для курьера
    private final By customerComment = By.xpath("//input[@placeholder='Комментарий для курьера']");
    // Форма 2. Кнопка завершения оформления заказа
    private final By finalButtonOrder = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public OrderDetailsFormPage fillOrderDetailsForm(Order order) {
        fillName(order.getName());
        fillLastName(order.getLastName());
        fillAddress(order.getAddress());
        fillMetroStation(order.getMetroStation());
        fillPhone(order.getPhone());
        clickFurtherButton();
        fillOrderDate(order.getOrderDate());
        fillRentalPeriod(order.getRentalPeriod());
        fillScooterColour(order.getScooterColour());
        fillCustomerComment(order.getOrderComment());
        clickFinalButtonOrder();

        return this;
    }

    private OrderDetailsFormPage fillName(String name) {
        driver.findElement(customerName).sendKeys(name);
        return this;
    }

    private OrderDetailsFormPage fillLastName(String lastName) {
        driver.findElement(customerLastName).sendKeys(lastName);
        return this;
    }

    private OrderDetailsFormPage fillAddress(String address) {
        driver.findElement(customerAddress).sendKeys(address);
        return this;
    }

    private OrderDetailsFormPage fillMetroStation(String metroStation) {
        driver.findElement(metroStationList).sendKeys(metroStation + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    private OrderDetailsFormPage fillPhone(String phone) {
        driver.findElement(customerPhone).sendKeys(phone);
        return this;
    }
    private OrderDetailsFormPage clickFurtherButton() {
        driver.findElement(furtherButton).click();
        return this;
    }

    //Выбор даты
    private OrderDetailsFormPage fillOrderDate(String orderDate) {
        driver.findElement(customerOrderDate).click();
        driver.findElement(customerOrderDate).sendKeys(orderDate + Keys.ENTER);
        return this;
    }

    private OrderDetailsFormPage fillRentalPeriod(String rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath(String.format(rentalPeriodDropDown, rentalPeriod))).click();
        return this;
    }

    private OrderDetailsFormPage fillScooterColour(String scooterColour) {
        driver.findElement(By.xpath(String.format(colorScooter, scooterColour))).click();
        return this;
    }

    private OrderDetailsFormPage fillCustomerComment(String orderComment) {
        driver.findElement(customerComment).click();
        driver.findElement(customerComment).sendKeys(orderComment);
        return this;
    }

    private OrderDetailsFormPage clickFinalButtonOrder() {
        driver.findElement(finalButtonOrder).click();
        return this;
    }
}

