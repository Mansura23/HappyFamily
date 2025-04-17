package model;

public class Fish extends Pet{
    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.FISH);
    }

    @Override
    public void eat() {

    }

    @Override
    public void respond() {

    }
}
