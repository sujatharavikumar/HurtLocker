import java.util.Map;


/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class GroceryItem {

    String name;
    public int numberOfItemOccurances;
    public  Map<String, Integer> priceAndNumberOfPriceOccuances;


    public GroceryItem(String name, Map<String, Integer> priceAndNumberOfPriceOccuances) {
        this.name = name;
        this.priceAndNumberOfPriceOccuances = priceAndNumberOfPriceOccuances;
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
        if(priceAndNumberOfPriceOccuances.containsKey(price))
            return true;
        else
            return false;
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
        for(Map.Entry<String,Integer> entry : priceAndNumberOfPriceOccuances.entrySet()){

            stringBuilder.append("Price:\t"+entry.getKey())
                    .append("\t\tseen: "+entry.getValue()+" times\n")
                    .append("-------------\t\t-------------\n");
        }
        return stringBuilder.toString();
    }


}
