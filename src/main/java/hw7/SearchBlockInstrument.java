package hw7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBlockInstrument extends BaseModelPage {
    public SearchBlockInstrument(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'catalog-item-card')][last()]//button[contains(@class, 'btn_buy')]")
    private WebElement selectInstrumentButton;

    @Step("Выбираем инструмент по определенным параметрам")
    public SelectInstrumForBasket selectInsrumentForBasket() {
        selectInstrumentButton.click();

        return  new SelectInstrumForBasket(driver);
    }

}
