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

    public List<String> search(String word) throws NotImplementedException {
        throw new NotImplementedException();
    }
}
