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
public class SimpleEvent extends Application implements EventHandler<ActionEvent>{

    Button btn;

    public void launchApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demo FX application");
        btn = new Button();
        btn.setText("Click Me");

        btn.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().add(btn);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==btn){
            System.out.println("Hello....");
        }
    }
}
