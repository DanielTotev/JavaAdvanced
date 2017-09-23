package Problem06;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kilometers = Integer.valueOf(scanner.nextLine());
        String timeOfTravelling = scanner.nextLine();
        double travelCost = 0.0d;
        if (kilometers < 20){
            travelCost += 0.70;
            if (timeOfTravelling.equals("day")){
                travelCost += kilometers * 0.79;
            }else if (timeOfTravelling.equals("night")){
                travelCost += kilometers * 0.90;
            }
        }else if (kilometers < 100){
            travelCost += kilometers * 0.09;
        }else {
            travelCost += kilometers * 0.06;
        }
        System.out.printf("%.2f", travelCost);
    }
}
