package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class TruckTour {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOFPumps = Integer.parseInt(reader.readLine());
        ArrayDeque<String> allPumps = new ArrayDeque<>();
        for (int i = 0; i < numberOFPumps; i++) {
            allPumps.addLast(reader.readLine());
        }
        int counter = 0;
        while (true){
            boolean isFound = true;
            long ourFuel = 0L;
            for (int i = 0; i < allPumps.size(); i++) {
                String currentPump = allPumps.pop();
                long fuel = Long.parseLong(currentPump.split(" ")[0]);
                long distanceToNextPump = Long.parseLong(currentPump.split(" ")[1]);
                if (ourFuel + fuel < distanceToNextPump){
                    allPumps.addLast(currentPump);
                    isFound = false;
                    break;
                }
                ourFuel += fuel;
                ourFuel -= distanceToNextPump;
            }
            if (isFound){
                System.out.println(counter);
                break;
            }
            counter++;
        }
    }
}
