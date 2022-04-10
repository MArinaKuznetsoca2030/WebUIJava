package hw6;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateOrder extends BaseModel {

    public CreateOrder(WebDriver driver) {
        super(driver);
    }

    private final static String titleBlock = "pagetitle";

    @FindBy(id = "pagetitle")
    private WebElement titleBlockCheck;

    @Step("Проводим проверки перед оформление заказа")
    public void checkOrder() {
        webDriverWait.until((ExpectedConditions.visibilityOf(titleBlockCheck)));
        Assertions.assertTrue(driver.findElement(By.name("USER_LOGIN")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.name("USER_PASSWORD")).isDisplayed());
}
}
