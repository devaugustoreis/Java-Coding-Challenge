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

        // Asking the array size to the user. Only odd values are accepted.
        Scanner input = new Scanner(System.in);
        int size = 0;
        boolean odd = false;
        while (!odd) {
            System.out.println("Informe o tamanho da lista [somente números ímpares]: ");
            size = input.nextInt();
            if (size % 2 == 1) odd = true;
            else System.out.println("Por favor informe um número ímpar e maior do que 0.");
            System.out.println("========================================================");
        }
        
        // Constructing the array with values informed by the user.
        float nums[] = new float[size];
        for (int n = 0; n < nums.length; n++) {
            System.out.printf("Informe o %dº valor [somente números]:%n", n+1);
            nums[n] = input.nextFloat();
        }
        
        input.close(); // Closing our input, so that we don't have resource leaks.
        
        // Ordering the array, calculating which index value is the median and then showing it to the user.
        System.out.println("========================================================");
        System.out.printf("Lista Original: %s%n", Arrays.toString(nums));
        Arrays.sort(nums); // Ordering the array in ascending order.
        int median = nums.length / 2;
        System.out.printf("Lista Ordenada: %s%n", Arrays.toString(nums));
        System.out.printf("A mediana é %s%n", nums[median]);
        System.out.println("========================================================");

    } 
    
}