package tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by prabhathd on 5/11/16.
 */
public class TableViewExample extends Application {

    TableView<Product> tableView;
    TextField nameInput, priceInput, quantityInput;
    public void launchApp(){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Table view");


        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        tableView = new TableView<>();
        tableView.setItems(getProducts());
        tableView.getColumns().addAll(nameColumn, priceColumn, quantityColumn);



        nameInput = new TextField();
        nameInput.setPromptText("Name");

        priceInput = new TextField();
        priceInput.setPromptText("Price");

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox layoutEditable = new HBox();
        layoutEditable.setPadding(new Insets(10,10,10,10));
        layoutEditable.setSpacing(10);
        layoutEditable.getChildren().addAll(nameInput,priceInput,quantityInput,addButton,deleteButton);

        VBox layout = new VBox();
        layout.getChildren().addAll(tableView, layoutEditable);
        Scene scene = new Scene(layout, 800, 300);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked(){
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        tableView.getItems().add(product);

        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();

    }

    public void deleteButtonClicked(){
        ObservableList<Product> productSelected, allProducts;
        allProducts = tableView.getItems();
        productSelected = tableView.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    private ObservableList<Product> getProducts(){
        ObservableList<Product> productObservableList = FXCollections.observableArrayList();
        productObservableList.add(new Product("laptop", 90000, 5));
        productObservableList.add(new Product("CPU", 15000, 3));
        productObservableList.add(new Product("Rap", 4000, 20));
        productObservableList.add(new Product("HDD", 5000, 6));
        productObservableList.add(new Product("SSD", 21000, 2));
        productObservableList.add(new Product("Power Supply", 4500, 3));
        return productObservableList;
    }
}
