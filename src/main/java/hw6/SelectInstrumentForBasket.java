package hw6;

import lesson6.WomenSuggestBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectInstrumentForBasket extends BaseModel {
    public SelectInstrumentForBasket(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(@class, 'btn_buy popdef order')]")
    private WebElement addInstrumentBasket;

    public AddInstrumentForBasket addInstrumentForBasket() {
        addInstrumentBasket.click();
        return new AddInstrumentForBasket(driver);
    }


}


