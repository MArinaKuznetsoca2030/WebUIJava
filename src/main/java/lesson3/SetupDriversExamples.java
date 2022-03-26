package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v95.domsnapshot.model.ArrayOfStrings;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.WindowType.TAB;
import static org.openqa.selenium.WindowType.WINDOW;

public class SetupDriversExamples {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notificationd"); //chrome options - набрать в баузере, можно посмотреть все опции
       // chromeOptions.addArguments("--headless"); посмотреть только результат, браузер не загружается
        chromeOptions.addArguments("user-agent=Googleboot/2.1 (thhp://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        Thread.sleep(5000);

        //((JavascriptExecutor)driver).executeScript("window.open()");

        driver.switchTo().newWindow(TAB);
        Thread.sleep(5000);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.close();
        Thread.sleep(5000);

        driver.quit();


    }
}
