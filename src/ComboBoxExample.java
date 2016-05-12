import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by prabhathd on 4/10/16.
 */
public class ComboBoxExample extends Application{
    public void launchApp(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Combo box example");
        Button button = new Button("Click me");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setPromptText("Suzuki car models");
        comboBox.getItems().addAll(
                "Celerio",
                "Alto",
                "Swift",
                "WagonR",
                "Alto eco"
        );
        comboBox.setEditable(true);
        comboBox.setOnAction(e -> promtCarModel(comboBox));

        VBox layout = new VBox();
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(button, comboBox);

        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.show();
    }

    private void promtCarModel(ComboBox<String> comboBox){
        System.out.println(comboBox.getValue());
    }
}
