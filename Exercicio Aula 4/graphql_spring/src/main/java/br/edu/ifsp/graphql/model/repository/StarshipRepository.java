package br.edu.ifsp.graphql.model.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.graphql.model.Starship;

public class StarshipRepository {

    private final List<Starship> starships = new ArrayList<>();

    public StarshipRepository() {
        starships.add(new Starship(1, "Millennium Falcon", 34.75));
        starships.add(new Starship(2, "X-Wing", 12.5));
        starships.add(new Starship(3, "TIE Fighter", 8.99));
    }

    public List<Starship> findAllStarships() {
        return starships;
    }

    public Starship findStarshipById(int id) {
        for (Starship s : starships) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void saveStarship(Starship s) {
        starships.add(s);
    }

    public void updateStarship(Starship s) {
        for (int i = 0; i < starships.size(); i++) {
            if (starships.get(i).getId() == s.getId()) {
                starships.set(i, s);
                return;
            }
        }
    }

    public void deleteStarship(int id) {
        starships.removeIf(s -> s.getId() == id);
    }
}

