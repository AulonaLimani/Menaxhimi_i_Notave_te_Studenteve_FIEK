package admin;

import database.DBConnection;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import menu.I18N;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainLogin {

	private TextField administratorID = new TextField();
	private PasswordField password = new PasswordField();
	private Label ErrorResult = new Label();
	private Button btnLogin = new Button();
	private Label title = new Label();
	private Stage mainStage;

	public void createStage() {
		Stage primaryStage = new Stage();
		btnLogin = I18N.getButton("login");
		VBox pane = new VBox(60);
		mainStage = primaryStage;
		GridPane loginPane = new GridPane();
		title = I18N.getLabel("loginAsAdministartor");
		loginPane.addRow(0, I18N.getLabel("nrID"), administratorID);
		loginPane.addRow(1, I18N.getLabel("password"), password);
		loginPane.add(btnLogin, 1, 3);
		loginPane.add(ErrorResult, 1, 4);
		loginPane.setHgap(35);
		loginPane.setVgap(10);
		loginPane.setHalignment(btnLogin, HPos.RIGHT);
		loginPane.setAlignment(Pos.CENTER);
		btnLogin.setOnAction(e -> {
			loginAdmin();
		});
		pane.getChildren().addAll(title, loginPane);
		title.getStyleClass().add("title");
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 500, 330);
		primaryStage.setScene(scene);
		primaryStage.show();
		ErrorResult.getStyleClass().add("error");
		btnLogin.getStyleClass().add("button-blue");
		scene.getStylesheets().add("style.css");

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				loginAdmin();
			}
		});
	}

	public void loginAdmin() {
		String query = "Select * from Administrator where administratorID = ? AND password = ?";
		try {

			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, administratorID.getText());
//			preparedStatement.setString(2, Hash.SHA1(password.getText()));
			preparedStatement.setString(2, password.getText());

			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Logged in");
				alert.setHeaderText(null);
				alert.setContentText("You are log in!");

				alert.showAndWait();

//				mainStage.show();
				mainStage.hide();
//				new StudentsPanel().createStage();

//				System.exit(1);
			} else {
				ErrorResult.setText("Email or Password Incorrect");
			}

		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem!");
			alert.setHeaderText(null);
			alert.setContentText("Cannot connect to database!");

			alert.showAndWait();

			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
