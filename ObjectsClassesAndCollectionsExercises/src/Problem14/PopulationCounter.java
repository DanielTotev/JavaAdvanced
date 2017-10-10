package Problem14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> countriesAndCities = new LinkedHashMap<>();
        LinkedHashMap<String, Long> countriesAndPopulation = new LinkedHashMap<>();
        while (true){
            String line = reader.readLine();
            if (line.equals("report")){
                break;
            }
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);
            if (!countriesAndCities.containsKey(country)){
                countriesAndCities.put(country, new LinkedHashMap<>());
            }
            countriesAndCities.get(country).put(city, population);
            if (!countriesAndPopulation.containsKey(country)){
                countriesAndPopulation.put(country, population);
            }else {
                countriesAndPopulation.put(country, countriesAndPopulation.get(country) + population);
            }
        }
//        countriesAndCities.entrySet().stream()
//                .sorted()
        LinkedList<Map.Entry<String, Long>> sortedCountries = new LinkedList<>(countriesAndPopulation.entrySet());
        Collections.sort(sortedCountries, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        for (Map.Entry<String, Long> country : sortedCountries) {
            System.out.printf("%s (total population: %d)" + System.lineSeparator(), country.getKey(), country.getValue());
            LinkedHashMap<String, Long> cities = countriesAndCities.get(country.getKey());
            LinkedList<Map.Entry<String, Long>> sortedCities = new LinkedList<>(cities.entrySet());
            Collections.sort(sortedCities, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            for (Map.Entry<String, Long> sortedCity : sortedCities) {
                System.out.printf("=>%s: %d" + System.lineSeparator(), sortedCity.getKey(), sortedCity.getValue());
            }
        }
    }
}
