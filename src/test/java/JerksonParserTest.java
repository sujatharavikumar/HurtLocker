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




}
