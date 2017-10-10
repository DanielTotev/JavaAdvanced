package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOFInputs = Integer.parseInt(reader.readLine());
        Map<String, Double> studentsAndGrades = new TreeMap<>();
        for (int i = 0; i < numberOFInputs; i++) {
            String studentName = reader.readLine();
            double[] grades = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double averageGrade = calculateAverageGrade(grades);
            studentsAndGrades.put(studentName, averageGrade);
        }
        for(String studentName: studentsAndGrades.keySet()){
            System.out.println(studentName + " is graduated with " + studentsAndGrades.get(studentName));
        }
    }
    private static double calculateAverageGrade(double[] grades){
        double average = 0.0d;
        for (int i = 0; i < grades.length ; i++) {
            average += grades[i];
        }
        average /= grades.length;
        return average;
    }
}
