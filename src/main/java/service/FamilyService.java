package service;

import model.Family;
import model.Human;
import model.Pet;

import java.util.List;
import java.util.Set;

public interface FamilyService {

    List<Family> getAllFamilies();
    void displayAllFamilies();
    List<Family> getFamiliesBiggerThan(int number);
    List<Family> getFamiliesLessThan(int number);
    int countFamiliesWithMemberNumber(int number);
    List<Family> createNewFamily(Human h1, Human h2);
    boolean deleteFamilyByIndex(int index);
    Family bornChild(Family family,String gender);
    Family adoptChild(Family family,Human human);
    boolean deleteAllChildrenOlderThen(int age);
    int count();
    Family getFamilyById(int id);
    Set<Pet> getPets(int familyIndex);
    boolean addPet(int familyIndex,Pet pet);


}
