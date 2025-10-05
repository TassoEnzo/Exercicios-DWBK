package br.edu.ifsp.graphql.model.service;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.repository.DroidRepository;
import br.edu.ifsp.graphql.model.repository.HumanRepository;

public class SearchService {
    private final HumanRepository humanRepo = new HumanRepository();
    private final DroidRepository droidRepo = new DroidRepository();

    public Character findCharacterById(String id) {
        Human h = humanRepo.findHumanById(id);
        if (h != null) return h;
        Droid d = droidRepo.findDroidById(id);
        if (d != null) return d;
        return null;
    }
}
