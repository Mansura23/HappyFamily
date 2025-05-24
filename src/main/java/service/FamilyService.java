package service;

import model.Family;
import model.Human;
import model.Pet;

import java.util.List;

public interface FamilyService {

    List<Family> getAllFamilies();
    List<Family> displayAllFamilies();
    List<Family> getFamiliesBiggerThan();
    List<Family> getFamiliesLessThan();
    List<Family> countFamiliesWithMemberNumber();

    List<Family> createNewFamily(Human h1, Human h2);
    boolean deleteFamilyByIndex(int index);
    Family bornChild(Family family,String gender);
    Family adoptChild(Family family,Human human);
    boolean deleteAllChildrenOlderThen(int age);
    int count();
    Family getFamilyById(int id);
    List<Pet> getPets(int familyIndex);
    boolean addPet(int familyIndex,Pet pet);


}
