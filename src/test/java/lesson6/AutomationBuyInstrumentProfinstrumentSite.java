package lesson6;

import hw6.MainePageStart;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutomationBuyInstrumentProfinstrumentSite {

    WebDriver driver;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
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
        driver.quit();

    }


}

