package Problem06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class OverlappingIntervals {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfIntervals = Integer.parseInt(reader.readLine());
        int[][] intervals = new int[numberOfIntervals][2];
        for (int i = 0; i < numberOfIntervals; i++) {
            int[] currentInterval = Arrays.stream(reader.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < intervals[i].length; j++) {
                intervals[i][j] = currentInterval[j];
            }
        }
        boolean overlap = false;
        for (int i = 0; i < intervals.length - 1; i++) {
            if (overlap)
                break;
            for (int j = i + 1; j < intervals.length; j++) {
                if(intervals[i][1]>=intervals[j][0] && intervals[i][0]<=intervals[j][0]){
                    overlap = true;
                    break;
                }
            }
        }
        System.out.println(overlap);
    }
}
