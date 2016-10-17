import java.util.Map;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class JerksonParser {

    Map<String, GroceryItem> list = new HashMap<String, GroceryItem>();


    public void parseInput(String input) throws ValueNotFoundException{

        String[] itemsArray = input.split("##");
        for (String item : itemsArray){
            parseAsKeyValuePairs(item);
        }
    }


    public void parseAsKeyValuePairs(String item){
        String itemValue;
        String[] keyValuePairs = item.split("[^a-zA-Z0-9:./]");
        //for (String keyValuePair : keyValuePairs){
            //System.out.println(keyValuePair);
        for(int i=0; i<keyValuePairs.length; i=i+4){
            //System.out.println(keyValuePairs[0]);
            try {
                itemValue = checkForNullValue(keyValuePairs[0]);
                //System.out.println(itemValue);
            }
            catch(ValueNotFoundException e){
                itemValue = null;
            }
            //if(!checkIfItemExistsInMap(itemValue)){
                checkSpelling(itemValue);
                System.out.println(itemValue);
                GroceryItem groceryItem = new GroceryItem(itemValue);
                list.put(itemValue, groceryItem);
            //}

        }
    }



    public String checkForNullValue(String value) throws ValueNotFoundException{
        Pattern pattern = Pattern.compile("[^:]*$");
        Matcher hasValue = pattern.matcher(value);
        hasValue.find();

        Matcher noValue = Pattern.compile("^$").matcher(hasValue.group());
        if (noValue.find()){
            throw new ValueNotFoundException();
        }
        //System.out.println(hasValue.group());
        return hasValue.group();
    }



    public boolean checkIfItemExistsInMap(String itemName){
        return list.containsKey(itemName);
    }

//    public void addItemToMap(String keyValuePair){
//        String[] keyValue = keyValuePair.split(":");
//        System.out.println(keyValue[0]);
//        System.out.println(keyValue[1]);
//        //try {
//        if(keyValue[0] != null && keyValue[1]!= null)
//            list.put(keyValue[0], keyValue[1]);
//
//        else if (keyValue[1] == null){
//            list.put(keyValue[0], null);
//        }
        //}
        /*catch(ValueNotFoundException e){
            System.out.println("Value not found");

        }*/
    //}

    public void printItemsInMap(){
        for (Map.Entry<String, GroceryItem> entry : list.entrySet()){
            System.out.println("Key:" +entry.getKey());
            System.out.println("Value:" +entry.getValue());
        }
    }



    public String checkSpelling(String itemName){
        String lowerCaseItem = itemName.toLowerCase();
        Matcher matcher = Pattern.compile("0",Pattern.CASE_INSENSITIVE).matcher(itemName);
        matcher.find();
        return  matcher.replaceAll("o");
    }



}
