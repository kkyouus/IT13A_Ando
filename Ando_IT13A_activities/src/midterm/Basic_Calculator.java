
package midterm;

import java.util.Scanner;

public class Basic_Calculator {
    public static int addition (int a, int b) {
        return a + b;
    }
    public static int subtraction (int a, int b) {
        return a - b;
    }
    public static int multiplication (int a, int b) {
        return a * b;
    }
    public static int division (int a, int b) {
        return a / b;
    }
    public static float module (float a, float b) {
        return a/ b* 100;
    }
    
public static void main(String[] args) {
    int result1 = addition(25, 10);
    System.out.println("Sum: " + result1);
    
    int result2 = subtraction(25, 10);
    System.out.println("Difference: " + result2);
    
    int result3 = multiplication(25, 10);
    System.out.println("Product: " + result3);
    
    int result4 = division(25, 10);
    System.out.println("Quotient: " + result4);
    
    float result5 = module (10, 25);
    System.out.println("Module: " + result5);
    }
}
