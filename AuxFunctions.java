/**
 *
 * @author AugustoReis
 */
public class AuxFunctions {

    public static void main(String[] args) {  
    }
    
    // Print something multiple times. Used for Division Lines in the questions.
    public static void printSymbol(String symbol, int quantity) {
        for (int c = 0; c < quantity; c++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    // Checks if the string can be converted to a Float or not.
    public static boolean isNumber(String input) {
        try {  
            Float.parseFloat(input);  
            return true;
        } catch (NumberFormatException e) {
            return false;  
        } 
    }

    // Checks if the string can be converted to a Integer or not.
    public static boolean isInteger(String input) {
        try {  
            Integer.parseInt(input);  
            return true;
        } catch (NumberFormatException e) {
            return false;  
        } 
    }

}
