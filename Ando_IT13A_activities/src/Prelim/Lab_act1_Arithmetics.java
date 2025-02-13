/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prelim;

/**
 *
 * @author acer
 */
import java.util.Scanner;

public class Lab_act1_Arithmetics {
    public static void main(String[] args) {
    
        Scanner s= new Scanner(System.in);
        
        System.out.print("Input first number: ");
        int x = s.nextInt();
        
        System.out.print("Input second number: ");
        int y = s.nextInt();
        
        System.out.print("Input third number: ");
        int z = s.nextInt();
        
        int k = x * y + z;
        int a = (x - y) % z;
        int r = (x + y + z) / 3;
        int l = x * z - (y * y);
        
        System.out.println("10 * 4 + 6 = " + k);
        System.out.println("(10 - 4) % 6 = " + a);
        System.out.println("(10 + 4 + 6) / 3 = " + r);
        System.out.println("10 * 6 - (4 * 4) = " + l);
    }
}
