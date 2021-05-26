import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.naming.directory.DirContext;

public class HomePage extends BasePage{

    SearchBox searchBox;

    By cartCountLocator = new By.ByCssSelector("span[class='notify-user basket-item-count']");
    By cartContainerLocator = new By.ByCssSelector("a[class='header-cart-hidden-link']");
    By checkAllLocator = new By.ByCssSelector("a[title='Tümünü Gör']");
//    By pageNumLocator = new By.ByCssSelector("a[href='/dizustu-laptop-notebook-bilgisayar?k=laptop&sf=2']");


    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    public boolean isOnHomePage() {
        return isDisplayed(checkAllLocator);
    }

    public boolean productCount() {
        return getCartCount() > 0;
    }

    public void goToCart() {
        click(cartContainerLocator);
    }


    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }

//    private int getPageCount(){
//        String pageNum = find(cartCountLocator).getText();
//        return Integer.parseInt(pageNum);
//    }
}
