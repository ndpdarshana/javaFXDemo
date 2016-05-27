import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by darshana on 4/4/16.
 */
public class CheckBoxDropDownExample extends Application{

    public void launchApp(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Checkbox Drop Down example");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().addAll("Orange", "Banana", "Strawberry");
        choiceBox.setValue("Banana");

        //Listener for Dropdown since there is no event fire for FX dropdown.
        choiceBox.setOnAction(e -> System.out.println("Hello "+choiceBox.getValue()));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Listen "+oldValue + " : " + newValue);
        });

        Button button = new Button("Click me");
        button.setOnAction(e -> getChoice(choiceBox));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void getChoice(ChoiceBox<String> choiceBox){
        System.out.println("Fruit:"+ choiceBox.getValue());
    }
}
