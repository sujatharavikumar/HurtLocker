import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class GroceryItem {

    String name;
    int numberOfItemOccurances;
    Map<String, Integer> priceAndNumberOfPriceOccuances = new HashMap<>();

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
}
