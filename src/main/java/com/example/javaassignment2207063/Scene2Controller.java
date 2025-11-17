package com.example.javaassignment2207063;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Scene2Controller {
    @FXML
    private TableView<course> table;
    @FXML
    private TableColumn<course, String> nameCol, codeCol, t1Col, t2Col, gradeCol;
    @FXML
    private TableColumn<course, Double> creditCol,gpaCol;



    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        codeCol.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        creditCol.setCellValueFactory(new PropertyValueFactory<>("credit"));
        t1Col.setCellValueFactory(new PropertyValueFactory<>("teacher1"));
        t2Col.setCellValueFactory(new PropertyValueFactory<>("teacher2"));
        gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));
        gpaCol.setCellValueFactory(new PropertyValueFactory<>("gpa"));

        table.setItems(DataStore.courseList);
    }
}
