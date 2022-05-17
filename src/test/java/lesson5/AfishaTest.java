package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.*;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String AFISHA_BASE_URL = "https://afisha.ru";

    @BeforeAll
    static void resisterDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(AFISHA_BASE_URL);

    }
    @Test
    void likeRandomFilmTest() throws InterruptedException {
        Thread.sleep(7000);
        //ElementLocated если элемента вообще на странице нет и мы хотим дождаться какого то его состояния
        //visibilityOf - если элемент уже на странице
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//button[.='ОК']")));
        driver.findElement(xpath("//button[.='ОК']")).click();

        List<WebElement> filmList = driver.findElements(xpath("//a[contains(@href,'movie') and @data-test='LINK ITEM-NAME ITEM-URL']/h2"));
        driver.findElement(xpath("//h2[.='Сегодня в кино']/ancestor::div[@data-test='PAGE-SECTION-HEADER']")).click();
        driver.findElement(xpath("//h2[.='Сегодня в кино']/ancestor::div[@data-test='PAGE-SECTION-HEADER']")).click();

        filmList.stream().filter(f -> f.getText().contains("Брат-2")).findFirst().get().click();
        Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));

        boolean loginFrameAppeared = false;

     //   while (!loginFrameAppeared){
            driver.findElement(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();
          //должно быть так  if (driver.findElement(By.xpath("//iframe[contains(@src, 'id.rambler.ru/login-20/')]")).size > 0){
        //    if (driver.findElement(By.xpath("//iframe[contains(@src, 'id.rambler.ru/login-20/')]")).getSize() > 0){
        //        loginFrameAppeared = true;
       //     };

            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'id.rambler.ru/login-20/')]")));
            Assertions.assertEquals(driver.findElement(By.id("login")).isDisplayed(), true);

        //}


        String a = "";
    }

    @Test
    void hoverItemTest() throws InterruptedException {
        Thread.sleep(7000);
        actions.moveToElement(driver.findElement(By.xpath("//div[@data-test='HEADER-MENU']//a[@href='/msk/cinema/']")))
                .build()
                .perform();
        driver.findElement(By.xpath("//div[@data-test='SUGGEST']//a[.='Скоро онлайн в Okko']")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.afisha.ru/movie/okko-soon/");

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
