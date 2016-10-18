import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class GroceryItem {

    String name;
    public int numberOfItemOccurances = 0;
    public static Map<String, Integer> priceAndNumberOfPriceOccuances;

    public GroceryItem(String name){
        this.name = name;
        priceAndNumberOfPriceOccuances = new HashMap<>();
        //numberOfItemOccurances = 0;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "name='" + name + '\'' +
                ", numberOfItemOccurances=" + numberOfItemOccurances +
                ", priceAndNumberOfPriceOccuances=" + priceAndNumberOfPriceOccuances +
                '}';
    }


    public void addPrice(String price){
        priceAndNumberOfPriceOccuances.put(price, 1);
        numberOfItemOccurances++;
    }


    public static void printGroceryItemMap() {
        for(HashMap.Entry<String,Integer> entry : priceAndNumberOfPriceOccuances.entrySet()){
            System.out.println(entry.getKey()+": "+entry.getValue());
        }
    }

    public boolean checkPriceExists(String price){
        if(priceAndNumberOfPriceOccuances.containsKey(price))
            return true;
        else
            return false;
        //return priceAndNumberOfPriceOccuances.keySet().contains(price);
    }

    public void incrementCount(String price){
        priceAndNumberOfPriceOccuances.put(price,(priceAndNumberOfPriceOccuances.get(price))+1);
        numberOfItemOccurances++;
    }


    public String formattedOutput(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:\t"+name)
                .append("\t\tseen: "+numberOfItemOccurances+" times\n")
                .append("=============\t\t=============\n");

        for(HashMap.Entry<String,Integer> entry : priceAndNumberOfPriceOccuances.entrySet()){

            stringBuilder.append("Price:\t"+entry.getKey())
                    .append("\t\tseen: "+entry.getValue()+" times\n")
                    .append("-------------\t\t-------------\n");
        }

        return stringBuilder.toString();
    }


}
