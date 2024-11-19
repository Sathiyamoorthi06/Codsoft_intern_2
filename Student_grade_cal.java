import java.util.*;
public class Student_grade_cal {
     public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        // Step 1: Input marks for each subject
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scn.nextInt();
        
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Collecting marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scn.nextInt();

            // Ensuring the marks are within valid range (0-100)
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid input. Please enter marks between 0 and 100: ");
                marks[i] = scn.nextInt();
            }
            totalMarks += marks[i]; // Summing up marks
        }

        // Step 2: Calculate total marks and average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Step 3: Determine grade based on the average percentage
        String grade = calculateGrade(averagePercentage);

        // Step 4: Display results
        System.out.println("\n=== Result ===");
        System.out.println("Total Marks Obtained: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scn.close();
    }
}
