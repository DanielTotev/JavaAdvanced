package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class HotPotato {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split("\\s+");
        Deque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);
        int removeNumber = Integer.parseInt(reader.readLine());
        int counter = 1;
        while (children.size() > 1){
            if (counter == removeNumber){
                System.out.println("Removed " + children.remove());
                counter = 1;
                continue;
            }
            children.add(children.remove());
            counter++;
        }
        System.out.println("Last is " + children.remove());
    }
}
