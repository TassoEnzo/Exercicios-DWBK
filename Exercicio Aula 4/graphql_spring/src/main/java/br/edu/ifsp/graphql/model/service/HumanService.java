package br.edu.ifsp.graphql.model.service;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;

public class HumanService {

    private final List<Human> humans = new ArrayList<>();

    public HumanService() {
        humans.add(new Human(
                "1000",
                "Luke Skywalker",
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
                new ArrayList<>(),
                1.72
        ));

        humans.add(new Human(
                "1001",
                "Leia Organa",
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
                new ArrayList<>(),
                1.60
        ));
    }

    public List<Human> getAllHumans() {
        return humans;
    }

    public Human getHumanById(String id) {
        for (Human h : humans) {
            if (h.getId().equals(id)) {
                return h;
            }
        }
        return null;
    }

    public Human createHuman(String id, String name, Double height) {
        Human h = new Human(
                id,
                name,
                new ArrayList<>(),
                new ArrayList<>(),  
                height
        );
        humans.add(h);
        return h;
    }

    public void addFriend(String characterId, String friendId) {
        Human h = getHumanById(characterId);
        if (h != null) {
            List<Character> friends = h.getFriends();
            if (friends == null) {
                friends = new ArrayList<>();
                h.setFriends(friends);
            }
        }
    }
}
