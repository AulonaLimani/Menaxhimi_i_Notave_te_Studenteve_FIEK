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
itmAbout.setOnAction(e -> {
			obj.openAbout();

		});
		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.F1) {
				obj.openAbout();

			}
			if (e.isAltDown() && e.getCode() == KeyCode.F4) {
				stage.hide();
			}
		});

		file.getItems().addAll(itmClose);
		edit.getItems().addAll(itmStudents);
		help.getItems().addAll(itmAbout);
		help.getItems().addAll(itmHelp);

		menuBar.getMenus().addAll(file, edit, help);

		root.setTop(menuBar);

		TableColumn<String, StudentsTable> column1 = I18N.getTblColumn("nrID");
		column1.setCellValueFactory(new PropertyValueFactory("teacherID"));
		column1.setPrefWidth(60);

		TableColumn<String, StudentsTable> column2 = I18N.getTblColumn("firstname");
		column2.setCellValueFactory(new PropertyValueFactory("teacherName"));
		column2.setPrefWidth(150);

		TableColumn<String, StudentsTable> column3 = I18N.getTblColumn("fastname");
		column3.setCellValueFactory(new PropertyValueFactory("teacherSurname"));
		column3.setPrefWidth(150);

		TableColumn<String, StudentsTable> column4 = I18N.getTblColumn("phone");
		column4.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
		column4.setPrefWidth(120);

		TableColumn<String, StudentsTable> column5 = I18N.getTblColumn("email");
		column5.setCellValueFactory(new PropertyValueFactory("email"));
		column5.setPrefWidth(120);

		TableColumn<String, StudentsTable> column6 = I18N.getTblColumn("password");
		column6.setCellValueFactory(new PropertyValueFactory("password"));
		column6.setPrefWidth(120);

		TableColumn<String, StudentsTable> column7 = I18N.getTblColumn("adress");
		column7.setCellValueFactory(new PropertyValueFactory("addressID"));
		column7.setPrefWidth(120);

		TableColumn<String, StudentsTable> column8 = I18N.getTblColumn("subjectid");
		column8.setCellValueFactory(new PropertyValueFactory("subjectID"));
		column8.setPrefWidth(120);

		teachersTable.getColumns().add(column1);
		teachersTable.getColumns().add(column2);
		teachersTable.getColumns().add(column3);
		teachersTable.getColumns().add(column4);
		teachersTable.getColumns().add(column5);
		teachersTable.getColumns().add(column6);
		teachersTable.getColumns().add(column7);
		teachersTable.getColumns().add(column8);

		teachersTable.setRowFactory(tv -> {
			TableRow<TeachersTable> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				teacherID.setText(row.getItem().getTeacherID());
				teacherName.setText(row.getItem().getTeacherName());
				teacherSurname.setText(row.getItem().getTeacherSurname());
				phoneNumber.setText(String.valueOf(row.getItem().getPhoneNumber()));
				email.setText(String.valueOf(row.getItem().getEmail()));
				password.setText(String.valueOf(row.getItem().getPassword()));
				addressID.setText(String.valueOf(row.getItem().getAddressID()));
				subjectID.setText(String.valueOf(row.getItem().getSubjectID()));
				adminSetAllEnable();
				teacherID.setDisable(true);
				pane.setOnKeyPressed(ev -> {
					if (ev.isControlDown() && ev.getCode() == KeyCode.D) {
						deleteTeachers();
					}
				});

			});
			return row;
		});
//		studentsTable.setPrefWidth(500);
//		studentsTable.setPrefHeight(200);
		showTeachers();
