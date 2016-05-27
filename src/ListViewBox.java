import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by darshana on 4/28/16.
 */
public class ListViewBox extends Application{

    public void launchApp(){ launch();}

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("List View");

        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("VBCC", "DSSMMV", "Sri Pada Vidyalaya", "Pathana Sinhala Vidyalaya");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button button = new Button("Submit");

        button.setOnAction(e -> buttonClick(listView));

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(listView, button);

        Scene scene = new Scene(layout, 300, 200);
        window.setScene(scene);
        window.show();
    }

    private void buttonClick(ListView<String> listView){
        String msg = "";

        ObservableList<String> schools;
        schools = listView.getSelectionModel().getSelectedItems();

        for(String s:schools){
            System.out.println(s);
        }
    }
}
