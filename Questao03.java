import java.util.Scanner;

/**
 * # QUESTÃO 03
 * Um texto precisa ser encriptado usando o seguinte esquema. Primeiro, os espaços são removidos do texto. 
 * Então, os caracteres são escritos em um grid, no qual as linhas e colunas tem as seguintes regras:
 *
 * sqrt(T) <= linha <= coluna <= sqrt(T)
 *
 * Considere T, como o tamanho do texto.
 * Se certifique de que linhas x colunas >= .
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
        Scanner input = new Scanner(System.in);
        System.out.println("Informe a mensagem que deseja criptografar: ");
        String s = input.nextLine();    
        
        s = s.replaceAll("\\s", ""); // Removing all whitespaces.
        
        int stringSize = s.length();
        int gridSize = (int) Math.ceil(Math.sqrt(stringSize)); // Calculating the square root of string size, rouding it up and storing in gridSize variable.
        System.out.println(gridSize);
        int index = 0;
        
        char grid[][] = new char[gridSize][gridSize];
        for (int l = 0; l < gridSize; l++) {
            for (int c = 0; c < gridSize; c++) {
                if (index < stringSize) {
                    grid[l][c] = s.charAt(index);
                    index++;
                }
            }
        }

        for (int l = 0; l < gridSize; l++) {
            for (int c = 0; c < gridSize; c++) {
                System.out.print(grid[c][l]);
            }
        }

        input.close(); // Closing our input, so that we don't have resource leaks.
    }
    
}
