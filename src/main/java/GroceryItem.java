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
}
