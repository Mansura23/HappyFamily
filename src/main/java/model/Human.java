package model;

import java.util.Arrays;
import java.util.Objects;

import static model.Family.random;

public class Human {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public Human() {}

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public void greetPet() {
        System.out.println("Hello, " + family.getPet().getNickname());
    }

    public void describePet() {
        System.out.println("I have a " + family.getPet().getSpecies() + ", he is " + family.getPet().getAge() + " years old, and he is " + isSly() + ".");
    }

    public boolean feedPet(boolean isFed) {
        int randomNumber = random.nextInt(101);
        if (isFed) {
            System.out.println("It is time to fed " + family.getPet().getNickname());
            return true;
        } else {
            if (randomNumber > family.getPet().getTrickLevel()) {
                System.out.println("Hm... I will feed " + family.getPet().getNickname());
                return true;
            } else {
                System.out.println("I think " + family.getPet().getNickname() + " is not hungry.");
                return false;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, family);
    }

    @Override
    public String toString() {
        return "Human{" +
                "schedule=" + Arrays.toString(schedule) +
                ", iq=" + iq +
                ", year=" + year +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String isSly() {
        if (family.getPet().getTrickLevel() > 50) {
            return "sly";
        } else {
            return "not sly";
        }
    }
}
