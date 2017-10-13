package Problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] guests = reader.readLine().split("\\s+");
        List<String> copyList = new ArrayList<>();
        copyList.addAll(Arrays.asList(guests));
        //ArrayDeque<List<String>> previousStates = new ArrayDeque<>();
        while (true){
            String command = reader.readLine();
            if (command.equals("Print")){
                for (String s : guests) {
                    if (s != null){
                        System.out.print(s + " ");
                    }
                }
                break;
            }
            String[] cmdParams = command.split(";");
            if (cmdParams[0].equals("Add filter")){
                String condition = cmdParams[1];
                String stringToMatch = cmdParams[2];
                Predicate<String> filter = createFilter(condition, stringToMatch);
                for (int i = 0; i < guests.length; i++) {
                    if (guests[i] != null) {
                        if (filter.test(guests[i])) {
                            guests[i] = null;
                        }
                    }
                }
            }else {
                String condition = cmdParams[1];
                String stringToMatch = cmdParams[2];
                Predicate<String> filter = createFilter(condition, stringToMatch);
                for (int i = 0; i < copyList.size(); i++) {
                    String element = copyList.get(i);
                    if (filter.test(element)){
                        guests[i] = element;
                    }
                }
            }
        }
    }
    private static Predicate<String> createFilter(String condition, String stringToMatch){
        if (condition.equals("Starts with")){
            return x -> x.startsWith(stringToMatch);
        }else if (condition.equals("Ends with")){
            return x -> x.endsWith(stringToMatch);
        }else if (condition.equals("Contains")){
            return x -> x.contains(stringToMatch);
        }else {
            int length = Integer.parseInt(stringToMatch);
            return  x -> x.length() == length;
        }
    }
}
