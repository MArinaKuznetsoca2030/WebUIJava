package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://profinstrument.kz");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.id("title-search-input")).sendKeys("Дрель");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'catalog-item-card')][last()]" +
                "//button[contains(@class, 'btn_buy')]")).click();

        //проверяем элемент стал ли видимым
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn_buy')]")));

        driver.findElement(By.xpath("//button[contains(@class, 'btn_buy popdef order')]")).click();

        driver.findElement(By.name("BasketOrder")).click();


        driver.close();



    }
}
