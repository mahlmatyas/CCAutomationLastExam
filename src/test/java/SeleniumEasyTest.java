import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SeleniumEasyTest {

    WebDriver driver;

    @BeforeEach
    public void Setup()
    {
        //Driver initialization, use WebDriverManager with update maven configuration
    }


    @Test
    public void TestTwoInputs()
    {

        /*
         * Navigate to https://www.seleniumeasy.com/test/basic-first-form-demo.html page
         * Write test to validate two inputs section of the page with entering two numbers and validation of summary.
         * Use custom test data.
         * Use the given variables.
         * */

        Integer result = 0;
        Integer expected = 0;

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestDaySelectionList()
    {

        /*
         * Navigate to https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html page
         * Write test to select list section of the page with selecting an arbitrary day and validation of selection on ser interface.
         * Use custom test data.
         * Use the given variables.
         * */

        String result = "";
        String expected = "";

        Assertions.assertEquals(expected, result);
    }



    @Test
    public void TestAlertPopUp()
    {

        /*
         * Navigate to https://www.seleniumeasy.com/test/bootstrap-modal-demo.html# page
         * Write test to read and validate content text of modal alert window.
         * Launch a single modal window, store the content string into result variable and close the window with close button.
         * Use the given variables to achieve successfully running test.
         * */


        String result = "";
        String expected = "";

        Assertions.assertTrue(result.contains(expected));
    }

    @Test
    public void TestNameCards()
    {

        /*
         * Navigate to https://www.seleniumeasy.com/test/data-list-filter-demo.html page
         * Write test to get names of name cards.
         * Get the list of name cards and store Name values into a List. Compare the name list to an expected list is given in advance.
         * Use the given variables to achieve successfully running test.
         * */

        List<String> result = null;
        List<String> expected = new ArrayList<>();
        expected.add("Tyreese Burn");
        expected.add("Brenda Tree");
        expected.add("Glenn Pho shizzle");
        expected.add("Brian Hoyies");
        expected.add("Glenn Pho shizzle");
        expected.add("Arman Cheyia");

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void TestTableContent()
    {

        /*
         * Navigate to https://www.seleniumeasy.com/test/table-data-download-demo.html page
         * Write test to get names of table.
         * Get every name found in the first column of table. Collect names in every page of and store all of them in the names.txt file.
         * Use the given variables to achieve successfully running test.
         * */

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
    }

    @AfterEach
    public void Close()
    {
        //Driver dispose
    }


}
