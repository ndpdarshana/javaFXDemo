import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by prabhathd on 4/3/16.
 */
public class GridPaneExample extends Application{

    Stage window;

    public void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Grid Pane");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);

        Label nameLabel = new Label("Username");
        Label passLabel = new Label("Password");
        GridPane.setConstraints(nameLabel, 0, 0);
        GridPane.setConstraints(passLabel, 0, 1);

        TextField nameInput = new TextField("type here");
        TextField passInput = new TextField();
        passInput.setPromptText("Password");
        GridPane.setConstraints(nameInput, 1, 0);
        GridPane.setConstraints(passInput, 1, 1);

        Button button = new Button("Log in");
        GridPane.setConstraints(button, 1, 2);

        gridPane.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, button);
        Scene scene = new Scene(gridPane, 300, 300);
        window.setScene(scene);
        window.show();
    }
}
