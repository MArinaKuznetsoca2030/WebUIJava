package hw6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddInstrumentForBasket extends BaseModel {

    public AddInstrumentForBasket(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn_basket_order")
    private WebElement createOrderButton;

    public CreateOrder addOrder() {
        createOrderButton.click();
        return new CreateOrder(driver);
    }



}
