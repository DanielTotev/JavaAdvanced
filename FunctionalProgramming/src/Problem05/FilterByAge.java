package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> peopleAndAge = new LinkedHashMap<>();
        int numberOfInputs = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInputs; i++) {
            String[] inputParams = reader.readLine().split(", ");
            String name = inputParams[0];
            int age = Integer.parseInt(inputParams[1]);
            peopleAndAge.put(name, age);
        }
        String condition = reader.readLine();
        int age = Integer.valueOf(reader.readLine());
        String format = reader.readLine();
        Predicate<Integer> tester = createTester(age, condition);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);
        for (Map.Entry<String, Integer> person : peopleAndAge.entrySet()) {
            if (tester.test(person.getValue())){
                printer.accept(person);
            }
        }
    }
    private static Predicate<Integer> createTester(int age, String condition){
        if (condition.equals("older")){
            return x -> x >= age;
        }
        return x -> x < age;
    }
    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format){
        if (format.equals("name age")){
            return e -> System.out.println(e.getKey() + " - " + e.getValue());
        }else if (format.equals("name")){
            return e -> System.out.println(e.getKey());
        }else {
            return e -> System.out.println(e.getValue());
        }
    }
}
