import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujatharavikumar on 10/18/16.
 */
public class GroceryItemTest {

    @Test
    public void addPriceTest(){
        Map<String, Integer> priceAndNumberOfPriceOccuances = new HashMap<>();
        GroceryItem groceryItem = new GroceryItem("milk", priceAndNumberOfPriceOccuances);
        groceryItem.addPrice("3.23");
        int actualOutput = priceAndNumberOfPriceOccuances.get("3.23");
        int expectedOutput = 1;
        Assert.assertEquals("The output should be 1", expectedOutput, actualOutput);
    }


    @Test
    public void checkIfPriceExistsTest(){
        Map<String, Integer> priceAndNumberOfPriceOccuances = new HashMap<>();
        priceAndNumberOfPriceOccuances.put("3.23", 2);
        GroceryItem groceryItem = new GroceryItem("milk", priceAndNumberOfPriceOccuances);
        boolean actualOutput = groceryItem.checkPriceExists("3.23");
        boolean expectedOutput = true;
        Assert.assertTrue(expectedOutput == actualOutput);
    }


    public void incrementCountTest


}
