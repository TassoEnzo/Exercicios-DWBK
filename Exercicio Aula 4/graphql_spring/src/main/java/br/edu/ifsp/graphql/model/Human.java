package br.edu.ifsp.graphql.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Human implements Character {

    private String id;
    private String name;
    private List<Episode> appearsIn = new ArrayList<>();
    private List<Character> friends = new ArrayList<>();
    private double height;
}
