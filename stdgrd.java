import java.util.Scanner;

public class stdgrd {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);

        System.out.println("-------STUDENT GRADE CALCULATOR-------");

        // Input: Take marks obtained in each subject
        System.out.print("HOW MANY SUBJECT'S ?: ");
        int Sub = s.nextInt();

        int[] smarks = new int[Sub];
        for (int i = 0; i < Sub; i++) {
            System.out.print("HOW MANY MARK'S IN SUBJECT  " + (i + 1) + ": ");
            smarks[i] = s.nextInt();
        }

        // Calculate Total Marks
        int totmarks = 0;
        for (int marks : smarks) {
            totmarks += marks;
        }

        // Calculate Average Percentage
        double avg = (double) totmarks / Sub;

        // Grade Calculation
        char grade;
        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\n--------YOUR RESULT--------:");
        System.out.println("YOUR TOTAL MARKS OBTAINED : " + totmarks);
        System.out.println("YOUR TOTAL AVERAGE PERCENTILE: " + avg + "%");
        System.out.println("YOUR GRADE " + grade);

    }
}
