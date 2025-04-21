
package Midterm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Restaurant_Ordering_System {
    
    private static final String FILE_NAME = "C:\\Users\\acer\\Documents\\Restaurant Ordering System\\users.txt";
    private static final int SHIFT = 3;
    
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            
            System.out.println("Welcome to SAIK Restaurant!");
            System.out.println("Savory, Authentic, and Indulgent Kitchenette ---  Where Flavor Meets Soul");
            
            do {
                System.out.println("\n1. Create Account");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.println("Choose an option(1-3): ");
                choice = scanner.nextInt();
                
                switch (choice){
                    case 1 -> createAccount(scanner);
                    case 2 -> login(scanner);
                    case 3 -> System.out.println("\nThank you for visiting! Come again next time!");
                    default -> System.out.println("That's not in the choices. Please choose again.");
                }
            } while (choice != 3);
        }
    }
    
    private static void createAccount(Scanner scanner){
        scanner.nextLine();
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        
        String encryptedPassword = encryptPassword(password);
        
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)){
            fileWriter.write(username + "," + encryptedPassword + "\n");
            System.out.println("Account successfully created!");
        } catch (IOException e){
            System.out.println("Error saving the account information. Please try again.");
        }
    }
    
    private static void login(Scanner scanner){
        scanner.nextLine();
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            boolean isAuthenticated = false;
            
            while ((line = reader.readLine()) != null){
                String[] credentials = line.split(",");
                
                if (credentials.length < 2) continue;
                
                String storedUsername = credentials[0];
                String storedEncryptedPassword = credentials[1];
                
                if (username.equals(storedUsername)){
                    String decryptedPassword = decryptPassword(storedEncryptedPassword);
                    if (password.equals(decryptedPassword)){
                        isAuthenticated = true;
                        break;
                    }
                }
            }
            
            if (isAuthenticated){
                System.out.println("Login Successful!");
                showOrderingMenu(scanner);
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (IOException e){
            System.out.println("Error reading the user data. Please try again.");
        }
    }
    
    private static void showOrderingMenu(Scanner scanner){
        String[] menuItems = {"Set A: Sinigang, Rice & Pork Adobo, Ensaladang Mangga, Leche Flan, Mango Shake", "Set B: Tinolang Manok, Garlic Fried ice & Grilled Milkfish, Pickled Cucumbers, Buko Pandan, Buko Juice", "Set C: Tokwa't Baboy, Chicken Inasal & Rice, Ginisang Gulay, Halo-halo, Iced Calamansi Juice"};
        double[] itemPrices = {300, 280, 380};
        int[] itemQuantities = new int[menuItems.length];
        int choice;
        
        do {
            System.out.println("\nRestaurant Menu: ");
            for (int i = 0; i < menuItems.length; i++){
            System.out.println((i + 1) + ". " + menuItems[i] + " - ₱" + itemPrices[i]);
            }
            System.out.println((menuItems.length + 1) + ". Exit");
            System.out.print("Choose an item to order (1-" + (menuItems.length + 1) + "): ");
            choice = scanner.nextInt();
            
            if (choice >= 1 && choice <= menuItems.length){
                System.out.print("Enter quantity for " + menuItems[choice - 1] + ": ");
                int quantity = scanner.nextInt();
                itemQuantities[choice - 1] += quantity;
                System.out.println(quantity + " " + menuItems[choice -1] + "(s) added to your order.");
            } else if (choice != menuItems.length + 1){
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != menuItems.length + 1);
        
        double totalBill = 0;
        System.out.println("\nYour Order Summary: ");
        for (int i = 0; i < menuItems.length; i++){
            if (itemQuantities[i] > 0){
                double subtotal = itemQuantities[i] * itemPrices[i];
                totalBill += subtotal;
                System.out.println(menuItems[i] + " x" + itemQuantities[i] + " = ₱" + subtotal + " (Subtotal)");
            }
        }
        System.out.println("Grand Total: ₱" + totalBill);
    }
    
    private static String encryptPassword(String password){
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < password.length(); i++){
            char c = password.charAt(i);
            if (Character.isLetter(c)){
                char shifted = (char) (c + SHIFT);
                encrypted.append(shifted);
            } else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
    
    private static String decryptPassword(String encryptedPassword){
        StringBuilder decrypted = new StringBuilder();
        for (int i = 0; i < encryptedPassword.length(); i++){
            char c = encryptedPassword.charAt(i);
            if (Character.isLetter(c)){
                char shifted = (char) (c - SHIFT);
                decrypted.append(shifted);
            } else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
    
}
