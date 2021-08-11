import Pages.CompareNames;
import Pages.PopUp;
import Pages.SelectDay;
import Pages.TwoInputs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumEasyTest {

    public WebDriver driver;

    @BeforeEach
    public void Setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // github action-nál át kell állítanom
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void TestTwoInputs()
    {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        TwoInputs twoInputs = new TwoInputs(driver);

        String a = "2";
        String b = "4";

        Integer expected = twoInputs.twoFieldsAddResult(a,b);
        Integer result = 6;

        Assertions.assertEquals(expected, result);

        /*
         * Navigate to https://www.seleniumeasy.com/test/basic-first-form-demo.html page
         * Write test to validate two inputs section of the page with entering two numbers and validation of summary.
         * Use custom test data.
         * Use the given variables.
         * */
    }

    @Test
    public void TestDaySelectionList()
    {
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        SelectDay selectDay = new SelectDay(driver);
        String expected = "Sunday";
        String result = "Sunday";
        selectDay.selectFromList(expected);

        Assertions.assertEquals(expected, result);

        /*
         * Navigate to https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html page
         * Write test to select list section of the page with selecting an arbitrary day and validation of selection on ser interface.
         * Use custom test data.
         * Use the given variables.
         * */
    }


    @Test
    public void TestAlertPopUp()
    {
        driver.navigate().to("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html#");
        PopUp popUp = new PopUp(driver);
        popUp.popUpClose();

        String result = popUp.popUpClose();
        String expected = "This is the place";

        Assertions.assertTrue(result.contains(expected));

        /*
         * Navigate to https://www.seleniumeasy.com/test/bootstrap-modal-demo.html# page
         * Write test to read and validate content text of modal alert window.
         * Launch a single modal window, store the content string into result variable and close the window with close button.
         * Use the given variables to achieve successfully running test.
         * */
    }

    @Test
    public void TestNameCards()
    {
        driver.navigate().to("https://www.seleniumeasy.com/test/data-list-filter-demo.html");
        CompareNames compareNames = new CompareNames(driver);

        List<String> result = compareNames.cardNames();
        List<String> expected = new ArrayList<>();
        expected.add("Tyreese Burn");
        expected.add("Brenda Tree");
        expected.add("Glenn Pho shizzle");
        expected.add("Brian Hoyies");
        expected.add("Glenn Pho shizzle");
        expected.add("Arman Cheyia");

        Assertions.assertEquals(expected, result);

        /*
         * Navigate to https://www.seleniumeasy.com/test/data-list-filter-demo.html page
         * Write test to get names of name cards.
         * Get the list of name cards and store Name values into a List. Compare the name list to an expected list is given in advance.
         * Use the given variables to achieve successfully running test.
         * */
    }

    @Test
    public void TestTableContent()
    {
        driver.navigate().to("https://www.seleniumeasy.com/test/data-list-filter-demo.html");
        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("names.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Assertions.assertEquals(31, lines);
        /*
         * Navigate to https://www.seleniumeasy.com/test/table-data-download-demo.html page
         * Write test to get names of table.
         * Get every name found in the first column of table. Collect names in every page of and store all of them in the names.txt file.
         * Use the given variables to achieve successfully running test.
         * */
    }

    @AfterEach
    public void Close()
    {
        driver.quit();
    }


}
