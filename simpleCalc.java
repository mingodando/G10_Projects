import javax.swing.*;
import java.util.Scanner;

public class simpleCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number or type 'done' to finish");
        double sum = 0;
        while (true) {
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                System.out.println("The sum is: " + sum);
                break;
            }
            try {
                sum += Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input  a number or 'done'.");
            }
        }
        scanner.close();
    }
}
