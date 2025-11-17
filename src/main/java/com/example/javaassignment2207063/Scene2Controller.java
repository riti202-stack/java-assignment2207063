package com.example.javaassignment2207063;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Scene2Controller {
    @FXML
    private TableView<course> table;
    @FXML
    private TableColumn<course, String> nameCol, codeCol, t1Col, t2Col, gradeCol;
    @FXML
    private TableColumn<course, Double> creditCol;


    @FXML
    private Button calculateGpaButton;
    @FXML
    private Label gpaResultLabel;
    @FXML
    private BorderPane resultContainer;





    @FXML
        public void initialize() {
            nameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));

            codeCol.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
            creditCol.setCellValueFactory(new PropertyValueFactory<>("credit"));

            t1Col.setCellValueFactory(new PropertyValueFactory<>("teacher1"));

            t2Col.setCellValueFactory(new PropertyValueFactory<>("teacher2"));

            gradeCol.setCellValueFactory(new PropertyValueFactory<>("grade"));


            table.setItems(DataStore.courseList);



        }

        @FXML
        public void goBack() throws Exception {
            SceneLoader.switchScene("Scene1.fxml");

        }


    @FXML
    private void onCalculateGpa() {
        double totalGradePoints = 0.0;
        double totalCredits = 0.0;

        for (course c : DataStore.courseList) {
            double credit = c.getCredit();
            double gradePoint = convertGradeToPoints(c.getGrade());

            totalGradePoints += credit * gradePoint;
            totalCredits += credit;
        }

        double gpa = (totalCredits > 0) ? totalGradePoints / totalCredits : 0.0;

        
        if (resultContainer != null) {
            resultContainer.setVisible(true);
        }
        if (gpaResultLabel != null) {
            gpaResultLabel.setText(String.format("GPA: %.2f | Total Credits: %.1f| GPA Calculated Successfully", gpa, totalCredits));
        }
//
    }

    private double convertGradeToPoints(String grade) {
        if (grade == null) return 0.0;

        return switch (grade.toUpperCase()) {
            case "A+", "A" -> 4.0;
            case "A-" -> 3.7;
            case "B+" -> 3.3;
            case "B" -> 3.0;
            case "B-" -> 2.7;
            case "C+" -> 2.3;
            case "C" -> 2.0;
            case "C-" -> 1.7;
            case "D+" -> 1.3;
            case "D" -> 1.0;
            case "F" -> 0.0;
            default -> 0.0;
        };
    }
}






