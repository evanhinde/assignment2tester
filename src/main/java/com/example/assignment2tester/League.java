package com.example.assignment2tester;

import javafx.beans.binding.ListBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class League {
    private ArrayList<Player> league;

    public League() {
        league = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        league.add(player);
    }

    public void removePlayer(Player player) {
        league.remove(player);
    }

    public List<Player> getLeague() {
        return league;
    }

}
