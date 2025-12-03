import java.util.Scanner;

public class studentGradeCalc {

    static class StudentData {
        String [] names;
        double [] scores;
        int count;

        StudentData(String [] names, double[] scores, int count) {
            this.names = names;
            this.scores = scores;
            this.count = count;
        }
    }

    public static StudentData inputStudentNames() {
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
        return new StudentData(studentNames, studentScores, count);
    }

    public static void maxGrade(double[] studentScores) {
        double maxScore = studentScores[0];
        for (double score : studentScores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }
        System.out.println("Max Score: " + maxScore);
    }

    public static void avgGrade(double[] studentScores, int count) {
        double totalScore = 0;
        for (int i = 0; i < count; i++) {
            totalScore += studentScores[i];
        }
        
        if (count > 0) {
            double avgScore = totalScore / count;
            System.out.println("Student Count: " + count);
            System.out.println("Average Score: " + avgScore);
        } else {
            System.out.println("No scores to calculate average.");
        }
    }

    public static void main(String[] args) {
        StudentData studentData = inputStudentNames();
        maxGrade(studentData.scores);
        avgGrade(studentData.scores, studentData.count);
    }
}