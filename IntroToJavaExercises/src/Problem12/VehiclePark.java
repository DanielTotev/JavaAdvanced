package Problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VehiclePark {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> cars = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        int soldCount = 0;
        while (true){
            String order = reader.readLine();
            if (order.equals("End of customers!")){
                break;
            }
            String[] orderParams = order.split("\\s+");
            char type = Character.toLowerCase(orderParams[0].charAt(0));
            int seats = Integer.valueOf(orderParams[2]);
            boolean vehicleFound = false;
            String vehicleName = type + "" + seats;
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).equals(vehicleName)){
                    int price = type * seats;
                    System.out.println("Yes, sold for " + price + "$");
                    vehicleFound = true;
                    soldCount++;
                    cars.remove(i);
                    break;
                }
            }
            if (!vehicleFound){
                System.out.println("No");
            }
        }
        System.out.print("Vehicles left: ");
        for (int i = 0; i < cars.size(); i++) {
            if (i == cars.size() - 1){
                System.out.print(cars.get(i));
            }else {
                System.out.print(cars.get(i) + ", ");
            }
        }
        System.out.println();
        System.out.println("Vehicles sold: " + soldCount);
    }
}
