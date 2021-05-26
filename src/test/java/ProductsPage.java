import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage{

    By viewButtonLocator = new By.ByCssSelector("a[title='Liste Görünümü']");
    By productNameLocator = new By.ByCssSelector("div[class='cell-border-css']");
//    By secondPageLocator = new By.ByCssSelector("a[href='/dizustu-laptop-notebook-bilgisayar?k=laptop&sf=2']");
    By closeCookiesLocator = new By.ByCssSelector("a[class='tyj39b-3 fEwnjq']");
    By closeImageLocator = new By.ByCssSelector("img[class='wis-clsbtn-96753']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductPage() {
        return isDisplayed(viewButtonLocator);
    }

//    public void selectSecondPage(){
//        click(secondPageLocator);
//    }

    public void selectProduct(int i) {
        getAllProducts().get(i).click();

    }

    public void closeImage(){
        click(closeImageLocator);
    }
    public void closeCookies(){
        click(closeCookiesLocator);
    }

    private List<WebElement> getAllProducts(){
        return findAll(productNameLocator);
    }
}
