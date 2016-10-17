import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class GroceryItem {

    String name;
    public int numberOfItemOccurances;
    public static Map<String, Integer> priceAndNumberOfPriceOccuances = new HashMap<>();

    public GroceryItem(String name){
        this.name = name;
        priceAndNumberOfPriceOccuances = new HashMap<>();
        numberOfItemOccurances = 0;
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


    public boolean checkPriceExists(String price){
        return priceAndNumberOfPriceOccuances.containsKey(price);
    }

    public void incrementCount(String price){
        priceAndNumberOfPriceOccuances.put(price,priceAndNumberOfPriceOccuances.get(price)+1);
        numberOfItemOccurances++;
    }


    public int getNumberOfOccurence(String price){
        return priceAndNumberOfPriceOccuances.get(price).intValue();
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
