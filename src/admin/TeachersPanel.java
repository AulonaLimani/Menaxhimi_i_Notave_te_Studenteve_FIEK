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
	
	public void createStage() {

		About obj = new About();

		btnSave = I18N.getButton("save");
		Stage stage = new Stage();

		BorderPane pane = new BorderPane();
		VBox vboxMain = new VBox();

		BorderPane root = new BorderPane();

		MenuBar menuBar = new MenuBar();

		Menu file = I18N.getMenu("file");

		MenuItem itmClose = I18N.getMenuItem("close");
		itmClose.setOnAction(e -> {
			stage.hide();
		});

		Menu edit = I18N.getMenu("editMenu");
		Menu language = I18N.getMenu("language");

		MenuItem itmShqip = I18N.getMenuItem("shqip");
		MenuItem itmEnglish = I18N.getMenuItem("english");
		language.getItems().addAll(itmShqip, itmEnglish);
		edit.getItems().add(language);
		itmShqip.setOnAction(e -> {
			I18N.setLocale(new Locale("al"));
		});
		itmEnglish.setOnAction(e -> {
			I18N.setLocale(new Locale("en"));
		});

		MenuItem itmStudents = I18N.getMenuItem("studentsPanel");
		itmStudents.setOnAction(e -> {
			new StudentsPanel().createStage();
		});

		Menu help = I18N.getMenu("help");

		MenuItem itmAbout = I18N.getMenuItem("about");
		MenuItem itmHelp = I18N.getMenuItem("help");
		itmHelp.setOnAction(e -> {
			if(itmHelp.getText().equals("Help"))
			{
				HelpAdminEn.about();
			}else {
				AdminHelp.about();
			}
		});
