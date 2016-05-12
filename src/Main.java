import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tableview.TableViewExample;

/**
 * Created by prabhathd on 4/2/16.
 */
public class Main extends Application{

    Button button;
    Stage window;

    public static void main(String[] args){
        //1st example
        //SimpleEvent simpleEvent = new SimpleEvent();
        //simpleEvent.launchApp(args);

        //Anonymous Inner class
        //AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
        //anonymousInnerClass.launchApp(args);

        //Inner class into lambda Expression
        //AnonymousInnerClassLambdaExpression anonymousInnerClassLambdaExpression = new AnonymousInnerClassLambdaExpression();
        //anonymousInnerClassLambdaExpression.launchApp(args);

        //Switching Scenes
        //SwitchingScenes switchingScenes = new SwitchingScenes();
        //switchingScenes.launchApp(args);

        //AlertBox.display("Alert Box", "Hello Alert");

//        launch(args);

        //Embedding Layouts
//        EmbeddingLayouts embeddingLayouts = new EmbeddingLayouts();
//        embeddingLayouts.launchApp(args);

        //GridPane
//        GridPaneExample gridPaneExample = new GridPaneExample();
//        gridPaneExample.launchApp(args);

        //Combobox
//        ComboBoxExample comboBoxExample = new ComboBoxExample();
//        comboBoxExample.launchApp();

        //TreeView
//        TreeViewExample treeViewExample = new TreeViewExample();
//        treeViewExample.launchApp();

        //TableView
        TableViewExample tableViewExample = new TableViewExample();
        tableViewExample.launchApp();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Hello JFX World");

        button = new Button("Click Me");
//        button.setOnAction(e -> AlertBox.display("Alert Box", "Hello Alert"));
        button.setOnAction(e -> {
            boolean rs = ConfirmationBox.display("Alert Box", "Hello Alert");
            System.out.println(rs);
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 250, 300);
        window.setScene(scene);
        window.show();

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
    }

    private void closeProgram(){
        System.out.println("File is saved!!");
        boolean rs = ConfirmationBox.display("Alert Box", "Close the program??");
        if(rs)
            window.close();
    }
}
