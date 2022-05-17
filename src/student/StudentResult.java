package student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import Help.About;
import Help.HelpStudentEn;
import Help.studentHelp;
import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import teacher.ChartTab;
import teacher.Grades;




public class StudentResults {
    // Table views
    private TableView gradesTable = new TableView();
    private TableView finalGradesTable = new TableView();
    private BorderPane bp = new BorderPane();



    public void openStudentResults() {
        Stage primaryStage = new Stage();
        MenuBar menuBar = new MenuBar();

        Menu file = new Menu("File");

        MenuItem itmNew = new MenuItem("New");
        MenuItem itmSave = new MenuItem("Save");
        MenuItem itmClose = new MenuItem("Close");
        itmClose.setOnAction(e -> {
            primaryStage.hide();
        });

        Menu edit = new Menu("Edit");

        MenuItem itmCut = new MenuItem("Cut");
        MenuItem itmCopy = new MenuItem("Copy");
        MenuItem itmPaste = new MenuItem("Paste");

        Menu help = new Menu("Help");
        MenuItem itmHelp = new MenuItem("Help");
        itmHelp.setOnAction(e -> {
            if(itmHelp.getText().equals("Help")) {
                HelpStudentEn.about();
            }else {
                studentHelp.about();
            }

        });
        About obj = new About();
        MenuItem itmAbout = new MenuItem("About");
        itmAbout.setOnAction(e -> {
            obj.openAbout();

        });
        help.getItems().addAll(itmAbout);
        help.getItems().addAll(itmHelp);

        Menu subSearch = new Menu("Search");

        MenuItem itmFind = new MenuItem("Find");
        MenuItem itmReplace = new MenuItem("Replace");

        HBox btnPane = new HBox(20);
        btnPane.setPadding(new Insets(10, 10, 10, 10));
        btnPane.getChildren().addAll();
        StackPane stackBtn = new StackPane();

        stackBtn.getChildren().add(btnPane);

        file.getItems().addAll(itmNew, itmSave, itmClose);
        edit.getItems().addAll(itmCut, itmCopy, itmPaste);
        subSearch.getItems().addAll(itmFind, itmReplace);

        menuBar.getMenus().addAll(file, edit, help);
        edit.getItems().add(subSearch);

        bp.setTop(menuBar);

        // Grades table

        TableColumn<String, Grades> column1 = new TableColumn<>("periodID");
        column1.setCellValueFactory(new PropertyValueFactory("periodID"));
        column1.setPrefWidth(80);

        TableColumn<String, Grades> column2 = new TableColumn<>("studentID");
        column2.setCellValueFactory(new PropertyValueFactory("studentID"));
        column2.setPrefWidth(120);

        TableColumn<String, Grades> column3 = new TableColumn<>("subjectID");
        column3.setCellValueFactory(new PropertyValueFactory("subjectID"));
        column3.setPrefWidth(80);

        TableColumn<String, Grades> column4 = new TableColumn<>("projects");
        column4.setCellValueFactory(new PropertyValueFactory("projects"));
        column4.setPrefWidth(80);

        TableColumn<String, Grades> column5 = new TableColumn<>("finalTest");
        column5.setCellValueFactory(new PropertyValueFactory("finalTest"));
        column5.setPrefWidth(100);

        TableColumn<String, Grades> column6 = new TableColumn<>("finalPeriodMark");
        column6.setCellValueFactory(new PropertyValueFactory("finalPeriodMark"));
        column6.setPrefWidth(140);

        TableColumn<String, Grades> column7 = new TableColumn<>("finalGrade");
        column7.setCellValueFactory(new PropertyValueFactory("finalGrade"));
        column7.setPrefWidth(140);

        gradesTable.getColumns().add(column1);
        gradesTable.getColumns().add(column2);
        gradesTable.getColumns().add(column3);
        gradesTable.getColumns().add(column4);
        gradesTable.getColumns().add(column5);
        gradesTable.getColumns().add(column6);
        gradesTable.getColumns().add(column7);

        gradesTable.setPrefWidth(740);
        gradesTable.setPrefHeight(500);



        // Main Pane
        VBox vbox = new VBox();

        vbox.getChildren().add(gradesTable);
        bp.setCenter(vbox);
        showGrades();
        Scene scene = new Scene(bp);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void showGrades() {
        List<Grades> grades = Grades.getGrades();

        ObservableList<Grades> gradesList = FXCollections.observableArrayList();

        for (int i = 0; i < grades.size(); i++) {
            gradesList.add(grades.get(i));
        }

        gradesTable.setItems(gradesList);
    }

}