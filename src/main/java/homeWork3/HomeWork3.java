package homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =  new ChromeDriver();
        driver.get("https://profinstrument.kz");

        driver.findElement(By.id("title-search-input")).sendKeys("Дрель");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'catalog-item-card')][last()]" +
                "//button[contains(@class, 'btn_buy')]")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'btn_buy popdef order')]")).click();

        driver.findElement(By.name("BasketOrder")).click();

        driver.close();



    }
}
