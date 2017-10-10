package Problem01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        Deque<Integer> openingBracketsIndices = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(')
                openingBracketsIndices.push(i);
            if (expression.charAt(i) == ')'){
                int startIndex = openingBracketsIndices.pop();
                System.out.println(expression.substring(startIndex, i + 1));
            }
        }
    }
}
