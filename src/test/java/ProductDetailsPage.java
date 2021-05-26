import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    By increaseProductLocator = new By.ByCssSelector("li[class='BgTxt Last padding-none']");
    By addToCartLocator = By.id("add-to-basket");
    By closeOtherImageLocator = new By.ByCssSelector("img[class='wis-clsbtn-94970']");



    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductDetailsPage() {
        return isDisplayed(addToCartLocator);
    }

    public void productCountUp(){
        click(increaseProductLocator);
    }

    public void closeOtherImage(){
        click(closeOtherImageLocator);
    }

    public void addToCart() {
        click(addToCartLocator);
    }
}
