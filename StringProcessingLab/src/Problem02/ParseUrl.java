package Problem02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseUrl {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String urlAddress = reader.readLine();
        String[] urlData = urlAddress.split("://");
        if (urlData.length != 2){
            System.out.println("Invalid URL");
            return;
        }
        String protocol = urlData[0];
        int slashIndex = urlData[1].indexOf("/");
        if (slashIndex < 0){
            System.out.println("Invalid URL");
            return;
        }
        String server = urlData[1].substring(0, slashIndex);
        String resources = urlData[1].substring(slashIndex + 1);
        System.out.println("Protocol = " + protocol);
        System.out.println("Server = " + server);
        System.out.println("Resources = " + resources);
    }
}
