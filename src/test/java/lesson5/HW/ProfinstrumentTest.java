package lesson5.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.*;
import java.time.Duration;


public class ProfinstrumentTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String BASE_URL = "https://profinstrument.kz";

    @BeforeAll
    static void resisterDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }

    @Test
    void buyGoods() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title-search-input")));
        driver.findElement(By.id("title-search-input")).sendKeys("Дрель");

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
        driver.findElement(By.name("submit")).click();

        driver.findElement(By.xpath("//div[contains(@class, 'catalog-item-card')][last()]" +
                "//button[contains(@class, 'btn_buy')]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn_buy')]")));
        driver.findElement(By.xpath("//button[contains(@class, 'btn_buy popdef order')]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("coupon")));
        Assertions.assertTrue(driver.findElement(By.id("coupon")).isDisplayed());

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_basket_order")));
        driver.findElement(By.id("btn_basket_order")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("USER_LOGIN")));
        Assertions.assertTrue(driver.findElement(By.name("USER_LOGIN")).isDisplayed());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
