package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Tests de SearchCity")
class SearchCityTest {

    private SearchCity searchCity;

    @BeforeEach
    void setUp() {
        searchCity = new SearchCity();
    }

    @Test
    @DisplayName("Moins de 2 caractères : NotFoundException")
    void shouldThrowNotFoundExceptionWhenSearchTextHasLessThanTwoCharacters() {
        assertThrows(NotFoundException.class, () -> searchCity.search("a"));
        assertThrows(NotFoundException.class, () -> searchCity.search(""));
    }

    @Test
    @DisplayName("Recherche 'Va' : villes commençant par Va")
    void shouldReturnCitiesStartingWithSearchText() throws NotFoundException {
        List<String> result = searchCity.search("Va");

        assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    @DisplayName("Recherche insensible à la casse")
    void shouldBeCaseInsensitive() throws NotFoundException {
        List<String> result = searchCity.search("va");

        assertEquals(List.of("Valence", "Vancouver"), result);
    }

    @Test
    @DisplayName("Recherche partielle 'ape' : Budapest")
    void shouldReturnCitiesWhenSearchTextIsPartOfName() throws NotFoundException {
        List<String> result = searchCity.search("ape");

        assertEquals(List.of("Budapest"), result);
    }

    @Test
    @DisplayName("Recherche '*' : toutes les villes")
    void shouldReturnAllCitiesWhenSearchTextIsAsterisk() throws NotFoundException {
        List<String> result = searchCity.search("*");

        assertEquals(List.of(
                "Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver",
                "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok",
                "Hong Kong", "Dubaï", "Rome", "Istanbul"
        ), result);
    }
}
