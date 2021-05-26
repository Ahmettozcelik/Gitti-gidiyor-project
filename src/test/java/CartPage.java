import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    By productNameLocator = new By.ByCssSelector("a[class='title-link']");
    By deleteToCartLocator = new By.ByCssSelector("a[title='Sil']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEmpty() {
        return getProducts().size() > 0;
    }

    public void deleteToCart() {
        click(deleteToCartLocator);
    }

    private List<WebElement> getProducts(){
        return findAll(productNameLocator);
    }
}
