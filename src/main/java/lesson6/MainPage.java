package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {

    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;

    @Step("Клик на кнопку авторизации")
    public LoginPage clickSigInButton() {
        signInButton.click();
        //если нужно сделать проверку прям в шаге, ттгда моно добавь так, обычно проверки добавляют в конце
       // assertThat(driver.findElement(By.xpath("//i[@class='icon-ok']")), not(isDisplayed()));
        return new LoginPage(driver);
    }

    public MainPage(WebDriver driver) {
        super(driver);

    }
}
