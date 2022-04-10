package hw7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MaineStartPage extends BaseModelPage {


    @FindBy(id = "title-search-input")
    private WebElement searchField;

    @FindBy(name = "submit")
    private WebElement findButton;

    @Step("Ищем элемент в поле поиска")
    public SearchBlockInstrument findInstrument (String text){
        searchField.sendKeys(text);
        findButton.click();
        return  new SearchBlockInstrument(driver);
    }

    public MaineStartPage(WebDriver driver) {
        super(driver);

    }

}
