import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by prabhathd on 5/8/16.
 */
public class TreeViewExample extends Application {

    public void launchApp(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Tree View");

        TreeItem<String> root, home, etc;

        root = new TreeItem<>();
        root.setExpanded(true);

        home = makeBranch("Home", root);
        makeBranch("Downloads", home);
        makeBranch("Pictures", home);

        etc = makeBranch("etc", root);
        makeBranch("init.d", etc);
        makeBranch("apache", etc);
        makeBranch("module", etc);

        TreeView<String> treeView = new TreeView<>(root);
        treeView.setShowRoot(false);

        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldVal, newVal) -> {
            if(newVal != null){
                System.out.println(newVal.getValue());
            }
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(treeView);
        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();
    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parant){
        TreeItem<String> treeItem = new TreeItem<>(title);
        treeItem.setExpanded(true);
        parant.getChildren().add(treeItem);
        return  treeItem;
    }
}
