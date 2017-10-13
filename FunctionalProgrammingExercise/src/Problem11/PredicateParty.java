package Problem11;

import java.util.*;
import java.util.function.Predicate;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        String[] input = scanner.nextLine().split("\\s+");
        Collections.addAll(names, input);
        while (true){
            String command = scanner.nextLine();
            if (command.equals("Party!")){
                break;
            }
            String[] commandTokens = command.split("\\s+");
            String action = commandTokens[0];
            String condition = commandTokens[1];
            Predicate<String> startsWith = n -> n.startsWith(commandTokens[2]);
            Predicate<String> endsWith = n -> n.endsWith(commandTokens[2]);
            if (action.equals("Double")){
                switch (condition) {
                    case "StartsWith":
                        for (int i = 0; i < names.size(); i++) {
                            if (startsWith.test(names.get(i))) {
                                names.add(i + 1, names.get(i));
                                i++;
                            }
                        }
                        break;
                    case "EndsWith":
                        for (int i = 0; i < names.size(); i++) {
                            if (endsWith.test(names.get(i))) {
                                names.add(i + 1, names.get(i));
                                i++;
                            }
                        }
                        break;
                    case "Length":
                        Predicate<String> hasLength = n -> n.length() == Integer.parseInt(commandTokens[2]);
                        for (int i = 0; i < names.size(); i++) {
                            if (hasLength.test(names.get(i))) {
                                names.add(i + 1, names.get(i));
                                i++;
                            }
                        }
                        break;
                }
            }else if(action.equals("Remove")){
                switch (condition) {
                    case "StartsWith":
                        names.removeIf(startsWith);
                        break;
                    case "EndsWith":
                        names.removeIf(endsWith);
                        break;
                    case "Length":
                        Predicate<String> hasLength = n -> n.length() == Integer.parseInt(commandTokens[2]);
                        names.removeIf(hasLength);
                        break;
                }
            }
        }
        if (names.size() == 0){
            System.out.println("Nobody is going to the party!");
        }else {
            StringBuilder partyComers = new StringBuilder();
            for (String name : names) {
                partyComers.append(name);
                partyComers.append(", ");
            }
            partyComers.delete(partyComers.length() - 2, partyComers.length());
            System.out.println(partyComers + " are going to the party!");
        }
    }
}
