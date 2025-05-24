package model;

import enums.Species;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {

    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;
    private Species species = Species.UNKNOWN;

    public Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        setTrickLevel(trickLevel);
        this.habits = habits;
    }

    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel < 0 || trickLevel > 100) {
            throw new IllegalArgumentException("Trick level must be between 0 and 100");
        }
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, trickLevel, species);
    }

    public String prettyFormat()  {
        return "{nickname=" + nickname + ",age=" + age + ",trickLevel=" +
                trickLevel + ",habits=" + habits + ",species=" + species;
    }
}
