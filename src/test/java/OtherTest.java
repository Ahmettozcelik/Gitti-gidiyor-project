import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class OtherTest extends BaseTest{
//    private static ChromeDriver driver;
//
//
//    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://www.gittigidiyor.com/uye-girisi?s=1");
//
//        WebElement accountName = driver.findElement(By.id("L-UserNameField"));
//        accountName.click();
//        accountName.sendKeys("Ameet61");
//
//        WebElement password = driver.findElement(By.id("L-PasswordField"));
//        password.click();
//        password.sendKeys("Ab6192986");
//
//        Thread.sleep(2000);
//
//        WebElement enterButton = driver.findElement(By.id("gg-login-enter"));
//        enterButton.click();
//
//        Thread.sleep(2000);
//
//
//
//        driver.quit();
//    }

    LogInPage logInPage;
    HomePage homePage;
    ProductsPage productsPage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
//    By logInLocator = new By.ByCssSelector("input[title='Giriş Yap']");


    @Test
    @Order(1)
    public void log_in() throws InterruptedException {
        logInPage = new LogInPage(driver);
        logInPage.logIn("Ameet61","Ab6192986");
        Thread.sleep(3000);

    }
    @Test
    @Order(2)
    public void search_a_product(){
        homePage = new HomePage(driver);
//        Assertions.assertTrue(homePage.isOnHomePage(),"It's not home page.!");
        productsPage = new ProductsPage(driver);
        productsPage.closeCookies();
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isOnProductPage(),"It's not product page.!");

    }

    @Test
    @Order(3)
    public void select_a_product() throws InterruptedException {
        productDetailsPage = new ProductDetailsPage(driver);
        Thread.sleep(2000);
        productsPage.closeImage();
        Thread.sleep(2000);
//        productsPage.selectSecondPage();
        Random rand = new Random();
        int value =rand.nextInt(47);
        productsPage.selectProduct(value);
        Assertions.assertTrue(productDetailsPage.isOnProductDetailsPage(), "It's not a product details page.!");
    }

    @Test
    @Order(4)
    public void add_product_to_cart() throws InterruptedException {
        Thread.sleep(3000);
        productDetailsPage.closeOtherImage();
        productDetailsPage.productCountUp();
        productDetailsPage.addToCart();
        Thread.sleep(3000);
        Assertions.assertTrue(homePage.productCount(), "Couldn't add product.!");
    }

    @Test
    @Order(5)
    public void go_to_cart(){
        cartPage = new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.isEmpty(), " Cart is Empty.!");

    }

    @Test
    @Order(6)
    public void delete_product_to_cart() throws InterruptedException {
        Thread.sleep(4000);
        cartPage.deleteToCart();

    }
}
