package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TwoInputs {

    //properties
    public WebDriver driver;
    public final By inputA = By.id("sum1");
    public final By inputB = By.id("sum2");
    public final By button = By.xpath("//*[@id=\"gettotal\"]/button");
    public final By displayvalue = By.id("displayvalue");

    //constructor
    public TwoInputs(WebDriver driver){
        this.driver = driver;
    }

    //methods
    public int twoFieldsAddResult(String val1, String  val2){
        driver.findElement(inputA).sendKeys(val1);
        driver.findElement(inputB).sendKeys(val2);
        driver.findElement(button).click();

        return Integer.parseInt(driver.findElement(displayvalue).getText());
    }
}