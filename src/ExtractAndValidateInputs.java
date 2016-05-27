import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by darshana on 4/4/16.
 */
public class ExtractAndValidateInputs extends Application {

    Stage window;

    public void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Extract and Validate inputs");

        TextField input = new TextField();
        Button button = new Button("Click me");
        button.setOnAction(e -> isNumber(input));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(input, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private boolean isNumber(TextField input){
        try{
            int age = Integer.parseInt(input.getText());
            System.out.println("Input is a number:"+ age);
            return true;
        }catch (Exception e){
            System.err.println("Error: "+ e.getMessage());
            System.out.println("Word:" + input.getText());
            return false;
        }
    }
}
