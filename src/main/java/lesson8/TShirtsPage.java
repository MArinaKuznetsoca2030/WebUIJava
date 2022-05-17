package lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

public class TShirtsPage {

    private ElementsCollection sizesList = $$(By.xpath("//span[.='Size']/ancestor::div[@class='layered_filter']//a"));

    @Step("Выбрать размер одежды в фильтре")
    public TShirtsPage selectSizeFilter(String size) {
        sizesList.findBy(Condition.text(size)).click();
        return this;
    }

    private ElementsCollection productsList = $$(By.xpath("//ul[contains(@class, 'product_list')]/li"));

    private SelenideElement addToCarButton = $(By.xpath("//span[.='Add to cart']"));

    @Step("Насти курсор мыши на продукт и добавить его в корзину")
    public SuccessBlock howerAndClickAddToCardProductByNae(String productName) {
        //text ищет по содержимому // exactValue ө точное совпадение һ
        productsList.findBy(Condition.text(productName)).hover();
        addToCarButton.click();
        return page(SuccessBlock.class);
    }

    }
