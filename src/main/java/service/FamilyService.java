package service;

import model.Family;

import java.util.List;

public interface FamilyService {

    List<Family> getAllFamilies();
    List<Family> displayAllFamilies();
    List<Family> getFamiliesBiggerThan();
    List<Family> getFamiliesLessThan();
    List<Family> countFamiliesWithMemberNumber();
}
