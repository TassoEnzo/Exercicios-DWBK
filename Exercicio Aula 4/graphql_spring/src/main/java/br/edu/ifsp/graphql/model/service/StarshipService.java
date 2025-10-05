package br.edu.ifsp.graphql.model.service;

import java.util.List;

import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.model.repository.StarshipRepository;

public class StarshipService {

    private final StarshipRepository repository = new StarshipRepository();

    public List<Starship> getAllStarships() {
        return repository.findAllStarships();
    }

    public Starship getStarshipById(int id) {
        return repository.findStarshipById(id);
    }

    public Starship createStarship(int id, String name, Double length) {
        Starship s = new Starship(id, name, length);
        repository.saveStarship(s);
        return s;
    }

    public void updateStarship(Starship starship) {
        repository.updateStarship(starship);
    }

    public void deleteStarship(int id) {
        repository.deleteStarship(id);
    }
}