package service.impl;

import dao.FamilyDao;
import model.Family;
import model.Human;
import model.Pet;
import service.FamilyServiceCollection;

import java.util.List;

public class FamilyServiceCollectionImpl implements FamilyServiceCollection {

    private final FamilyDao familyDao;

    public FamilyServiceCollectionImpl(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return null;
    }

    public List<Family> displayAllFamilies() {
        return null;
    }

    @Override
    public List<Family> getFamiliesBiggerThan() {
        return List.of();
    }

    @Override
    public List<Family> getFamiliesLessThan() {
        return List.of();
    }

    @Override
    public List<Family> countFamiliesWithMemberNumber() {
        return List.of();
    }

    @Override
    public List<Family> createNewFamily(Human h1, Human h2) {
        return List.of();
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
        return false;
    }

    @Override
    public Family bornChild(Family family, String gender) {
        return null;
    }

    @Override
    public Family adoptChild(Family family, Human human) {
        return null;
    }

    @Override
    public boolean deleteAllChildrenOlderThen(int age) {
        return false;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public Family getFamilyById(int id) {
        return null;
    }

    @Override
    public List<Pet> getPets(int familyIndex) {
        return List.of();
    }

    @Override
    public boolean addPet(int familyIndex, Pet pet) {
        return false;
    }

}
