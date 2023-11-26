import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ROCKBASTPage {
    private WebDriver driver;

    public ROCKBASTPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[5]")
    private WebElement catalogButton;

    @FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[5]/div/div/div/div[1]/div[3]/a[2]")
    private WebElement targetElement;

    @FindBy(xpath = "//*[@id=\"input-sort\"]")
    private WebElement priceSelect;

    @FindBy(xpath = "//*[@id=\"input-sort\"]/option[5]")
    private WebElement priceIncrease;

    @FindBy(xpath = "//*[@id=\"button-cart_17159\"]")
    private WebElement addtocartButton;

    @FindBy(xpath = "//*[@id=\"options-popup-input-option25836\"]")
    private WebElement sizeSelect;
    @FindBy(xpath = "//*[@id=\"options-popup-input-option25836\"]/option[3]")
    private WebElement sizeSelect1;
    @FindBy(xpath = "//*[@id=\"popup-checkout-button\"]")
    private WebElement addtocartButton1;
    @FindBy(xpath = "//*[@id=\"res-products\"]/div[1]/div[1]/div/div[1]/a/div[3]/div/div[1]")
    private WebElement movetoAdd;
    @FindBy(xpath = "//*[@id=\"popup-cart-inner\"]/div[4]/form/div/div/div[4]/div/input[3]")
    private WebElement inputCount;
    @FindBy(xpath = "//*[@id=\"cart-popup\"]")
    private WebElement cartClick;



    @Test
    public void SortingOfGoodsByPrice() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogButton).perform();
        targetElement.click();
        priceSelect.click();
        priceIncrease.click();
        Thread.sleep(2000);
    }

    public void AddingGoodToCart(String count) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(catalogButton).perform();
        targetElement.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", movetoAdd);
        actions.moveToElement(movetoAdd).perform();
        addtocartButton.click();
        Thread.sleep(1000);
        sizeSelect.click();
        Thread.sleep(1000);
        sizeSelect1.click();
        addtocartButton1.click();
        Thread.sleep(2000);
        inputCount.sendKeys(count);
        Thread.sleep(1000);
        cartClick.click();
    }

}
