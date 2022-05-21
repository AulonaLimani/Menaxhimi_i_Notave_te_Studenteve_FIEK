package admin;

import java.util.List;
import java.util.Locale;

import Help.About;
import Help.AdminHelp;
import Help.HelpAdminEn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import menu.I18N;


public class TeachersPanel {
	private Label teachersLabel = new Label("Teachers Registration Details");
	private Button btnAddNew = new Button();
	private Button btnEdit = new Button();
	private Button btnDelete = new Button();
	private Button btnClear = new Button();
//	private Button btnSave = new Button("Save");
	private Button btnSave = new Button();
	static Label label_2 = new Label();

	private TextField teacherID = new TextField();
	private TextField teacherName = new TextField();
	private TextField teacherSurname = new TextField();
	private TextField phoneNumber = new TextField();
	private TextField email = new TextField();
	private PasswordField password = new PasswordField();
	private TextField addressID = new TextField();
	private TextField subjectID = new TextField();
	private TableView teachersTable = new TableView();
