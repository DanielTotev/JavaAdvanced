package Problem08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;


public class EvaluateExpression {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> output = new ArrayDeque<>();
        ArrayDeque<String> operators = new ArrayDeque<>();
        String[] input = reader.readLine().split("\\s+");
        Map<String, Integer> operatorsAndPrecedence = new HashMap<>();
        operatorsAndPrecedence.put("-", 2);
        operatorsAndPrecedence.put("+", 2);
        operatorsAndPrecedence.put("*", 3);
        operatorsAndPrecedence.put("/", 4);
        for (int i = 0; i < input.length; i++) {
            if (isNumber(input[i]) || isLetter(input[i])){
                output.offer(input[i]);
            }else if (operatorsAndPrecedence.containsKey(input[i])){
                if (operators.isEmpty()){
                    operators.push(input[i]);
                    continue;
                }
                try {
                    while (operatorsAndPrecedence.get(operators.peek()) >= operatorsAndPrecedence.get(input[i])){
                        output.offer(operators.pop());
                    }
                    operators.push(input[i]);
                }catch (NullPointerException ex){
                    operators.push(input[i]);
                }
            }else if(input[i].equals("(")){
                operators.push(input[i]);
            }else if (input[i].equals(")")){
                while (!operators.peek().equals("(")){
                    output.offer(operators.pop());
                }
                operators.pop();
            }
        }
        while (operators.size() > 0){
            output.offer(operators.pop());

        }
        String expression = output.toString().replace("[", "").replace("]", "")
                .replace(",", "");
        ArrayDeque<Double> operands = new ArrayDeque<>();
        for (char character : expression.toCharArray()) {
            if (isNumber(String.valueOf(character))){
                operands.push(Double.parseDouble(String.valueOf(character)));
            }else if (character == '+' || character == '-' || character == '*' || character == '/'){
                doMath(operands, character);
            }
        }
        System.out.printf("%.2f", operands.peek());
    }
    private static boolean isNumber(String string){
        try {
            Double.parseDouble(string);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }
    private static boolean isLetter(String string){
        if (string.length() > 1)
            return false;
        if (!Character.isLetter(string.charAt(0))){
            return false;
        }
        return true;
    }
    private static void doMath(ArrayDeque<Double> operands, char operator){
        double rightOperand = operands.pop();
        double leftOperand = operands.pop();
        double result = 0;
        switch (operator){
            case '+':
                result = leftOperand + rightOperand;
                break;
            case '-':
                result = leftOperand - rightOperand;
                break;
            case '*':
                result = leftOperand * rightOperand;
                break;
            case '/':
                result = leftOperand / rightOperand;
                break;
        }
        operands.push(result);
    }

}