package controller;

import model.*;
import service.FamilyService;

import java.util.List;
import java.util.Set;

public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    public List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int number) {
        if (number < 0) {
            return null;
        }
        return familyService.getFamiliesBiggerThan(number);
    }

    public List<Family> getFamiliesLessThan(int number) {
        if (number < 0) {
            return null;
        }
        return familyService.getFamiliesLessThan(number);
    }
    public int countFamiliesWithMemberNumber(int memberNumber) {
        if (memberNumber < 0) {
            return 0;
        }
        return familyService.countFamiliesWithMemberNumber(memberNumber);
    }
    public Family createNewFamily(Human mother, Human father) {
        if (mother == null || father == null) {
            return null;
        }
        return familyService.createNewFamily(mother, father);

    }

    public Boolean deleteFamilyByIndex(int index) {

        if (index < 0) {
            return false;
        }
        return familyService.deleteFamilyByIndex(index);
    }
    public Family bornChild(Family family, String masculine, String feminine) {
        return familyService.bornChild(family, masculine, feminine);

    }
    public Family adoptChild(Family family, Human child) {

        return familyService.adoptChild(family, child);
    }

    public Boolean deleteAllChildrenOlderThen(int age) {
        return familyService.deleteAllChildrenOlderThen(age);

    }

    public int count(int number) {

        return familyService.count();
    }

    public Family getFamilyById(int index) {
        return familyService.getFamilyById(index);
    }

    public Set<Pet> getPets(int index) {
        return familyService.getPets(index);
    }

    public Boolean addPet(int index, Pet pet) {

        return familyService.addPet(index, pet);
    }

}
