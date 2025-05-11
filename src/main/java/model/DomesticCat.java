package model;

import enums.Species;

import java.util.Set;

public class DomesticCat extends Pet {
    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.CAT);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am cat. My name is " + super.getNickname() + ". I miss you!");
    }
}
