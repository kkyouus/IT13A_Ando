
package Midterm;

import java.io.*;
import java.util.*;

public class Ordering_System {
    
    static Scanner scanner = new Scanner(System.in);
    static final String USERS_FILE = "C:\\Users\\acer\\Documents\\Ordering System\\users.txt";
    static final String HISTORY_FILE = "C:\\Users\\acer\\Documents\\Ordering System\\history.txt";
    static final int SHIFT = 3;

    static String[] items = {"Fried Rice Meal", "Pork Siomai (4 pcs)", "Halo-Halo"};
    static int[] prices = {110, 40, 70};

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\n=== WELCOME TO THE RESTAURANT ORDERING SYSTEM! ===");
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                register();
            } else if (choice == 2) {
                if (login()) {
                    orderMenu();
                }
            } else {
                break;
            }
        }
    }

    static void register() throws IOException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String encrypted = encrypt(password);

        FileWriter fw = new FileWriter(USERS_FILE, true);
        fw.write(username + "," + encrypted + "\n");
        fw.close();

        FileWriter history = new FileWriter(HISTORY_FILE, true);
        history.write("New user registered: " + username + ", " + encrypted + "\n");
        history.close();

        System.out.println("Account created successfully!");
    }

    static boolean login() throws IOException {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2 && parts[0].equals(username)) {
                String decrypted = decrypt(parts[1]);
                if (decrypted.equals(password)) {
                    System.out.println("Login successful!\n");
                    return true;
                }
            }
        }
        System.out.println("Invalid credentials.\n");
        return false;
    }

    static void orderMenu() throws IOException {
        int[] quantities = new int[items.length];
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " - Php " + prices[i]);
            }
            System.out.println((items.length + 1) + ". Exit");
            System.out.print("Choose item: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= items.length) {
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                quantities[choice - 1] += qty;
            }
        } while (choice != items.length + 1);

        int total = 0;
        System.out.println("\n--- ORDER SUMMARY ---");
        FileWriter history = new FileWriter(HISTORY_FILE, true);
        history.write("Order placed:\n");

        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                int itemTotal = quantities[i] * prices[i];
                System.out.println(items[i] + " x " + quantities[i] + " = Php " + itemTotal);
                history.write(items[i] + " x " + quantities[i] + " = Php " + itemTotal + "\n");
                total += itemTotal;
            }
        }
        System.out.println("Total Bill: Php " + total);
        history.write("Total Bill: Php " + total + "\n\n");
        history.close();
    }

    static String encrypt(String password) {
        StringBuilder sb = new StringBuilder();
        for (char c : password.toCharArray()) {
            sb.append((char)(c + SHIFT));
        }
        return sb.toString();
    }

    static String decrypt(String encrypted) {
        StringBuilder sb = new StringBuilder();
        for (char c : encrypted.toCharArray()) {
            sb.append((char)(c - SHIFT));
        }
        return sb.toString();
    }
    
}
