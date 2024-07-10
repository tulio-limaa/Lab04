package com.example.lab04;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloController {
    @FXML
    private TextField nameField;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ListView<String> listView;

    @FXML
    private Label errorLabel;

    private ObservableList<String> namesList;

    @FXML
    public void initialize() {
        namesList = FXCollections.observableArrayList();
        listView.setItems(namesList);
    }

    @FXML
    protected void onAddButtonClick() {
        String name = nameField.getText().trim();
        if (validateName(name)) {
            namesList.add(name);
            nameField.clear();
            errorLabel.setText("");
        } else {
            errorLabel.setText("Invalid name. Must: \n Start with uppercase \n Be at least 5 characters long \n Not be empty.");
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        String selectedName = listView.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            namesList.remove(selectedName);
            errorLabel.setText("");
        } else {
            errorLabel.setText("No item selected to delete.");
        }
    }

    private boolean validateName(String name) {
        return name != null && !name.isEmpty() && name.length() >= 5 && Character.isUpperCase(name.charAt(0));
    }
}