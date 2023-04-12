package com.example.assignment2tester;

import javafx.beans.binding.ListBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    private ArrayList<Player> team;

    public Team() {
        team = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        team.add(player);

    }

    public void removePlayer(Player player) {
        team.remove(player);
    }

    public List<String> getAvailablePositions() {
        List<String> availablePositions = new ArrayList<>(Arrays.asList("C", "F", "F", "G", "G"));
        for (Player player : team) {
            availablePositions.remove(player.getPosition());
        }
        return availablePositions;
    }

    public List<String> getPositions() {
        List<String> positions = new ArrayList<>();
        for (Player player : team) {
            positions.add(player.getPosition());
        }
        return positions;
    }

    public List<Player> getTeam() {
        return team;
    }

}
