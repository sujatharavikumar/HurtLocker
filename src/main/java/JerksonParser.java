import java.util.Map;
import java.util.HashMap;
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
            //System.out.println(currentItem[0]);
            String currentItemName = addItemToMap(currentItem[0]);
            //System.out.println(currentItemName);
            addPriceToGroceryItem(currentItemName,currentItem[1]);
        }
    }



    public String[] splitItems(String input){
        String[] itemsArray = input.split("##");
        return itemsArray;
    }

    public String addItemToMap(String item){
        String itemName;
        try{
            itemName = checkForNullValue(item);

        }catch (ValueNotFoundException e){
            itemName = null;
        }
        //System.out.println(itemName);
        if(itemName!=null){
            itemName = doSpellCheck(itemName);
            //System.out.println(itemName);
            if(!checkIfItemExistsInMap(itemName)){
                GroceryItem groceryItem = new GroceryItem(itemName);
                list.put(itemName,groceryItem);
            }

        }
        return itemName;
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
        String price = null;
        try{
            price = checkForNullValue(itemPrice);
        }
        catch(ValueNotFoundException e){
            itemName = null;
        }

        if(price !=null && itemName != null){
            if(list.get(itemName).checkPriceExists(price)) {
                list.get(itemName).incrementCount(price);

            }

            else
                list.get(itemName).addPrice(price);
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



   /* public void printItemsInMap(){
        for (Map.Entry<String, GroceryItem> entry : list.entrySet()){
            System.out.println("Key:" +entry.getKey());
            System.out.println("Value:" +entry.getValue());
        }
    }*/



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
