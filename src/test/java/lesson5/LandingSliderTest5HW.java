package lesson5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LandingSliderTest5HW {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private final static String BASE_URL = "https://latoken.com";

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
    void bidSlaiderTest()  {

        //правая кнопка слайдера
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[contains(@data-tid, 'btn__slideNext')]")));
        driver.findElement(By.xpath("//button[contains(@data-tid, 'btn__slideNext')]")).click();

        //проверка, слайдер работает, данные слайдера изменились
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'slick-slide slick-active slick-current')]" +
                        "//div[contains(@data-tid, 'slider_item_true_active')]//h1[.='Buy new crypto']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'slick-slide slick-active slick-current')]" +
                "//div[contains(@data-tid, 'slider_item_true_active')]//h1[.='Buy new crypto']")).isDisplayed());

        //закрыть VCTV виджет, мешает нажимать на левую кнопку слайдера
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='LAVCTV']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@id='widget']//div/div[3]")));
        driver.findElement(By.xpath("//div[@id='widget']//div/div[3]")).click();
        driver.switchTo().parentFrame();

        //левая кнопка слайдера
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[contains(@data-tid, 'btn__slidePrev')]")));
        driver.findElement(By.xpath("//button[contains(@data-tid, 'btn__slidePrev')]")).click();

        //проверка, слайдер работает, данные слайдера изменились
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'slick-slide slick-active slick-current')]" +
                        "//h1[.='Buy & sell crypto']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'slick-slide slick-active slick-current')]" +
                "//h1[.='Buy & sell crypto']")).isDisplayed());

    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
