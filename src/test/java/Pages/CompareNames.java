package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CompareNames {

    //properties
    public WebDriver driver;
    private final By namesFormTable = By.xpath("//*[@class='searchable-container']//h4");

    //constructor
    public CompareNames(WebDriver driver) {
        this.driver = driver;
    }

    //methods
    public List<String> cardNames() {
        List<String> result = new ArrayList<>();
        List<WebElement> names = driver.findElements(namesFormTable);
        for (WebElement name : names) {
            result.add(name.getText().substring(6));
        }
        return result;
    }
}
