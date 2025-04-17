package model;

public class Dog extends Pet implements CanFoul{
    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.setSpecies(Species.DOG);
    }

    @Override
    public void respond() {

    }

    @Override
    public void foul() {

    }
}
