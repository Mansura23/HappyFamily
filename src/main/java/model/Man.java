package model;

public class Man extends Human{

    public Man(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public void repairCar() {
        System.out.println("I am repairing the car...");
    }

    @Override
    public void greetPet() {
        System.out.println("Hello, my big boy!");
    }
}
