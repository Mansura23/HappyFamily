package model;

import enums.Species;

import java.util.List;
import java.util.Set;

public class Fish extends Pet{
    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am fish. My name is " + super.getNickname() + ". I miss you!");
    }
}
