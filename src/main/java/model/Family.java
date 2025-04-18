package model;

import interfaces.HumanCreator;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
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
    private Pet pet;
    private Human[] children;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
        mother.setSurname(father.getSurname());
        this.children = new Human[0];
    }

    public Family(Human mother, Human father, Pet pet) {
        this(mother, father);
        this.pet = pet;
    }

    public void addChild(Human child) {
        if (Arrays.asList(this.children).contains(child)) {
            System.out.println("Child already exists in the family.");
            return;
        }
        Human[] children = new Human[this.children .length+1];
        IntStream.range(0, this.children.length).forEach(i -> children[i] = this.children[i]);
        if (child.getFamily() == null) {
            child.setFamily(this);
        } else {
            System.out.println("Child already has a family.");
            return;
        }
        children[children.length-1] = child;
        this.children = children;
    }

    public boolean deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            System.out.println("Invalid index.");
            return false;
        }
        Human[] newChildren = new Human[children.length - 1];
        if (children[index].getFamily() != null) {
            children[index].setFamily(null);
        }
        for (int i=0, j=0; i<children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children = newChildren;
        System.out.println("Child at index " + index + " deleted. Child removed from family.");
        return true;
    }

    public boolean deleteChild(Human child) {
        boolean result = false;
        if (children.length == 0) {
            System.out.println("No children to delete.");
            return false;
        }
        Human[] newChildren = new Human[children.length - 1];
        for (int i=0, j=0; i<children.length; i++) {
            if (!children[i].equals(child) && j < newChildren.length) {
                newChildren[j++] = children[i];
            } else if (children[i].equals(child)) {
                System.out.println("Child " + child.getName() + " deleted.");
                result = true;
            }
        }
        if (result) {
            children = newChildren;
        } else {
            System.out.println("Child " + child.getName() + " not found.");
        }
        return result;
    }

    public int countFamily() {
        int count = 0;
        if (children != null) count += children.length;
        if (pet != null) count++;
        System.out.println("Count of Family members: " + count);
        return count + 2;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && pet.getSpecies().equals(family.pet.getSpecies()) && Objects.deepEquals(children, family.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, pet, Arrays.hashCode(children));
    }

    @Override
    public Human bornChild() {
        int randNum = random.nextInt(HumanCreator.boyNames.length);
        int randNum2 = random.nextInt(2);
        int iq = (father.getIq() + mother.getIq())/2;
        String name = "";
        int year = LocalDate.now().getYear();

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

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", pet=" + pet.getSpecies() +
                ", children=" + printChildren() +
                '}';
    }

    private String printChildren() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < children.length; i++) {
            sb.append(children[i].getName());
            if (i < children.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
