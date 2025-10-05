package br.edu.ifsp.graphql.controller;

import br.edu.ifsp.graphql.model.service.SearchService;
import br.edu.ifsp.graphql.model.service.StarshipService;
import br.edu.ifsp.graphql.model.service.DroidService;
import br.edu.ifsp.graphql.model.service.HumanService;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;

@Controller
public class StarWarController {

    private final HumanService humanService = new HumanService();
    private final DroidService droidService = new DroidService();
    private final StarshipService starshipService = new StarshipService();
    private final SearchService searchService = new SearchService();

    @QueryMapping
    public Character hero(@Argument Episode episode) {
        return new Droid(
                "2001",
                "R2-D2",
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
                List.of(),
                "Astromech"
        );
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return new Droid(
                id,
                "R2-D2",
                List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI),
                List.of(),
                "Astromech"
        );
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        return List.of(
                new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech"),
                new Human("1001", "Luke", List.of(), List.of(), 1.72),
                new Starship(3000, "Millennium Falcon", 1000.0)
        );
    }

    @MutationMapping
    public Review createReview(@Argument Episode episode, @Argument ReviewInput review) {
        return new Review(review.getStars(), review.getCommentary());
    }

    @QueryMapping
    public List<Human> humans() {
        return humanService.getAllHumans();
    }

    @QueryMapping
    public List<Starship> starships() {
        return starshipService.getAllStarships();
    }

    @QueryMapping
    public Character character(@Argument String id) {
        return searchService.findCharacterById(id);
    }

    @MutationMapping
    public Human createHuman(@Argument String id, @Argument String name, @Argument Double height) {
        return humanService.createHuman(id, name, height);
    }

    @MutationMapping
    public Droid createDroid(@Argument String id, @Argument String name, @Argument String primaryFunction) {
        return droidService.createDroid(id, name, primaryFunction);
    }

    @MutationMapping
    public Starship createStarship(@Argument int id, @Argument String name, @Argument Double length) {
        return starshipService.createStarship(id, name, length);
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {
        Human h = humanService.getHumanById(characterId);
        if (h != null) {
            humanService.addFriend(characterId, friendId);
            return h;
        }

        Droid d = droidService.getDroidById(characterId);
        if (d != null) {
            droidService.addFriend(characterId, friendId);
            return d;
        }

        return null;
    }
}