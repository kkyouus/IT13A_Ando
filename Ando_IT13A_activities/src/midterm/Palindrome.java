
package midterm;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a word or number: ");
        String input = scanner.nextLine();
        
        String reverse = "";
        
        for (int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i);
        }
        if (input.equalsIgnoreCase(reverse)) {
            System.out.print("It is a Palindrome!");
        } else {
            System.out.print("It is not a Palindrome!");
        }
    }
    
}
