import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by darshana on 4/4/16.
 */
public class CheckBoxExample extends Application{

    Stage window;

    public void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("CheckBoxExample Example");

        CheckBox checkBox1 = new CheckBox("Rice");
        CheckBox checkBox2 = new CheckBox("Bread");
        checkBox1.setSelected(true);

        Button button = new Button("Click me");
        button.setOnAction(e -> handleOptions(checkBox1, checkBox2));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(checkBox1, checkBox2, button);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void handleOptions(CheckBox box1, CheckBox box2){
        String message = "";

        if(box1.isSelected()){
            message += box1.getText();
        }

        if(box2.isSelected()){
            message += box2.getText();
        }

        System.out.println(message);
    }
}
