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

    public static void maxGrade(double[] studentScores, int count) {
        if (count == 0) return;
        double maxScore = studentScores[0];
        for (int i = 0; i < count; i++) {
            if (studentScores[i] > maxScore) {
                maxScore = studentScores[i];
            }
        }
        System.out.println("Max Score: " + maxScore);
    }

    public static void minGrade(double[] studentScores, int count) {
        if (count == 0) return;
        double minScore = studentScores[0];
        for (int i = 0; i < count; i++) {
            if (studentScores[i] < minScore) {
                minScore = studentScores[i];
            }
        }
        System.out.println("Min Score: " + minScore);
    }

    public static void avgGrade(double[] studentScores, int count) {
        double totalScore = 0;
        for (double score : studentScores) {
            totalScore += score;
        }

        if (count > 0) {
            double avgScore = totalScore / count;
            System.out.println("Student Count: " + count);
            System.out.println("Average Score: " + avgScore);
        } else {
            System.out.println("No scores to calculate average.");
        }
    }

    public static char getLetterGrade(double score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    public static void printReport(StudentData data) {
        System.out.println("\n--- Class Report ---");
        System.out.printf("%-15s %-10s %-10s%n", "Name", "Score", "Grade");
        System.out.println("-------------------------------------");
        for (int i = 0; i < data.count; i++) {
            System.out.printf("%-15s %-10.2f %-10c%n",
                    data.names[i],
                    data.scores[i],
                    getLetterGrade(data.scores[i]));
        }
        System.out.println("-------------------------------------");
    }

    public static void main(String[] args) {
        //Collect the student data
        StudentData studentData = inputStudentNames();
        // Print out the report
        printReport(studentData);
        // Print out max, min and average grade
        maxGrade(studentData.scores, studentData.count);
        minGrade(studentData.scores, studentData.count);
        avgGrade(studentData.scores, studentData.count);
    }
}
