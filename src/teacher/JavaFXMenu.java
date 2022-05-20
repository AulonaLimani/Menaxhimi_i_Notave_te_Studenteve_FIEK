package teacher;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import menu.MainMenu;

public class JavaFXMenu
{
	private BorderPane root = new BorderPane();
	private TabPane tabPane = new TabPane();
	List<Tab> openTabs = new ArrayList<>();
	SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
public void createStage()
	{
		Stage stage = new Stage();
		ScrollPane scrollPane = new ScrollPane();
		
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Menu 1");
		menuBar.getMenus().add(menu1);

		root.setTop(MainMenu.mainMenu());
		root.setLeft(Menu());
		
		// Set content for ScrollPane
        scrollPane.setContent(root);
 
        // Always show vertical scroll bar
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        
        // Horizontal scroll bar is only displayed when needed
        scrollPane.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		
		Scene scene = new Scene(scrollPane);
		stage.setScene(scene);
		stage.show();
	}

	private VBox Menu()
	{
		VBox vbox = new VBox();
		vbox.setPrefWidth(50);

		vbox.getChildren().add(Item(String.valueOf("vendos")));
//		vbox.getChildren().add(Item(String.valueOf("showresults")));
		vbox.getChildren().add(Item(String.valueOf("nota")));
//		vbox.getChildren().add(Item(String.valueOf("oret")));

		vbox.setStyle("-fx-background-color: #CCCCCC");
		return vbox;
	}

	private HBox Item(String icon)
	{
		Image image = new Image(JavaFXMenu.class.getResource("/images/" + icon + ".png").toExternalForm());
		ImageView imageView = new ImageView(image);
		Button btn = new Button();
		btn.setGraphic(imageView);
		btn.setPrefSize(45, 50);
		btn.setStyle("-fx-background-color: #CCCCCC");

//		Tab tabOret = new Tab("Oret");
		Tab tabVendos = new Tab("Vendos");
		Tab tabNota = new Tab("Nota");
//		Tab tabShowResults = new Tab("Show Results");
		
		btn.setOnMouseClicked(e -> {
