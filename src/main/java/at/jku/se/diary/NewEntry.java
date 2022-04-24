package at.jku.se.diary;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;



    /*
     * Source Code must not be used without permission of
     * Reinhold Plösch (reinhold.ploesch@gmail.com)
     * (c) Reinhold Plösch, 2020
     */


    public class NewEntry extends Application {

        Stage window;
        Button button, button2;
        Scene scene1, scene2;
        TableView<Entries> tableView;
        TextField title, location, date, text;

        public static void main(String[] args) {
            launch();
        }

        @Override
   /* public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    */
        public void start(Stage stage) {
            window = stage;

            TableColumn<Entries, String> titleColumn = new TableColumn<>("Title");
            titleColumn.setMinWidth(200);
            titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

            TableColumn<Entries, String> locationColumn = new TableColumn<>("Location");
            locationColumn.setMinWidth(200);
            locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

            TableColumn<Entries, String> dateColumn = new TableColumn<>("Date");
            dateColumn.setMinWidth(200);
            dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

            TableColumn<Entries, String> textColumn = new TableColumn<>("Text");
            textColumn.setMinWidth(200);
            textColumn.setCellValueFactory(new PropertyValueFactory<>("text"));

            title = new TextField();
            title.setPromptText("title");
            title.setMinWidth(100);

            location = new TextField();
            location.setPromptText("location");
            location.setMinWidth(100);

            date = new TextField();
            date.setPromptText("date");
            date.setMinWidth(100);

            text = new TextField();
            text.setPromptText("text");
            text.setMinWidth(100);

            Button addButton = new Button("Add new Entry");
            addButton.setOnAction(e-> addButtonClicked());
            Button deleteButton = new Button("Delete entry");
            deleteButton.setOnAction(e-> deleteButtonClicked());

            HBox hBox = new HBox();
            hBox.setPadding(new Insets(10,10,10,10));
            hBox.setSpacing(10);
            hBox.getChildren().addAll(title, location, date, text, addButton, deleteButton);

            tableView = new TableView<>();
            tableView.getColumns().addAll(titleColumn, locationColumn, dateColumn, textColumn);

            VBox vbox = new VBox();
            vbox.getChildren().addAll(hBox, tableView);



            window.setScene(scene2);
            window.show();



            stage.setTitle("DIARY_FX");
            stage.show();
        }

        public void addButtonClicked(){
            Entries entries = new Entries();
            entries.setTitle(title.getText());
            entries.setLocation(location.getText());
            entries.setDate(date.getText());
            entries.setText(text.getText());
            tableView.getItems().add(entries);
            title.clear();
            location.clear();
            date.clear();
            text.clear();
        }

        public void deleteButtonClicked(){
            ObservableList<Entries> entrySelected, allEntries;
            allEntries = tableView.getItems();
            entrySelected = tableView.getSelectionModel().getSelectedItems();
            entrySelected.forEach(allEntries::remove);
        }

    }


