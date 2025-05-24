package model;

import interfaces.HumanCreator;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

public class Family implements HumanCreator {

    static {
        System.out.println("New class is being loaded: " + Family.class.getName());
    }

    {
        System.out.println("new object is being created: " + this.getClass().getTypeName());
    }

    protected static Random random = new Random();

    private final Human mother;
    private final Human father;
    private Set<Pet> pets;
    private List<Human> children;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
        mother.setSurname(father.getSurname());
        this.children = new ArrayList<>();
    }

    public Family(Human mother, Human father, Set<Pet> pets) {
        this(mother, father);
        this.pets = pets;
    }

    public void addChild(Human child) {
        if (children.contains(child)) {
            System.out.println("Child already exists: " + child);
            return;
        }
        if (child == null) {
            System.out.println("Child cannot be null");
            return;
        }
        children.add(child);

    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            System.out.println("Invalid index.");
            return false;
        }
        if (children.get(index).getFamily() != null) {
            children.get(index).setFamily(null);
        }
        children.remove(index);
        System.out.println("Child at index " + index + " deleted. Child removed from family.");
        return true;
    }

    public boolean deleteChild(Human child) {

        if (children.isEmpty()) {
            System.out.println("No children to delete.");
            return false;
        }

        if (children.contains(child)) {
            children.remove(child);
            System.out.println("Child " + child.getName() + " deleted.");
            return true;
        } else {
            System.out.println("Child " + child.getName() + " does not exist.");
            return false;
        }


    }

    public int countFamily() {
        int count = 0;
        if (children != null) count += children.size();
        if (pets != null) count += pets.size();
        System.out.println("Count of Family members: " + count + 2);
        return count + 2;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Set<Pet> getPet() {
        return pets;
    }

    public void setPet(Set<Pet> pets) {
        this.pets = pets;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.equals(pets, family.pets) && Objects.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, pets, children);
    }

    @Override
    public Human bornChild() {
        int randNum = random.nextInt(HumanCreator.boyNames.length);
        int randNum2 = random.nextInt(2);
        int iq = (father.getIq() + mother.getIq()) / 2;
        String name = "";
        LocalDate year = LocalDate.now();

        if (randNum2 == 0) {
            name += HumanCreator.boyNames[randNum];
            Human man = new Man(name, this.getFather().getSurname(), year, iq);
            addChild(man);
            return man;
        } else {
            name += HumanCreator.girlNames[randNum];
            Human woman = new Woman(name, this.getFather().getSurname(), year, iq);
            addChild(woman);
            return woman;
        }
    }

    public Human bornChild(String maleName, String femaleName) {

        int randNum2 = random.nextInt(2);
        int iq = (father.getIq() + mother.getIq()) / 2;
        String name = "";
        LocalDate year = LocalDate.now();

        if (randNum2 == 0) {
            name += maleName;
            Human man = new Man(name, this.getFather().getSurname(), year, iq);
            addChild(man);
            return man;
        } else {
            name += femaleName;
            Human woman = new Woman(name, this.getFather().getSurname(), year, iq);
            addChild(woman);
            return woman;
        }
    }


    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", pet=" + pets +
                ", children=" + printChildren() +
                '}';
    }

    private String printChildren() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < children.size(); i++) {
            sb.append(children.get(i).getName());
            if (i < children.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family: \n\t").append("mother: ").append(mother.prettyFormat()).append("\n\t").append("father: ").append(father.prettyFormat())
                .append("\n\t").append("children: ").append("\n\t\t").append(printChildren()).append("\n");
        children.forEach(child -> {
                    if (child instanceof Man) {
                        sb.append("boy: ");
                        sb.append(child.prettyFormat()).append("\n\t\t");
                    } else if (child instanceof Woman) {
                        sb.append("girl: ");
                        sb.append(child.prettyFormat()).append("\n\t\t");
                    }
                });
                sb.append("pets: ");
        pets.forEach(pet -> sb.append(pet.prettyFormat()));
        return sb.toString();
    }
}
