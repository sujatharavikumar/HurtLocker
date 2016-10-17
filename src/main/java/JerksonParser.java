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
        String itemPrice;
        String[] keyValuePairs = item.split("[^a-zA-Z0-9:./]");

        for(int i=0; i<keyValuePairs.length; i=i+4){
            try {
                itemValue = checkForNullValue(keyValuePairs[0]);
            }
            catch(ValueNotFoundException e){
                itemValue = null;
            }

            if (itemValue != null) {
                itemValue = checkSpelling(itemValue);

            }
            if(itemValue != null){
                itemValue = convertToLowerCase(itemValue);

            }
            if(!checkIfItemExistsInMap(itemValue)){

                System.out.println(itemValue);
                GroceryItem groceryItem = new GroceryItem(itemValue);
                list.put(itemValue, groceryItem);
                itemPrice = keyValuePairs[1];

                addPriceTGroceryItem(itemValue, itemPrice);
            }


        }
    }


    public void addPriceTGroceryItem(String itemName, String itemPrice){
        if(list.get(itemName).checkPriceExists(itemPrice)){
            list.get(itemName).addPrice(itemPrice);
        }

        else
            list.get(itemName).addPrice(itemPrice);
    }




    public String checkForNullValue(String value) throws ValueNotFoundException{
        Pattern pattern = Pattern.compile("[^:]*$");
        Matcher hasValue = pattern.matcher(value);
        hasValue.find();

        Matcher noValue = Pattern.compile("^$").matcher(hasValue.group());
        if (noValue.find()){
            throw new ValueNotFoundException();
        }
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



    public String convertToLowerCase(String itemName){
        String lowerCaseItem = itemName.toLowerCase();
        return lowerCaseItem;
    }


    public String checkSpelling(String itemName){

        Matcher matcher = Pattern.compile("0",Pattern.CASE_INSENSITIVE).matcher(itemName);
        matcher.find();
        return  matcher.replaceAll("o");
    }



}
