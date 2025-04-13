package model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Family implements HumanCreator{

    static {
        System.out.println("Family class loaded");
    }

    protected static Random random = new Random();

    private Human mother;
    private Human father;
    private Pet pet;
    private Human[] children;

    public Family(Human mother, Human father) {
        System.out.println("Family constructor called");
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
    }
    public void addChild(Human child) {
        Human[] children = new Human[this.children .length+1];
        for (int i=0 ; i<this.children.length ; i++) {
            children[i] = this.children[i];
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
        for (int i=0, j=0; i<children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        children = newChildren;
        System.out.println("Child at index " + index + " deleted.");
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
        if (mother != null) count++;
        if (father != null) count++;
        if (children != null) count += children.length;
        if (pet != null) count++;
        System.out.println("Family members: " + count);
        return count;
    }

    public void describePet() {
        System.out.println("I have a " + pet.getSpecies() + ", he is " + pet.getAge() + " years old, he is very " + isSly());
    }

    public boolean feedPet(boolean isFed) {
        int randomNumber = random.nextInt(101);
        if (isFed && randomNumber < getPet().getTrickLevel()) {
            System.out.println("Hm... I will feed " + getPet().getNickname());
            return true;
        } else {
            System.out.println("I think " + getPet().getNickname() + " is not hungry.");
            return false;
        }
    }

    private String isSly() {
        return pet.getTrickLevel() > 50 ? "sly" : "not sly";
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
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
        int randNum = random.nextInt(HumanCreator.boyNames.length+1);
        int randNum2 = random.nextInt(2);
        int iq = (father.getIq() + mother.getIq())/2;
        String name = "";

        if (randNum2 == 0) {
            name += HumanCreator.boyNames[randNum];
            //Schedule deyisecek
            Human man = new Man(name, this.getFather().getSurname(), 2025, iq, new String[][]{}, this);
            addChild(man);
            return man;
        } else {
            //Schedule deyisecek
            Human woman = new Woman(name, this.getFather().getSurname(), 2025, iq, new String[][]{}, this);
            addChild(woman);
            name += HumanCreator.girlNames[randNum];
            return woman;
        }
    }
}
