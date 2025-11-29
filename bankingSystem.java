import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class bankingSystem {
    public static void saveData(String name, double initialDeposit) {
        String fileName = name + ".txt";
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write("Account Name: " + name + "\nInitial balance " + initialDeposit);
            writer.close();
            System.out.println("Account data saved successfully.");
            System.out.print(fileName);
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
        System.out.println("Account Name: " + name + "\nInitial balance " + balance);
        saveData(name, balance);
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
            String accountName = scanner.nextLine();
            String AccountName = accountName + ".txt";
            loadData(AccountName);
        }
    }
}
