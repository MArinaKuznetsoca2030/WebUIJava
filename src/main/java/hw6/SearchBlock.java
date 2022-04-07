package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBlock extends BaseModel{
    public SearchBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'catalog-item-card')][last()]//button[contains(@class, 'btn_buy')]")
    private WebElement selectInstrumentButton;

    public SelectInstrumentForBasket selectInsrumentForBasket() {
        selectInstrumentButton.click();

        return  new SelectInstrumentForBasket(driver);
    }


}
