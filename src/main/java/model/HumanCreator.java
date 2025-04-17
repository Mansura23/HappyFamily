package model;

public interface HumanCreator {

    String[] boyNames = {
            "Liam", "Noah", "Oliver", "Elijah", "James", "William", "Benjamin", "Lucas",
            "Henry", "Alexander", "Jackson", "Sebastian", "Aiden", "Matthew", "Samuel",
            "David", "Joseph", "John", "Wyatt", "Daniel"
    };

    String[] girlNames = {
            "Olivia", "Emma", "Ava", "Sophia", "Isabella", "Mia", "Charlotte", "Amelia",
            "Harper", "Evelyn", "Abigail", "Ella", "Scarlett", "Grace", "Chloe",
            "Aria", "Sofia", "Avery", "Luna", "Nora"
    };

    Human bornChild();

}
