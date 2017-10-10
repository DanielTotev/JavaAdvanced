package Problem05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class RecursiveDrawing {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());
        recursiveDrawing(n);
    }
    private static void recursiveDrawing(int n){
        if (n <= 0){
            return;
        }
        System.out.println(String.join("", Collections.nCopies(n, "*")));
        recursiveDrawing(n - 1);
        System.out.println(String.join("", Collections.nCopies(n, "#")));
    }
}
