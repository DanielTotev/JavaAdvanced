package Problem11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GameOfNames {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfPlayers = Integer.valueOf(reader.readLine());
        Map<String, Integer> playersScores = new HashMap<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = reader.readLine();
            int initialScore = Integer.valueOf(reader.readLine());
            for (int j = 0; j < name.length(); j++) {
                if (name.charAt(j) % 2 == 0){
                    initialScore += name.charAt(j);
                }else {
                    initialScore -= name.charAt(j);
                }
            }
            playersScores.put(name, initialScore);
        }
        int winnerPoints = Integer.MIN_VALUE;
        String winnerName = "";
        for (String playerName : playersScores.keySet()) {
            if (playersScores.get(playerName) > winnerPoints){
                winnerPoints = playersScores.get(playerName);
                winnerName = playerName;
            }
        }
        System.out.println("The winner is " + winnerName + " - " + winnerPoints + " points");
    }
}
