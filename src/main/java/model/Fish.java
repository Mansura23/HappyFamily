package model;

import enums.Species;

public class Fish extends Pet{
    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.FISH);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am fish. My name is " + super.getNickname() + ". I miss you!");
    }
}
