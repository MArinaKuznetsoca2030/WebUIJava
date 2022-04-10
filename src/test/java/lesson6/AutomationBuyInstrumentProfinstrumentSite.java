package lesson6;

import hw6.MainePageStart;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import lesson7.CustomLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;


public class AutomationBuyInstrumentProfinstrumentSite {

    WebDriver driver;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {

        //driver = new ChromeDriver();
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
    }

    @Test
    @Feature("Добавление товара в корзину и оформление заказа")
    void addInstrumentTest() {
        driver.get("https://profinstrument.kz");

        new MainePageStart(driver)
                .findInstrument("дрель")
                .selectInsrumentForBasket()
                .addInstrumentForBasket()
                .addOrder()
                .checkOrder();
    }

    @AfterEach
    void tearDown() {

        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Элемент лога браузера", log.getMessage());

        }
        driver.quit();

    }


}

