import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(String id, String pass) throws InterruptedException {
        WebElement accountName = driver.findElement(By.id("L-UserNameField"));
        accountName.click();
        Thread.sleep(1500);
        accountName.sendKeys(id);

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        Thread.sleep(1500);
        password.sendKeys(pass);

        Thread.sleep(1500);

        WebElement enterButton = driver.findElement(By.id("gg-login-enter"));
        enterButton.click();
    }
}
