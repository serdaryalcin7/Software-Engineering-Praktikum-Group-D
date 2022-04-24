/*
 * Source Code must not be used without permission of
 * Reinhold Plösch (reinhold.ploesch@gmail.com)
 * (c) Reinhold Plösch, 2020
 */
package at.jku.se.diary;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;

import javafx.scene.image.Image;

import java.awt.event.ActionEvent;

public class HelloFX extends Application {
    Stage window;
    Button button, button2, button3;
    Scene scene1, scene2;
    TableView<Entries> tableView;
    TextField title, location, date;
    TextArea text;

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


        VBox layout = new VBox();

        Scene scene1 = new Scene(layout, 900, 600);
        Image img = new Image("https://www.nicepng.com/png/full/196-1965889_travel-png-hd-gathering-no-moss-memoir-of.png");
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        layout.setBackground(bGround);


        button = new Button();
        button.setText("New entry");
        button3 = new Button();
        button3.setText("Search Entry");
        button.setFont(Font.font("Arial", 40));
        button3.setFont(Font.font("Arial", 40));
        button.setOnAction(e-> stage.setScene(scene2));
        button3.setOnAction(e->System.out.println("abicim"));
        layout.getChildren().addAll(button, button3);
        layout.setPadding(new Insets(5,5,5,5));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER_RIGHT);
        stage.setScene(scene1);
        window.show();

        stage.setTitle("DIARY_FX");
        stage.show();

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

        text = new TextArea();
        text.setPromptText("text");
        text.setMinWidth(200);



        Button addButton = new Button("Add new Entry");
        addButton.setOnAction(e-> addButtonClicked());
        Button deleteButton = new Button("Delete entry");
        deleteButton.setOnAction(e-> deleteButtonClicked());
        Button back = new Button("go back");
        back.setOnAction(e-> window.setScene(scene1));

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(title, location, date, text, addButton, deleteButton, back);

        tableView = new TableView<>();
        tableView.getColumns().addAll(titleColumn, locationColumn, dateColumn, textColumn);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox, tableView);

        scene2 = new Scene(vbox, 900, 600);
        window.setScene(scene1);


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
