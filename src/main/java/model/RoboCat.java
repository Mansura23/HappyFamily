package model;

import enums.Species;

public class RoboCat extends Pet{
    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.ROBOCAT);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am robocat. My name is " + super.getNickname() + ". I miss you!");
    }
}
