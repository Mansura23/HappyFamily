package model;

import enums.Species;
import interfaces.CanFoul;

import java.util.Set;

public class Dog extends Pet implements CanFoul {
    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.DOG);
    }

    @Override
    public void respond() {
        System.out.println("Hello, owner. I am fish. My name is " + super.getNickname() + ". I miss you!");
    }


}
