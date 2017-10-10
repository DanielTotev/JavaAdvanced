package Problem07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CollectTheCoins {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[4][];
        for (int row = 0; row < 4; row++) {
            String characters = reader.readLine();
            board[row] = new char[characters.length()];
            for (int col = 0; col < characters.length(); col++) {
                board[row][col] = characters.charAt(col);
            }
        }
        String commands = reader.readLine();
        int wallsCount = 0;
        int currentRow = 0;
        int currentCol = 0;
        int coinsCount = board[currentRow][currentCol] == '$' ? 1 : 0;
        for (int i = 0; i < commands.length(); i++) {
            switch (Character.toLowerCase(commands.charAt(i))){
                case 'v':
                        currentRow++;
                    try {
                        if (board[currentRow][currentCol] == '$' && !(currentCol == 0 && currentRow == 0))
                            coinsCount++;
                    }catch (IndexOutOfBoundsException ex){
                        wallsCount++;
                        currentRow--;
                    }
                    break;
                case '>':
                        currentCol++;
                    try {
                        if (board[currentRow][currentCol] == '$' && !(currentCol == 0 && currentRow == 0))
                            coinsCount++;
                    }catch (IndexOutOfBoundsException ex){
                        wallsCount++;
                        currentCol--;
                    }
                    break;
                case '<':

                        currentCol--;
                    try {
                        if (board[currentRow][currentCol] == '$' && !(currentCol == 0 && currentRow == 0))
                            coinsCount++;
                    }catch (IndexOutOfBoundsException ex){
                        wallsCount++;
                        currentCol++;
                    }
                    break;
                case '^':
                        currentRow--;
                    try {
                        if (board[currentRow][currentCol] == '$' && !(currentCol == 0 && currentRow == 0))
                            coinsCount++;
                    }catch (IndexOutOfBoundsException ex){
                        wallsCount++;
                        currentRow++;
                    }
                    break;
            }

        }
        System.out.println("Coins = " + coinsCount);
        System.out.println("Walls = " + wallsCount);
    }
}
