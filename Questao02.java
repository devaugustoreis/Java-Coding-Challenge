import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * # QUESTÃO 02
 * Dado um vetor de inteiros n e um inteiro qualquer x. Construa um algoritmo 
 * que determine o número de elementos pares do vetor que tem uma diferença 
 * igual ao valor de x.
 */

/**
 *
 * @author AugustoReis
 */
public class Questao02 {
    
    public static void main(String[] args) {

        // Asking the array size to the user. 
        Scanner input = new Scanner(System.in);
        int size = 0;
        System.out.println("Informe o tamanho da lista: ");
        size = input.nextInt();
        System.out.println("=================================================================================");

        // Constructing the array with values informed by the user.
        int nums[] = new int[size];
        for (int n = 0; n < nums.length; n++) {
            System.out.printf("Informe o %dº valor [somente números inteiros]:%n", n+1);
            nums[n] = input.nextInt();
        }
        System.out.println("=================================================================================");

        // Asking the user for the value which we'll check the difference between array elements.
        System.out.println("Informe o valor inteiro o qual você gostaria de checar quantos elementos pares do vetor possuem a diferença: ");
        int dif = input.nextInt();

        // Creating a counter that will go up everytime a pair of elements fulfills the condition (the difference must be equal the value informed by the user).
        int pairCount = 0;
        // Also creating an empty string to store the pair values that fulfills the condition. We'll store these pairs in an ArrayList. 
        String newPair = "";
        ArrayList<String> pairList = new ArrayList<String>(); // We use ArrayList because normal array sizes are immutable in Java.
        
        // In the outside loop, we loop through every element of our array.
        for (int i = 0; i < nums.length; i++) {
            // In the inside loop, we loop through the array again, because we want to compare outside loop value with all the elements in the array. 
            for (int c = 0; c < nums.length; c++) {
                if (i == c) continue; // If the element would compare with itself, the loop will be skipped with "continue".
                // Comparing Outside and Inside loop values to see if the difference between them matches the value received in "dif" variable.
                else if (nums[i] - nums[c] == dif) { 
                    pairCount++;
                    newPair = "[" + nums[i] + "," + nums[c] + "]";
                    pairList.add(newPair);
                }                
            }
        }

        input.close(); // Closing our input, so that we don't have resource leaks.

        // Showing the results to the user.
        System.out.println("=================================================================================");
        System.out.printf("Lista: %s%n", Arrays.toString(nums));
        System.out.printf("Existem %d pares de elementos com a diferença de %d nesse vetor.%n", pairCount, dif);
        System.out.print("Os pares são ");
        for (int p = 0; p < pairList.size(); p++) { // Looping through our pairList and printing every pair stored inside.
            System.out.print(pairList.get(p) + " ");
        }
        System.out.printf("%n=================================================================================");

    }
    
}
