package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUp {

    //properties
    public WebDriver driver;
    WebDriverWait wait;
    public final By button = By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a");
    public final By close = By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[1]");
    public final By popUpContent = By.xpath("//*[@id=\"myModal0\"]/div/div/div[3]");

    //constructor
    public PopUp(WebDriver driver) {
        this.driver = driver;
    }

    //methods
    public String popUpClose() {
        wait = new WebDriverWait(driver, 10);
        driver.findElement(button).click();
        String result = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpContent)).getText();
        driver.findElement(close).click();
        return result;
    }
}
