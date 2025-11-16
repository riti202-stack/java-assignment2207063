package com.example.javaassignment2207063;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Scene1Controller {



    public void goBack() throws Exception {
        SceneLoader.switchScene("hello-view.fxml");

    }

    @FXML
    private VBox courseVBox;


    public void initialize() {
        addCourseRow(); // Start with one row
    }

    @FXML
    public void addCourseRow() {
        HBox row = new HBox(10);

        TextField courseName = new TextField();
        courseName.setPromptText("Course Name");
        courseName.setPrefWidth(120);

        TextField courseCode = new TextField();
        courseCode.setPromptText("Code");
        courseCode.setPrefWidth(60);

        TextField credit = new TextField();
        credit.setPromptText("Credit");
        credit.setPrefWidth(60);

        TextField teacher1 = new TextField();
        teacher1.setPromptText("Teacher 1");
        teacher1.setPrefWidth(100);

        TextField teacher2 = new TextField();
        teacher2.setPromptText("Teacher 2");
        teacher2.setPrefWidth(100);

        ComboBox<String> gradeBox = new ComboBox<>();
        gradeBox.getItems().addAll("A+", "A", "A-", "B+", "B", "C", "D", "F");
        gradeBox.setPrefWidth(80);

        Button removeBtn = new Button("❌");
        removeBtn.setOnAction(e -> {
            courseVBox.getChildren().remove(row);

        });

        row.getChildren().addAll(courseName, courseCode, credit, teacher1, teacher2, gradeBox, removeBtn);
        courseVBox.getChildren().add(row);
    }

    @FXML
    public void calculateGPA() throws Exception {
        DataStore.courseList.clear();
        double totalCredits = 0;

        for (var node : courseVBox.getChildren()) {
            if (node instanceof HBox row) {
                TextField nameField = (TextField) row.getChildren().get(0);
                TextField codeField = (TextField) row.getChildren().get(1);
                TextField creditField = (TextField) row.getChildren().get(2);
                TextField t1Field = (TextField) row.getChildren().get(3);
                TextField t2Field = (TextField) row.getChildren().get(4);
                ComboBox<String> gradeBox = (ComboBox<String>) row.getChildren().get(5);

                String name = nameField.getText();
                String code = codeField.getText();
                double credit = creditField.getText().isEmpty() ? 0 : Double.parseDouble(creditField.getText());
                String t1 = t1Field.getText();
                String t2 = t2Field.getText();
                String grade = gradeBox.getValue() != null ? gradeBox.getValue() : "";

                if (!name.isEmpty()) {
                    DataStore.courseList.add(new course(name, code, credit, t1, t2, grade));
                    totalCredits += credit;
                }
            }
        }

       if (totalCredits == DataStore.totalCreditTarget) {
            SceneLoader.switchScene("Scene2.fxml");
       }


    }
}



