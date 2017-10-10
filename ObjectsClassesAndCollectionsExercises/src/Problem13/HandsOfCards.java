package Problem13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Set<String>> peopleAndCards = new LinkedHashMap<>();
        //Map<String, Integer> peopleAndScores  = new LinkedHashMap<>();
        while (true){
            String line = reader.readLine();
            if (line.equals("JOKER")){
                break;
            }
            String[] tokens = line.split(": ");
            String name = tokens[0];
            Set<String> cards = new HashSet<>();
            cards.addAll(Arrays.asList(tokens[1].split(", ")));
            if (!peopleAndCards.containsKey(name)){
                peopleAndCards.put(name, cards);
            }else {
                Set<String> currentPersonCards = peopleAndCards.get(name);
                currentPersonCards.addAll(cards);
                peopleAndCards.put(name, currentPersonCards);
            }
        }
        for (String person : peopleAndCards.keySet()) {
            int score = calculateDeck(peopleAndCards.get(person));
            System.out.printf("%s: %d" + System.lineSeparator(), person, score);
        }
    }
    private static int calculateDeck(Set<String> cards){
        int sum = 0;
        for (String card : cards) {
            sum += calculateCard(card);
        }
        return sum;
    }
    private static int calculateCard(String card){
        String powerType = card.substring(0, card.length() - 1);
        char cardType = card.charAt(1);
        int power = 0;
        if (isNumber(powerType)){
            power = Integer.parseInt(powerType);
        }else {
            switch (powerType){
                case "J":
                    power = 11;
                    break;
                case "Q":
                    power = 12;
                    break;
                case "K":
                    power = 13;
                    break;
                case "A":
                    power = 14;
                    break;
            }
        }
        int typeValue = 0;
        switch (cardType){
            case 'S':
                typeValue = 4;
                break;
            case 'H':
                typeValue = 3;
                break;
            case 'D':
                typeValue = 2;
                break;
            case 'C':
                typeValue = 1;
                break;
        }
        return power * typeValue;
    }
    private static boolean isNumber(String str){
        try {
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
}
