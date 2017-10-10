package Problem04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class ParkingLot {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> parkingLot = new HashSet<>();
        while (true){
            String input = reader.readLine();
            if (input.equals("END")){
                break;
            }
            String[] inputTokens = input.split(", ");
            String direction = inputTokens[0];
            String car = inputTokens[1];
            if (direction.equals("IN"))
                parkingLot.add(car);
            else
                parkingLot.remove(car);
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }
        System.out.println(parkingLot.toString().replace("]", "")
        .replace("[", "")
        .replace(", ", "\r\n"));
    }
}
