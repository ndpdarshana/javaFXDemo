import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by prabhathd on 4/2/16.
 */
public class SwitchingScenes extends Application {

    Stage window;
    Scene scene1, scene2;

    public void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Label lablel1 = new Label("Welcome to the first Scene!!");
        Button button1 = new Button("Go to scene 2");
        button1.setOnAction(e -> window.setScene(scene2));

        //Layout1 - children are laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(lablel1, button1);
        scene1 = new Scene(layout1, 200, 200);

        //Button 2
        Button button2 = new Button("This is 2, Go back to scene1");
        button2.setOnAction(e -> window.setScene(scene1));

        //Layout2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 600, 200);

        window.setScene(scene1);
        window.setTitle("Switching Scene");
        window.show();
    }
}

