package com.example.assignment2tester;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DraftController implements Initializable {

    @FXML
    private Button addToLeagueButton;

    @FXML
    private Button addToTeamButton;

    @FXML
    private Label availablePositionsLabel;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextFIeld;

    @FXML
    private ListView<Player> leagueListView;

    @FXML
    private ChoiceBox<String> positionsChoiceBox;

    @FXML
    private Button removeFromTeamButton;

    @FXML
    private ListView<Player> teamListView;

    private League league;

    private Player player;

    private Team team;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        league = new League();
        team = new Team();
        ObservableList<String> positions = FXCollections.observableArrayList(Player.getValidPositions());
        positionsChoiceBox.setItems(positions);
        positionsChoiceBox.getSelectionModel().selectFirst();
    }



    @FXML
    void addToLeague(ActionEvent event) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextFIeld.getText();
        String position = positionsChoiceBox.getValue();
        if (!firstName.isEmpty() && !lastName.isEmpty() && position != null) {
            Player player = new Player(firstName, lastName, position);
            league.addPlayer(player);
            leagueListView.getItems().add(player);
            firstNameTextField.clear();
            lastNameTextFIeld.clear();
        }
    }

    @FXML
    void addToTeam(ActionEvent event) {
        Player player = leagueListView.getSelectionModel().getSelectedItem();
        if (player != null) {
            if (team.getTeam().size() < 5 && team.getAvailablePositions().contains(player.getPosition())) {
                team.addPlayer(player);
                updateTeamDisplay();
                league.removePlayer(player);
                updateLeagueDisplay();
            }
        }
    }

    private void updateTeamDisplay() {
        List<String> availablePositions = team.getAvailablePositions();
        availablePositionsLabel.setText(availablePositions + " ");
        teamListView.getItems().clear();
        teamListView.getItems().addAll(team.getTeam());
    }

    private void updateLeagueDisplay() {
        leagueListView.getItems().clear();
        leagueListView.getItems().addAll(league.getLeague());
    }

    @FXML
    void removeFromTeam(ActionEvent event) {
        Player teamPlayerSelected = teamListView.getSelectionModel().getSelectedItem();
        if (teamPlayerSelected != null) {
            team.removePlayer(teamPlayerSelected);
            league.addPlayer(teamPlayerSelected);
        }
        updateTeamDisplay();
        updateLeagueDisplay();
    }

}


