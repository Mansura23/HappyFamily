package service.impl;

import dao.FamilyDao;
import model.Family;
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

}
