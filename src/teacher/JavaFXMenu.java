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
