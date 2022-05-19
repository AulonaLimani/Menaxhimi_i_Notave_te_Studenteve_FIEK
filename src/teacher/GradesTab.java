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


