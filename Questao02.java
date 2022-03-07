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

        // We'll receive inputs from the user as strings for Data verification (program could crash because of type mismatch).
        Scanner input = new Scanner(System.in);
        String answer;

        // Asking the array size to the user. 
        do {
            System.out.println("Informe o tamanho da lista: ");
            answer = input.next();
            if (!AuxFunctions.isInteger(answer) || Integer.parseInt(answer) < 0) System.out.println("Por favor informe um número inteiro positivo!"); 
            AuxFunctions.printSymbol("=", 120); // System.out.print(string * quantity)
        } while (!AuxFunctions.isInteger(answer) || Integer.parseInt(answer) < 0); // Can't assign negative value to array size.
        int size = Integer.parseInt(answer);
        
        // Constructing the array with values informed by the user.
        int nums[] = new int[size];
        for (int n = 0; n < nums.length; n++) {
            do {
                System.out.printf("Informe o %dº valor [somente números inteiros]:%n", n+1);
                answer = input.next();
                if (!AuxFunctions.isInteger(answer)) System.out.println("Por favor informe um número inteiro!"); 
            } while (!AuxFunctions.isInteger(answer)); // This function verifies if the answer is a integer or not.
            nums[n] = Integer.parseInt(answer); // Converting the answer to type int and assigning to array element.
        }
        AuxFunctions.printSymbol("=", 120);  

        // Asking the user for the value which we'll check the difference between array elements.
        do {
            System.out.println("Informe o valor inteiro o qual você gostaria de checar quantos elementos pares do vetor possuem a diferença: ");
            answer = input.next();
            if (!AuxFunctions.isInteger(answer)) System.out.println("Por favor informe um número inteiro!"); 
        } while (!AuxFunctions.isInteger(answer));
        int dif = Integer.parseInt(answer);

        input.close(); // Closing the Scanner, so that there isn't resource leaks.

        // Everytime the condition is fulfilled (pair difference equal to value in "dif"), pairCount will go up and the pair will be stored in an ArrayList.
        int pairCount = 0;
        String newPair = "";
        ArrayList<String> pairList = new ArrayList<String>(); // We use ArrayList because normal array sizes are immutable in Java.

        // Looping through the array twice. We compare the value of outside loop with every element in the array (inside loop).
        for (int i = 0; i < nums.length; i++) {
            for (int c = 0; c < nums.length; c++) {
                if (i == c) continue; // If the element would compare with itself, the loop will be skipped with "continue".
                else if (nums[i] - nums[c] == dif) { // Checking difference between elements in the array.  
                    pairCount++;                     
                    newPair = "[" + nums[i] + "," + nums[c] + "]"; // [x, y]
                    pairList.add(newPair);
                }                
            }
        }

        // Showing the results to the user.
        AuxFunctions.printSymbol("=", 120); 
        System.out.printf("Lista: %s%n", Arrays.toString(nums));
        System.out.printf("Existem %d pares de elementos com a diferença de %d nesse vetor.%n", pairCount, dif);
        if (pairCount > 0) System.out.print("Os pares são "); // We don't want to print this if there isn't any pair.
        for (int p = 0; p < pairList.size(); p++) { // Looping through our pairList and printing every pair stored inside.
            System.out.print(pairList.get(p) + " ");
        }
        System.out.println();
        AuxFunctions.printSymbol("=", 120); 

    }
    
}