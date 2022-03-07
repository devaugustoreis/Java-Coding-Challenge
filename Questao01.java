import java.util.Arrays; // Importing the library to use Array class and its methods.
import java.util.Scanner; // We'll instantiate Scanner class so that we can receive inputs from the user.

/**
 * # QUESTÃO 01
 * A mediana de uma lista de números é basicamente o elemento que se encontra no
 * meio da lista após a ordenação. Dada uma lista de números com um número ímpar 
 * de elementos, desenvolva um algoritmo que encontre a mediana.
 */

/**
 *
 * @author AugustoReis
 */
public class Questao01 {

    public static void main(String[] args) {

        // We'll receive inputs from the user as strings for Data verification (program could crash because of type mismatch).
        Scanner input = new Scanner(System.in);
        String answer; 

        // Asking the array size to the user. Only odd values are accepted.
        int size = 0;
        boolean odd = false;
        while (!odd) {
            System.out.println("Informe o tamanho da lista [somente números ímpares]: ");
            answer = input.next();
            if (AuxFunctions.isInteger(answer) && Integer.parseInt(answer) % 2 == 1) { // Checking if the input is a odd number.
                size = Integer.parseInt(answer);
                odd = true; 
            } else System.out.println("Por favor informe um número ímpar e maior do que 0.");
            AuxFunctions.printSymbol("=", 60); // System.out.print(string * quantity)
        }
        
        // Constructing the array with values informed by the user.
        float nums[] = new float[size];
        for (int n = 0; n < nums.length; n++) {
            do {
                System.out.printf("Informe o %dº valor [somente números]:%n", n+1);
                answer = input.next();
                if (!AuxFunctions.isNumber(answer)) System.out.println("Por favor informe um número!"); 
            } while (!AuxFunctions.isNumber(answer)); // This function verifies if the answer is a number or not.
            nums[n] = Float.parseFloat(answer); // Converting the answer to type float and assigning to array element.
        }
        
        input.close(); // Closing the Scanner, so that there isn't resource leaks.
        
        // Ordering the array, calculating which index value is the median and then showing it to the user.
        AuxFunctions.printSymbol("=", 60); 
        System.out.printf("Lista Original: %s%n", Arrays.toString(nums));
        Arrays.sort(nums); // Ordering the array in ascending order.
        int median = nums.length / 2;
        System.out.printf("Lista Ordenada: %s%n", Arrays.toString(nums));
        System.out.printf("A mediana é %s%n", nums[median]);
        AuxFunctions.printSymbol("=", 60);

    } 
    
}