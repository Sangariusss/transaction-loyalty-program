package com.sangarius.transactionloyaltyprogram.model;

public class UserAccount {

    private final int id;
    private final String name;
    private int bonusPoints;

    public UserAccount(int id, String name, int bonusPoints) {
        this.id = id;
        this.name = name;
        this.bonusPoints = bonusPoints;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public void addPoints(int points) {
        this.bonusPoints += points;
    }

    public void subtractPoints(int points) {
        this.bonusPoints -= points;
    }
}
