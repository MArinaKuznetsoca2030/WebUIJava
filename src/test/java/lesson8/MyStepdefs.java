package lesson8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.devtools.Connection;

import static com.codeborne.selenide.Selenide.open;

public class MyStepdefs {
    @Given("Пользователь авторизован на сайте")
    public void userAutorized() {
        //увеличить время ожидания
        Configuration.timeout = 10000;
        //сценарий запускается без интерфейса
        Configuration.headless = true;
        open("http://automationpractice.com/");

        new MainPage().clickSigInButton()
                .login("spartalex93@test.test", "123456");
    }

    @When("Я навожу мыш на раздел Женщины")
    public void hoverWomanButton() {
        new MyAccountPage().hoverWomenButton();
    }
//^ то предложение которое мы ищем долно начинаться обязательно со слова Я; потом между
// словом КЛИКАЮ и НА должен быть пробел а .* -любое количество символов
    @And("^Я кликаю .* на фильтр Рубашки")
    public void clickTSirtsButton() {
        new WomenSuggestBlock().tShirtsButton();
    }

    @And("Выбираю в фильтре размер S")
    public void checkSSize() {
        new TShirtsPage().selectSizeFilter("S");
    }

    @And("Добавляю в корзину продукт Faded")
    public void addCard() {
        new TShirtsPage().howerAndClickAddToCardProductByNae("Faded");
    }

    @Then("Проверяем корректность суммы заказа")
    public void checkSummOrder() {
        new SuccessBlock().checkSuccessWithSum("$16.51");
    }

    @And("Выбираю в фильтре размер {string}")
    public void выбираюВФильтреРазмерSize(String size) {
        new TShirtsPage().selectSizeFilter(size);
    }
}
