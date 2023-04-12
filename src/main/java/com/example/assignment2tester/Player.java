package com.example.assignment2tester;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Player {
    private String firstName;
    private String lastName;
    private String position;

    public Player(String firstName, String lastName, String position) {
        setFirstName(firstName);
        setLastName(lastName);
        setPosition(position);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public static List<String> getValidPositions() {
        return Arrays.asList("C", "F", "G");
    }

    public void setFirstName(String firstName) {
        if (firstName.length() < 2) {
            throw new IllegalArgumentException("Names must be at least 2 letters long");
        } else {
            firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName.length() < 2) {
            throw new IllegalArgumentException("Names must be at least 2 letters long");
        } else {
            lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
            this.lastName = lastName;
        }
    }

    public void setPosition(String position) {
        position = position.toUpperCase();
        if (getValidPositions().contains(position)) {
            this.position = position;
        } else {
            throw new IllegalArgumentException("Position must be either C, F, or G");
        }
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + position + ")";
    }

}
