/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class Price {
    private String price;

    private int howMany;

    public String getPrice() {
        return price;
    }

    public Price(String price){
        this.price = price;
        increment();
    }

    public void increment(){
        this.howMany++;
    }

    public int getHowMany() {
        return howMany;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price='" + price + '\'' +
                ", howMany=" + howMany +
                '}';
    }
}
