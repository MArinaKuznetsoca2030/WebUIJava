package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseView {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public BaseView(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);

        //некоторые элементы могут появиться только, не в момент загрузки страницы, а
        // когда к ним обращается, строка ниже решает эту проблему, каждый раз при обращении
        // к элементу  идет перечитываание его текущего состояния
        PageFactory.initElements(driver, this);
    }
}
