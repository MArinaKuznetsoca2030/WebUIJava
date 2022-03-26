package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork3_example2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://latoken.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[contains(@data-tid, 'btn__slideNext')]")));

        driver.findElement(By.xpath("//button[contains(@data-tid, 'btn__slideNext')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'slick-slide slick-active slick-current')]" +
          "//h1[.='Buy new crypto']")).isDisplayed();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[contains(@data-tid, 'btn__slidePrev')]")));
        driver.findElement(By.xpath("//button[contains(@data-tid, 'btn__slidePrev')]")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'slick-slide slick-active slick-current')]" +
                "//h1[.='Buy & sell crypto']")).isDisplayed();

        driver.close();
    }

}
