import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ROCKBASTest {
    private WebDriver driver;
    private ROCKBASTPage rockbastPage;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("acceptInsecureCerts", true);
        driver = new ChromeDriver(options);
        driver.get("https://rockbastion.by/");
        rockbastPage = new ROCKBASTPage(driver);
    }
    @Test
    public void SortingOfGoodsByPrice() throws InterruptedException {
        rockbastPage.SortingOfGoodsByPrice();
    }
    @Test
    public void AddingGoodToCart() throws InterruptedException{
        rockbastPage.AddingGoodToCart("1000000000000000000000000000");
    }
}
