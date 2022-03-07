import java.util.Scanner;

/**
 * # QUESTÃO 03
 * Um texto precisa ser encriptado usando o seguinte esquema. Primeiro, os espaços são removidos do texto. 
 * Então, os caracteres são escritos em um grid, no qual as linhas e colunas tem as seguintes regras:
 *
 * sqrt(T) <= linha <= coluna <= sqrt(T)
 *
 * Considere T, como o tamanho do texto.
 * Se certifique de que linhas x colunas >= T.
 * Se múltiplos grids satisfazem as condições, escolha aquele com a menor área.
 *
 * Escreva um algoritmo que ao receber uma string s, mostre a mensagem encriptada de acordo com as regras descritas.
 */

/**
 *
 * @author AugustoReis
 */
public class Questao03 {

    public static void main(String[] args) {

        // Receiving the message from the user.
        Scanner input = new Scanner(System.in);
        System.out.println("Informe a mensagem que deseja criptografar: ");
        String s = input.nextLine();    
        input.close(); // Closing the Scanner, so that there isn't resource leaks.

        s = s.replaceAll("\\s", ""); // Removing all whitespaces.
        
        int gridSize = (int) Math.ceil(Math.sqrt(s.length())); // Calculating the square root of the string length, rounding it up and storing in gridSize variable.
        int index = 0; // We'll use this index variable to get each character of the original string.
        
        // Making a Grid (Matrix) according to gridSize variable. We'll store the characters first in the lines, and then in the columns.
        char grid[][] = new char[gridSize][gridSize];       // Example String: "tenha um bom dia"
        for (int l = 0; l < gridSize; l++) {                // [t] [e] [n] [h]
            for (int c = 0; c < gridSize; c++) {            // [a] [u] [m] [b]
                if (index < s.length()) {                   // [o] [m] [d] [i]
                    grid[l][c] = s.charAt(index);           // [a] [ ] [ ] [ ]
                    index++;                            
                } else grid[l][c] = ' '; // Char type can't be empty, so we assign whitespaces when there are no more characters in "s" string.
            }
        }

        // Printing the encrypted message to the user. We print all characters in a column before going to the next.
        // Output: [t] [a] [o] [a] + whitespace, and the next column + [e] [u] [m]... (whitespace strings are skipped)
        AuxFunctions.printSymbol("=", 70); 
        System.out.println("Mensagem Criptografada: ");
        for (int c = 0; c < gridSize; c++) {
            for (int l = 0; l < gridSize; l++) {
                if (grid[l][c] != ' ') System.out.print(grid[l][c]); // We don't want to print the whitespaces.
            }
            System.out.print(" "); // Adding a whitespace after each column.
        }
        System.out.println();
        AuxFunctions.printSymbol("=", 70);
         
    }
    
}