package service.impl;

import dao.FamilyDao;
import model.Family;
import model.Human;
import model.Pet;
import service.FamilyServiceCollection;

import java.util.ArrayList;
import java.util.List;

public class FamilyServiceCollectionImpl implements FamilyServiceCollection {

    private final FamilyDao familyDao;

    public FamilyServiceCollectionImpl(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    public void displayAllFamilies() {
        List<Family> families = familyDao.getAllFamilies();
        for (int i=0 ; i<families.size() ; i++){
            System.out.print(i + ": ");
            System.out.println(families.get(i).toString());
        }
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> familiesBiggerThanNumber = new ArrayList<>();
        for (int i=0 ; i<familyDao.getAllFamilies().size() ; i++){
            if(familyDao.getAllFamilies().get(i).countFamily() > number) {
                familiesBiggerThanNumber.add(familyDao.getAllFamilies().get(i));
            }
        }
        return familiesBiggerThanNumber;
    }

    @Override
    public List<Family> getFamiliesLessThan(int number) {
        List<Family> familiesLessThanNumber = new ArrayList<>();
        for (int i=0 ; i<familyDao.getAllFamilies().size() ; i++){
            if(familyDao.getAllFamilies().get(i).countFamily() < number) {
                familiesLessThanNumber.add(familyDao.getAllFamilies().get(i));
            }
        }
        return familiesLessThanNumber;
    }

    @Override
    public int countFamiliesWithMemberNumber(int number) {
        List<Family> familiesWithMemberNumber = new ArrayList<>();
        for (int i=0 ; i<familyDao.getAllFamilies().size() ; i++){
            if(familyDao.getAllFamilies().get(i).countFamily() == number) {
                familiesWithMemberNumber.add(familyDao.getAllFamilies().get(i));
            }
        }
        return familiesWithMemberNumber.size();
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
