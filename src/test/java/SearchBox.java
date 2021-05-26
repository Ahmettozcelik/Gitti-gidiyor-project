import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By searchBoxLocator = new By.ByCssSelector("input[type='text']");
    By searchButtonLocator = new By.ByCssSelector("button[type='submit']");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        sendText(searchBoxLocator, text);
        click(searchButtonLocator);
    }
}
