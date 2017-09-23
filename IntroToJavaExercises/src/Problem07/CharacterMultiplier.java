package Problem07;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next("\\S+");
        String secondWord = scanner.next("\\S+");
        System.out.println(multiplyWords(firstWord, secondWord));
    }
    private static long multiplyWords(String firstWord, String secondWord){
        long sum = 0;
        String longerWord;
        String shorterWord;
        if (firstWord.length() >= secondWord.length()){
            longerWord = firstWord;
            shorterWord = secondWord;
        }else {
            longerWord = secondWord;
            shorterWord = firstWord;
        }
        for (int i = 0; i < shorterWord.length(); i++) {
            sum += (longerWord.charAt(i) * shorterWord.charAt(i));
        }
        for (int i = shorterWord.length(); i < longerWord.length(); i++) {
            sum += longerWord.charAt(i);
        }
        return sum;
    }
}
