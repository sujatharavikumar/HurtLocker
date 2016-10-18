import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class JerksonParser {

    Map<String, GroceryItem> list = new HashMap<String, GroceryItem>();

    public void parseInput(String input){
        String[] itemsArray = splitItems(input);
        for (int i=0; i<itemsArray.length; i++){
            String[] currentItem = parseAsKeyValuePairs(itemsArray[i]);
            addItemToMap(currentItem[0], currentItem[1]);
        }
    }


    public String[] splitItems(String input){
        String[] itemsArray = input.split("##");
        return itemsArray;
    }


    public void addItemToMap(String item, String itemPrice){
        Map<String, Integer> priceAndNumberOfPriceOccuances = new HashMap<>();
        String itemName;
        String price = null;
        try{
            itemName = checkForNullValue(item);
            price = checkForNullValue(itemPrice);

        }catch (ValueNotFoundException e){
            itemName = null;
        }
        if(itemName!=null && price!= null){
            itemName = doSpellCheck(itemName);
            if(!checkIfItemExistsInMap(itemName)){
                priceAndNumberOfPriceOccuances.put(price,0);
                GroceryItem groceryItem = new GroceryItem(itemName,priceAndNumberOfPriceOccuances);
                list.put(itemName,groceryItem);
            }
        }
        addPriceToGroceryItem(itemName,price);
    }



    public String[] parseAsKeyValuePairs(String item){

        String[] keyValuePairs = item.split("[^a-zA-Z0-9:./]");
        return keyValuePairs;

    }


    public void printMap() {
        for(HashMap.Entry<String,GroceryItem> entry : list.entrySet()){
            System.out.println(entry.getValue().formattedOutput());
        }
    }


    public void printError(){
        System.out.println(ValueNotFoundException.formattedErrorOutput());
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



    public void addPriceToGroceryItem(String itemName, String itemPrice){

        if(itemPrice !=null && itemName != null){
            if(list.get(itemName).checkPriceExists(itemPrice))
                list.get(itemName).incrementCount(itemPrice);
            else
                list.get(itemName).addPrice(itemPrice);
        }
    }



    public String checkForNullValue(String value) throws ValueNotFoundException{
        Pattern pattern = Pattern.compile("[^:]*$");
        Matcher hasValue = pattern.matcher(value);
        hasValue.find();

        Matcher noValue = Pattern.compile("^$").matcher(hasValue.group());
        if (noValue.find()){
            throw new ValueNotFoundException("Value not found");
        }
        return hasValue.group();
    }



    public boolean checkIfItemExistsInMap(String itemName){
        return list.containsKey(itemName);
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
