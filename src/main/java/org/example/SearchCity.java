package org.example;

import java.util.Arrays;
import java.util.List;

public class SearchCity {

    private final List<String> cities;

    public SearchCity() {
        cities = Arrays.asList(
                "Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
                "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
                "Hong Kong", "Dubaï", "Rome", "Istanbul"
        );
    }

    public List<String> search(String word) throws NotFoundException {
        if ("*".equals(word)) {
            return cities;
        }
        if (word == null || word.length() < 2) {
            throw new NotFoundException();
        }
        String lowerWord = word.toLowerCase();
        return cities.stream()
                .filter(city -> city.toLowerCase().contains(lowerWord))
                .toList();
    }
}
