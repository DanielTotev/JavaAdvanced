package Problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MinerTask {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> miner = new HashMap<>();
        while (true){
            String resource = reader.readLine();
            if (resource.equals("stop")){
                break;
            }
            String quantityAsString = reader.readLine();
            if (quantityAsString.equals("stop")){
                break;
            }
            int quantity = Integer.parseInt(quantityAsString);
            if (!miner.containsKey(resource)){
                miner.put(resource, 0);
            }
            int currentQuantity = miner.get(resource);
            miner.put(resource, currentQuantity + quantity);
        }
        for (String resource : miner.keySet()) {
            System.out.println(resource + " -> " + miner.get(resource));
        }
    }
}
