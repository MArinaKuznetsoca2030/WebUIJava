package hw7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddInstrumForBasket extends BaseModelPage {

    public AddInstrumForBasket(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn_basket_order")
    private WebElement createOrderButton;

    @Step("Приступаем к оформлению заказа")
    public CreateNewOrder addOrder() {
        createOrderButton.click();
        return new CreateNewOrder(driver);
    }

}
