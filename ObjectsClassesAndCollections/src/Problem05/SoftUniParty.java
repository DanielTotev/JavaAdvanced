package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> guests = new TreeSet<>();
        while (true){
            String guestNumber = reader.readLine();
            if (guestNumber.equals("PARTY")){
                break;
            }
            if (guestNumber.length() == 8)
                guests.add(guestNumber);
        }

        while (true){
            String guest = reader.readLine();
            if (guest.equals("END")){
                break;
            }
            if (guests.contains(guest))
                guests.remove(guest);
        }
        System.out.println(guests.size());
        for (String guest : guests) {
            if (guest.length() > 0)
                System.out.println(guest);
        }
    }
}
