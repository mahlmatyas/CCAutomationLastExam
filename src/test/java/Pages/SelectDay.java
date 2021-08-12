package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDay {

    //properties
    public WebDriver driver;
    public final By selectList = By.xpath("//*[@id=\"select-demo\"]");
    public final By selected = By.className(("selected-value"));

    //constructor
    public SelectDay(WebDriver driver) {
        this.driver = driver;
    }

    //methods
    public void selectDayFromList(String day) {
        Select select = new Select(driver.findElement(selectList));
        select.selectByValue(day);
    }
    public String displayedDay(){
        return driver.findElement(selected).getText().substring(16);
    }
}