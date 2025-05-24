package service.impl;

import dao.FamilyDao;
import model.Family;
import model.Human;
import model.Pet;
import service.FamilyServiceCollection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

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
        AtomicInteger index = new AtomicInteger();
        families.forEach(family -> {
            System.out.print(index + ": ");
            System.out.println(family.toString());
            index.getAndIncrement();
        });
    }

    @Override
    public List<Family> getFamiliesBiggerThan(int number) {
        List<Family> familiesBiggerThanNumber = new ArrayList<>();
        familyDao.getAllFamilies().forEach(family -> {
             if (family.countFamily() > number) familiesBiggerThanNumber.add(family);
        });
        return familiesBiggerThanNumber;
    }

    @Override
    public List<Family> getFamiliesLessThan(int number) {
        List<Family> familiesLessThanNumber = new ArrayList<>();
        familyDao.getAllFamilies().forEach(family -> {
            if (family.countFamily() < number) familiesLessThanNumber.add(family);
        });
        return familiesLessThanNumber;
    }

    @Override
    public int countFamiliesWithMemberNumber(int number) {
        List<Family> familiesWithMemberNumber = new ArrayList<>();
        familyDao.getAllFamilies().forEach(family -> {
            if (family.countFamily() == number) familiesWithMemberNumber.add(family);
        });
        return familiesWithMemberNumber.size();
    }

    @Override
    public Family createNewFamily(Human h1, Human h2) {
        Family family = new Family(h1,h2);
        familyDao.saveFamily(family);
        return  family;
    }

    @Override
    public boolean deleteFamilyByIndex(int index) {
       return familyDao.deleteFamily(index);
    }

    @Override
    public Family bornChild(Family family, String maleName,String femaleName) {
        Human child =family.bornChild(maleName,femaleName);
        familyDao.saveFamily(family);
        return  family;
    }

    @Override
    public Family adoptChild(Family family, Human human) {
        family.addChild(human);
        familyDao.saveFamily(family);
        return  family;
    }

    @Override
    public boolean deleteAllChildrenOlderThen(int age) {
        boolean found=false;
        for(Family family:familyDao.getAllFamilies()){
            for(Human child:family.getChildren()){
                if(LocalDateTime.now().getYear()-child.getBirthDate().getYear()>age){
                    family.deleteChild(child);
                    found=true;
                }
            }
        }
        return  found;
    }

    @Override
    public int count() {
        return familyDao.getAllFamilies().size();
    }

    @Override
    public Family getFamilyById(int id) {
        return familyDao.getFamilyByIndex(id);
    }

    @Override
    public Set<Pet> getPets(int familyIndex) {
        List<Family> families = familyDao.getAllFamilies();
        if (familyIndex >= families.size() || familyIndex < 0) {
            System.out.println("The index is Out of Bound!");
            return null;
        }
        return families.get(familyIndex).getPet();
    }

    @Override
    public boolean addPet(int familyIndex, Pet pet) {
        List<Family> families = familyDao.getAllFamilies();
        if (familyIndex >= families.size() || familyIndex < 0) {
            System.out.println("The index is Out of Bound!");
            return false;
        }
        Set<Pet> petsOfFamily = families.get(familyIndex).getPet();
        int length = petsOfFamily.size();
        petsOfFamily.add(pet);
        if (petsOfFamily.size() == length) {
            System.out.println("The pet have been added recently!");
            return false;
        }
        return true;
    }

}
