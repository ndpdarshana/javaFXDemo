import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by prabhathd on 4/2/16.
 */
public class AnonymousInnerClassLambdaExpression extends Application{

    Button button;

    public void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Anonmous Inner Class and Lambda Expressions");
        button = new Button();
        button.setText("Hay Babe");

        //This class will handle the button events
//        button.setOnAction(e -> System.out.println("Hay now lambda expression");); // single line
        button.setOnAction(e -> {
            System.out.println("Hay now lambda expression");
            System.out.println("Hay now lambda expression multiline");
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
