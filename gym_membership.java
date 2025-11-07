import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Import GUI

public class gym_membership{
    public static void basicPlan(){
        System.out.println("This is your basic plan. ");
        System.out.println("""
        1. Your first workout is 3 sets of 10 pushups.
        2. Your second workout is 3 sets of 10 squats.
        3. Your third workout is 3 sets of 10 pullups.
        4. Your fourth workout is 3 sets of 10 lunges.
        5. Your fifth workout is 3 sets of 10 situps.
        6. Your sixth workout is 3 sets of 10 deadlifts.
        7. Your seventh workout is 3 sets of 10 burpees.
        8. Your eighth workout is 3 sets of 10 jump squats.
        """);
    }

    public static void premiumPlan(){
        System.out.println("This is your premium plan. ");
        System.out.println("Please answer the following questions before we proceed. ");

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to sign up for this gym membership? ");

        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Great! Let's get started.");
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Please enter your budget: ");
            double budget = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Thank you " + name + " for joining us." + " We are currently " +
                    "finding the right plan for you and a budget of " + budget + ".");

            System.out.println("While finding you the perfect plan, please input your email for login purposes. ");

            System.out.println("Please input your email: ");
            String email = scanner.nextLine();

            System.out.println("Please input your password: ");
            String password = scanner.nextLine();

            String loginInfo = "email: " + email + " \n" + "password: " + password;
            String loginName = "output.txt";

            try(FileWriter fileWriter = new FileWriter(loginName);
                PrintWriter printWriter = new PrintWriter(fileWriter)){

                printWriter.println(loginInfo);
                System.out.println("Login Information has been saved to " + loginName + ".");
                System.out.println("Finding the perfect plan for you... ");

            } catch (IOException e) {
                System.err.println("An error occurred.");
                e.printStackTrace();
            }

            // Give a 5 Second delay to give a finding membership vibe.
            int delayMilliseconds = 5000; // 5 seconds
            try {
                Thread.sleep(delayMilliseconds);
                System.out.println("Your membership plan has been confirmed.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (budget < 400) {
                System.out.println("Sorry, your budget is too low, a basic plan is $400. ");
            }

            if (budget >= 400 && budget <= 1000) {
                System.out.println("You have the basic plan. ");
                basicPlan();

            }

            if (budget > 1000) {
                System.out.println("Your membership plan is the premium plan. ");
            }



        } else {
            System.out.println("Thank you for your time, hope to see you soon! ");
        }


        scanner.close();
    }
}