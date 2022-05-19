package teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import database.Hash;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherLogin
{
	private TextField teacherID = new TextField();
	private PasswordField password = new PasswordField();
	private Label ErrorResult = new Label();
	private Button btnLogin = new Button("Login");
	private Label title = new Label("Login as Teacher");
	private Stage mainStage;
