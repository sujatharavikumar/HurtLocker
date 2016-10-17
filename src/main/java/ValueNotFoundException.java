/**
 * Created by sujatharavikumar on 10/17/16.
 */
public class ValueNotFoundException extends Exception {

    static int counter = 0;

    public ValueNotFoundException(String message){
        super(message);
        counter++;
    }


    public static String formattedErrorOutput(){
        return "Errors\t\t\t\tseen: "+counter+" times";
    }

}
