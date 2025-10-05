package br.edu.ifsp.graphql.model.service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Character;

import java.util.ArrayList;
import java.util.List;

public class DroidService {

    private final List<Droid> droids = new ArrayList<>();

    public DroidService() {
        droids.add(new Droid(
                "2000",
                "R2-D2",
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
                new ArrayList<>(),
                "Astromech"
        ));

        droids.add(new Droid(
                "2001",
                "C-3PO",
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
                new ArrayList<>(),
                "Protocol"
        ));
    }

    public List<Droid> getAllDroids() {
        return droids;
    }

    public Droid getDroidById(String id) {
        for (Droid d : droids) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    public Droid createDroid(String id, String name, String primaryFunction) {
        Droid d = new Droid(
                id,
                name,
                new ArrayList<>(), 
                new ArrayList<>(),
                primaryFunction
        );
        droids.add(d);
        return d;
    }

    public void addFriend(String characterId, String friendId) {
        Droid d = getDroidById(characterId);
        if (d != null) {
            List<Character> friends = d.getFriends();
            if (friends == null) {
                friends = new ArrayList<>();
                d.setFriends(friends);
            }
        }
    }
}

