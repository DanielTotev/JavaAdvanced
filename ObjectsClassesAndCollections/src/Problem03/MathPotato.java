package Problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] names = reader.readLine().split("\\s+");
        int n = Integer.valueOf(reader.readLine());
        Deque<String> children = new ArrayDeque<>();
        Collections.addAll(children, names);
        int cycle = 1;
        while (children.size() > 1) {
            for (int i = 1; i < n; i++)
                children.offer(children.poll());
            if (isPrime(cycle))
                System.out.println("Prime " + children.peek());
            else
                System.out.println("Removed " + children.poll());


            cycle++;
        }
        System.out.println("Last is " + children.poll());

    }
    private static boolean isPrime(int n) {
        if (n <= 1){
            return false;
        }
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}
