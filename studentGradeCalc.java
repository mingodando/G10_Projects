import java.util.Scanner;

public class studentGradeCalc {

    public static void inputStudentNames() {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String[] studentNames = new String[100];
        double[] studentScores = new double[100];

        while (count < studentNames.length) {
            System.out.println("Enter a student name or type 'done' to finish:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                System.out.println("Entered Data:");
                for (int i = 0; i < count; i++) {
                    System.out.println(studentNames[i] + ": " + studentScores[i]);
                }
                break;
            } else {
                System.out.println("Please enter " + input + " score: ");
                double score = scanner.nextDouble();
                scanner.nextLine();

                studentNames[count] = input;
                studentScores[count] = score;

                count++;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello, World!");
        inputStudentNames();

    }
}
