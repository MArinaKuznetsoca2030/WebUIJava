package hw7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectInstrumForBasket extends BaseModelPage {
    public SelectInstrumForBasket(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class, 'btn_buy popdef order')]")
    private WebElement addInstrumentBasket;


    @Step("Добавляем инструмент в корзину")
    public AddInstrumForBasket addInstrumentForBasket() {
        addInstrumentBasket.click();
        return new AddInstrumForBasket(driver);
    }


}


