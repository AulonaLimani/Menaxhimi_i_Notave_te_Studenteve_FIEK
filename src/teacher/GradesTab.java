package teacher;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import menu.I18N;

public class GradesTab {
    Tab tab;

    public GradesTab(Tab tab) {
        this.tab = tab;
    }
    public GradesTab() {

    }

    // Text fields
    private TextField periodIDTxt = new TextField();
    private TextField studentIDTxt = new TextField();
    private TextField subjectIDTxt = new TextField();
    private TextField projectsTxt = new TextField();
    private TextField finalTestTxt = new TextField();
    private TextField finalPeriodMarkTxt = new TextField();
    private TextField finalGradeTxt = new TextField();

    // Buttons
    private Button insertBtn = new Button();
    private Button updateBtn = new Button();
    private Button deleteBtn = new Button();
    private Button clearBtn = new Button();


    // Table views
    private TableView gradesTable = new TableView();

    public void open() {
        // Form pane
        GridPane formPane = new GridPane();
        insertBtn = I18N.getButton("insert");
        updateBtn = I18N.getButton("insert");
        deleteBtn = I18N.getButton("delete");
        clearBtn = I18N.getButton("clear");

 formPane.addRow(0, I18N.getLabel("periodid"), periodIDTxt);
        formPane.addRow(1, I18N.getLabel("nrID"), studentIDTxt);
        formPane.addRow(2, I18N.getLabel("subjectid"), subjectIDTxt);
        formPane.addRow(7, I18N.getLabel("projects"), projectsTxt);
        formPane.addRow(12, I18N.getLabel("finaltest"), finalTestTxt);
        formPane.addRow(14, I18N.getLabel("finalperiodmark"), finalPeriodMarkTxt);
        formPane.addRow(14, I18N.getLabel("finalgrade"), finalGradeTxt);

        formPane.setHgap(10);
        formPane.setVgap(10);

        finalPeriodMarkTxt.setDisable(true);
        finalGradeTxt.setDisable(true);

        // Buttons pane
        HBox buttonsPane = new HBox(10);

        buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);

        insertBtn.setOnAction(e -> {
            insertGrade();
        });

        clearBtn.setOnAction(e -> {
            clearForm();
        });

        deleteBtn.setOnAction(e -> {
            deleteGrade();
        });

        updateBtn.setOnAction(e -> {
            updateGrade();
        });

         // Left Pane

        VBox leftPane = new VBox(50);

        leftPane.getChildren().addAll(formPane, buttonsPane);

        // Grades table

        TableColumn<String, Grades> column1 = I18N.getTblColumn("periodid");
        column1.setCellValueFactory(new PropertyValueFactory("periodID"));
        column1.setPrefWidth(80);

        TableColumn<String, Grades> column2 = I18N.getTblColumn("nrID");
        column2.setCellValueFactory(new PropertyValueFactory("studentID"));
        column2.setPrefWidth(120);

        TableColumn<String, Grades> column3 = I18N.getTblColumn("subjectid");
        column3.setCellValueFactory(new PropertyValueFactory("subjectID"));
        column3.setPrefWidth(80);

        TableColumn<String, Grades> column4 = I18N.getTblColumn("projects");
        column4.setCellValueFactory(new PropertyValueFactory("projects"));
        column4.setPrefWidth(80);


        TableColumn<String, Grades> column5 = I18N.getTblColumn("finaltest");
        column5.setCellValueFactory(new PropertyValueFactory("finalTest"));
        column5.setPrefWidth(100);

        TableColumn<String, Grades> column6 = I18N.getTblColumn("finalperiodmark");
        column6.setCellValueFactory(new PropertyValueFactory("finalPeriodMark"));
        column6.setPrefWidth(140);

        TableColumn<String, Grades> column7 = I18N.getTblColumn("finalgrade");
        column7.setCellValueFactory(new PropertyValueFactory("finalGrade"));
        column7.setPrefWidth(140);

  gradesTable.getColumns().add(column1);
        gradesTable.getColumns().add(column2);
        gradesTable.getColumns().add(column3);
        gradesTable.getColumns().add(column4);
        gradesTable.getColumns().add(column5);
        gradesTable.getColumns().add(column6);
        gradesTable.getColumns().add(column7);

        gradesTable.setRowFactory(tv -> {
            TableRow<Grades> row = new TableRow<>();

            row.setOnMouseClicked(e -> {

                periodIDTxt.setText(row.getItem().getPeriodID());
                studentIDTxt.setText(row.getItem().getStudentID());
                subjectIDTxt.setText(row.getItem().getSubjectID());
                projectsTxt.setText(String.valueOf(row.getItem().getProjects()));
                finalTestTxt.setText(String.valueOf(row.getItem().getFinalTest()));
                finalPeriodMarkTxt.setText(String.valueOf(row.getItem().getFinalPeriodMark()));
                finalGradeTxt.setText(String.valueOf(row.getItem().getFinalGrade()));

                finalPeriodMarkTxt.setDisable(true);
                deleteBtn.setOnKeyPressed(ev -> {
                    if (ev.isControlDown() && ev.getCode() == KeyCode.D) {
                        deleteGrade();
                    }
                });
            });

            return row;
        });

        gradesTable.setPrefWidth(1360);
        gradesTable.setPrefHeight(200);

        // Main Pane
        HBox mainPane = new HBox(10);

        mainPane.getChildren().addAll(leftPane, gradesTable);

        mainPane.setPadding(new Insets(15, 15, 15, 15));

        showGrades();

        tab.setContent(mainPane);
    }
