import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class JerksonParser {

    public void parseInput(String input){

        String[] itemsArray = input.split("##");
        for (String item : itemsArray){
            //System.out.println(item);
            parseAsKeyValuePairs(item);
        }

    }


    public void parseAsKeyValuePairs(String item){
        String[] keyValuePairs = item.split("[^a-zA-Z0-9:./]");
        for (String keyValuePair : keyValuePairs){
            System.out.println(keyValuePair);
        }
    }





}
