package model;

public class Man extends Human{

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    public void repairCar() {
        System.out.println("I am repairing the car...");
    }

    @Override
    public void greetPet() {
        System.out.println("Hello, my big boy!");
    }
}
