package model;

import enums.DayOfWeek;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Objects;

import static model.Family.random;

public abstract class Human {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private int iq;
    private Map<DayOfWeek,String> schedule;
    private Family family;

    public Human() {}

    public Human(String name, String surname, LocalDate birthDate) {
        if (name == null || surname == null || birthDate.getYear() < 1850 || birthDate.getYear() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public Human(String name, String surname, LocalDate birthDate, int iq, Map<DayOfWeek,String> schedule) {
        if (name == null || surname == null || birthDate.getYear() < 1850 || birthDate.getYear() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, LocalDate birthDate, int iq) {
        if (name == null || surname == null || birthDate.getYear() < 1850 || birthDate.getYear() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid arguments");
        }
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
    }
//constructor for adopted children
    public Human(String name,String surname,String dateOfBirth,int iq){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        this.birthDate= LocalDate.parse(dateOfBirth,dateTimeFormatter);
        this.name= name;
        this.surname = surname;
        this.iq= iq;
    }


    public void greetPet(Pet pet) {
        if (pet == null) {
            System.out.println(name + " doesn't have a pet.");
            return;
        }
        System.out.print("Hello");
            System.out.print("," + pet.getNickname());

    }

    public void describePet(Pet pet) {
        if (pet==null) {
            System.out.println(name + " doesn't have a pet.");
            return;
        }
        System.out.print("I have ");
            System.out.print(  pet.getSpecies() + ", he is " + pet.getAge() + " years old, and he is " + isSly(pet) + ".");


    }

    public boolean feedPet(boolean isTime,Pet pet) {
        if (pet == null) {
            System.out.println(name + " doesn't have a pet.");
            return false;
        }
        if (isTime) {
            System.out.println("It is time to fed " + pet.getNickname());
            return true;
        } else {
            int randomNumber = random.nextInt(101);
            if (randomNumber > pet.getTrickLevel()) {
                System.out.println("Hm... I will feed " + pet.getNickname());
                return true;
            } else {
                System.out.println("I think " + pet.getNickname() + " is not hungry.");
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setYear(LocalDate birthDate) {
        if (birthDate.getYear() < 1850 || birthDate.getYear() > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid year");
        }
        this.birthDate = birthDate;
    }
    public String describeAge(){
        Period between = Period.between(LocalDate.now(), birthDate);
        return between.getYears()+" years, "+between.getMonths()+" months, "+between.getDays()+ " days old";

    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq < 0 || iq > 100) {
            throw new IllegalArgumentException("Invalid IQ");
        }
        this.iq = iq;
    }

    public Map<DayOfWeek,String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek,String> schedule) {
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
        return birthDate == human.birthDate && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, family);
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("DD/MM/YYYY");
        String format = birthDate.format(dateTimeFormatter);
        return "Human{" +
                "schedule=" +schedule +
                ", iq=" + iq +
                ", birth date=" + format +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private String isSly(Pet pet) {
        if (pet.getTrickLevel() > 50) {
            return "sly";
        } else {
            return "not sly";
        }
    }

    public String prettyFormat() {
        return "{name='" + name + "',surname='" + surname + "',birthDate='" + birthDate + "',iq=" + iq + ",schedule={FRIDAY=fitness, MONDAY=fitness}}";
    }

}
