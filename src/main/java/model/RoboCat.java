package model;

import enums.Species;

import java.util.Set;

public class RoboCat extends Pet{
    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am robocat. My name is " + super.getNickname() + ". I miss you!");
    }
}
