/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prelim;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Ando_Ligmon_SuposoIT13A {
    
    public static void main(String[] args) {

    
try (Scanner scanner = new Scanner(System.in)) {
             System.out.print("Enter the first number: ");
             int num1 = scanner.nextInt();
             
             System.out.print("Enter the second number: ");
             int num2 = scanner.nextInt();
             
             System.out.print("Enter the third number: ");
             int num3 = scanner.nextInt();
             
             
             int greatest = num1;
             
             if (num2 > greatest) {
                 greatest = num2;
             }
             
             if (num3 > greatest) {
                 greatest = num3;
             }
             
             
             System.out.println("The greatest number is: " + greatest);
         }
    }
}
    

