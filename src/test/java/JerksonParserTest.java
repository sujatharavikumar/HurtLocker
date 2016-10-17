import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class JerksonParserTest {

    @Test
    public void splitItemsTest(){
        JerksonParser jerksonParser = new JerksonParser();
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
        String[] actualOutput = jerksonParser.splitItems(input);
        Assert.assertTrue(actualOutput.length == 2);

    }

    @Test
    public void parseAsKeyValuePairsTest(){
        JerksonParser jerksonParser = new JerksonParser();
        String input = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##";
        String[] itemsArray = jerksonParser.splitItems(input);
        String[] keyValuePairs = jerksonParser.parseAsKeyValuePairs(itemsArray[0]);
        Assert.assertTrue(keyValuePairs[0].equals("naMe:Milk"));

    }


    @Test
    public void checkForNullValueTest(){
        JerksonParser jerksonParser = new JerksonParser();
        String actualOutput = null;
        try {
            actualOutput = jerksonParser.checkForNullValue("naMe:Milk");
        }catch(ValueNotFoundException e){

        }
        Assert.assertEquals("The value should be Milk","Milk", actualOutput );
    }


    @Test
    public void checkForNullValueNullTest(){
        JerksonParser jerksonParser = new JerksonParser();
        String actualOutput = null;
        try {
            actualOutput = jerksonParser.checkForNullValue("naMe:");
        }catch(ValueNotFoundException e){

        }
        Assert.assertEquals("The value should be Milk",null, actualOutput );
    }


    @Test
    public void doSpellCheckTest(){
        JerksonParser jerksonParser = new JerksonParser();
        String actualOutput = jerksonParser.doSpellCheck("BrEAD");
        String expectedOutput = "bread";
        Assert.assertEquals("The output should be bread", expectedOutput, actualOutput);
    }


    @Test
    public void checkIfItemExistsInMapTest(){
        JerksonParser jerksonParser = new JerksonParser();
        jerksonParser.list.put("milk", new GroceryItem("milk"));
        boolean actualOutput = jerksonParser.checkIfItemExistsInMap("milk");
        boolean expectedOutput = true;
        Assert.assertEquals("The output should be true", expectedOutput, actualOutput);

    }


}
