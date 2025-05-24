package service;

import model.Family;
import model.Human;
import model.Pet;

import java.util.List;

public interface FamilyService {

    List<Family> getAllFamilies();
    void displayAllFamilies();
    List<Family> getFamiliesBiggerThan(int number);
    List<Family> getFamiliesLessThan(int number);
    int countFamiliesWithMemberNumber(int number);
    Family createNewFamily(Human h1, Human h2);
    boolean deleteFamilyByIndex(int index);
    public Family bornChild(Family family, String maleName,String femaleName);
    Family adoptChild(Family family,Human human);
    boolean deleteAllChildrenOlderThen(int age);
    int count();
    Family getFamilyById(int id);
    List<Pet> getPets(int familyIndex);
    boolean addPet(int familyIndex,Pet pet);


}
