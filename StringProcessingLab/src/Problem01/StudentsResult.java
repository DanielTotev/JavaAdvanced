package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StudentsResult {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] studentData = reader.readLine().split("[- ,]+");
        List<Double> grades = new ArrayList<>();
        for (int i = 1; i < studentData.length; i++) {
            grades.add(Double.parseDouble(studentData[i]));
        }
        OptionalDouble average = grades.stream()
                .mapToDouble(Double::valueOf)
                .average();
        System.out.println(String.format
                ("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name","JAdv", "JavaOOP","AdvOOP", "Average" ));
        System.out.println(String.format
                ("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|",
                        studentData[0],grades.get(0), grades.get(1),grades.get(2), average.getAsDouble()));
    }
}
