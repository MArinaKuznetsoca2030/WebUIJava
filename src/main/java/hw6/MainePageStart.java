package hw6;

import lesson6.LoginPage;
import lesson6.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainePageStart extends BaseModel {


    @FindBy(id = "title-search-input")
    private WebElement searchField;

    @FindBy(name = "submit")
    private WebElement findButton;


    public SearchBlock findInstrument (String text){
        searchField.sendKeys(text);
        findButton.click();
        return  new SearchBlock(driver);
    }

    public MainePageStart(WebDriver driver) {
        super(driver);

    }
}
