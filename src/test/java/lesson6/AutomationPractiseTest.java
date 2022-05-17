package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson7.CustomLogger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

@Story("Добавление в корзину")
public class AutomationPractiseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
     Actions actions;


    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {

        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
    }

    @Test
    @Feature("Работа с корзиной")
    void addCartTest() throws InterruptedException {

        driver.get("http://automationpractice.com/");
        // new MainPage(driver).signInButton.click();
        // или
        //new MainPage(driver).signInButton.click();
        //new LoginPage(driver).login("spartalex93@test.test", "123456");

        //или
        new MainPage(driver)
                .clickSigInButton()
                .login("spartalex93@test.test", "123456")
                .hoverWomenButton()
                .tShirtsButton()
                .selectSizeFilter("S")
                .howerAndClickAddToCardProductByNae("Faded")
                .checkSuccessWithSum("34");


        //not(isDisplayed()) - не виден элемент
     //   assertThat(driver.findElement(By.xpath("//i[@class='icon-ok']")), not(isDisplayed()));



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
