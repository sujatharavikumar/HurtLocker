import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sujatharavikumar on 10/18/16.
 */
public class ValueNotFoundExceptionTest {

    @Test
    public void checkForNullValueTest(){
        JerksonParser jerksonParser = new JerksonParser();
        String actualOutput = null;
        try {
            actualOutput = jerksonParser.checkForNullValue("naMe:");
        }catch(ValueNotFoundException e){
            Assert.assertTrue(e.getMessage().equals("Value not found"));
        }
    }

}
