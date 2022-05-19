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

