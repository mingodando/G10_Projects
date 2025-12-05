import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class bankingSystem {

    public static int pinMain(String filename) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN (4 digits): ");
        String pin = scanner.nextLine();
        checkInputPin(pin);
        scanner.close();
        return Integer.parseInt(pin);
    }

    public static void checkInputPin(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN. PIN must be 4 digits long.");
            return;
        }
        System.out.println("PIN set successfully.");
        System.out.println(pin);

    }

    public static void saveData(String name, double initialDeposit, int pin) {
        String fileName = name + ".txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("Account Name: " + name + "\nInitial balance: " + initialDeposit + "\nPin: " + pin);
            writer.close();
            System.out.println("Account data saved successfully.");
            System.out.println(fileName);
        } catch (IOException e) {
            System.out.println("Error saving account data: " + e.getMessage());
        }
    }

    public static void loadData(String filename) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
                System.out.println(content);
            }
        } catch (IOException e) {
            System.out.println("Error loading account data: " + e.getMessage());
        }
    }

    public static void newAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        System.out.println("Account Name: " + name + "\nInitial balance: " + balance);
        String filename = name + ".txt";
        int pin = pinMain(filename);
        saveData(name, balance, pin);
        
    }

    public static void verifyPin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();
        String filename = name + ".txt";

        // Read stored PIN from the file
        String storedPin = null;
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.startsWith("Pin:")) {
                    storedPin = line.substring("Pin:".length()).trim();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Account file not found or cannot be read.");
            return;
        }

        if (storedPin == null) {
            System.out.println("No PIN stored for this account.");
            return;
        }

        int attemptsLeft = 3;
        while (attemptsLeft > 0) {
            System.out.print("Please enter your 4-digit PIN: ");
            String inputPin = scanner.nextLine();

            if (inputPin.length() != 4) {
                System.out.println("PIN must be 4 digits.");
                continue;
            }

            if (inputPin.equals(storedPin)) {
                System.out.println("Access granted.");
                loadData(filename);
                return;
            } else {
                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("Incorrect PIN. Attempts left: " + attemptsLeft);
                } else if (attemptsLeft == 0) {
                    System.out.println("Too many incorrect attempts. Access denied.");
                    return;
                }
            }
        }

        System.out.println("Too many incorrect attempts. Access denied.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Here are a few commands: " +
                " 'new' for creating a new account" +
                " 'load' for loading account data" );
        System.out.print("Enter a command: ");
        String command = scanner.nextLine();

        if (command.equals("new")) {
            newAccount();
        } else if (command.equals("load")) {
            System.out.print("Enter account name: ");
            verifyPin();

        }
    }
}
