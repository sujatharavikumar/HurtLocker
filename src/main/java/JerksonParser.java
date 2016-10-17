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

        String[] keyValuePairs = item.split("[^a-zA-Z0-9:./]");
        getUniqueItems(keyValuePairs);

    }


    public void getUniqueItems(String[] keyValuePairs){
        String itemValue, itemPrice;

        for(int i=0; i<keyValuePairs.length; i++){
            try {
                itemValue = checkForNullValue(keyValuePairs[0]);
            }
            catch(ValueNotFoundException e){
                itemValue = null;
            }

            itemValue = doSpellCheck(itemValue);

            if(!checkIfItemExistsInMap(itemValue)){
                GroceryItem groceryItem = new GroceryItem(itemValue);
                list.put(itemValue, groceryItem);
                itemPrice = keyValuePairs[1];
                addPriceTGroceryItem(itemValue, itemPrice);
            }

        }
    }


    public void printMap() {
        for(HashMap.Entry<String,GroceryItem> entry : list.entrySet()){
            System.out.println(entry.getValue().formattedOutput());
        }
    }



    public String doSpellCheck(String itemName){

        if (itemName != null) {
            itemName = checkSpelling(itemName);

        }
        if(itemName != null){
            itemName = convertToLowerCase(itemName);

        }
        return itemName;

    }




    public void addPriceTGroceryItem(String itemName, String itemPrice){
        String price = null;
        /*try{
            price = checkForNullValue(itemPrice);
        }
        catch(ValueNotFoundException e){
            itemName = null;
        }
*/
        //if(itemName != null && price!=null){
        System.out.println(list.get(itemName).checkPriceExists(itemPrice));
            if(list.get(itemName).checkPriceExists(itemPrice)) {
                list.get(itemName).incrementCount(itemPrice);
                System.out.println("**");
            }

            else
                list.get(itemName).addPrice(itemPrice);
        //}

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
