package service.impl;

import dao.FamilyDao;
import model.Family;
import model.Human;
import model.Man;
import model.Pet;
import service.FamilyServiceCollection;

import java.time.LocalDateTime;
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
                if(LocalDateTime.now().getYear()-child.getYear()>age){
                    family.deleteChild(child);
                    found=true;
                }
            }
        }
        return  found;
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
