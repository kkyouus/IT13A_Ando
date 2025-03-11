/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Midterm_Palindrome {
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
    
