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
import java.util.Date;

public class HelloFX extends Application {
    Stage window;
    Button button,button1, button2,button3,button4;
    Scene scene,scene1, scene2;
    TableView<Entries> tableView;
    TextField title, location, date;
    TextArea text;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        //----------------Scene: HOMEPAGE--------------------

        window = stage;

        stage.setTitle("DIARY_FX");
        HBox layout = new HBox();

        scene = new Scene(layout, 1200,750);
        Image img = new Image("https://i.f1g.fr/media/cms/1200x630_crop/2022/02/21/806d983eb123652ee94b2027b8f5487924b2133636999a3dcb56b5236db51093.png");
        BackgroundImage bImg = new BackgroundImage(img,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bGround = new Background(bImg);
        layout.setBackground(bGround);

        button= new Button();
        button.setText("Show overview");
        button1 = new Button();
        button1.setText("New entry");
        button2 = new Button();
        button2.setText("Search Entry");
        button3 = new Button();
        button3.setText("Search for a category");
        button4 = new Button();
        button4.setText("show map");

        button.setFont(Font.font("Arial", 25));
        button1.setFont(Font.font("Arial", 25));
        button2.setFont(Font.font("Arial", 25));
        button3.setFont(Font.font("Arial", 25));
        button4.setFont(Font.font("Arial", 25));

        button1.setOnAction(e-> window.setScene(scene1));
        button.setOnAction(e-> window.setScene(scene2));

        layout.getChildren().addAll(button,button1, button2,button3,button4);
        layout.setPadding(new Insets(5,5,5,5));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        window.show();
        stage.setTitle("DIARY");
        stage.show();


        //----------------Scence 1: New entry--------------------





        //----------------Scence 2: Overview--------------------


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

        date  = new TextField();
        date .setPromptText("date");
        date .setMinWidth(100);

        text = new TextArea();
        text.setPromptText("text");
        text.setMinWidth(200);

        Button addButton = new Button("Add new entry");
        addButton.setOnAction(e-> addButtonClicked());
        Button back = new Button("back");
        back.setOnAction(e-> window.setScene(scene));
        Button deleteButton = new Button("Delete entry");
        deleteButton.setOnAction(e-> deleteButtonClicked());
        Button addentry = new Button("Add new Entry");
        addentry.setOnAction(e-> window.setScene(scene1));


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(title, location, date, text,addButton, back);

        tableView = new TableView<>();
        tableView.getColumns().addAll(titleColumn, locationColumn, dateColumn,textColumn);


        VBox vbox = new VBox();
        vbox.getChildren().addAll(hBox);

        scene1 = new Scene(vbox,900,600);
        window.setScene(scene);

        VBox vbox2 = new VBox();
        vbox2.getChildren().addAll(tableView,addentry ,deleteButton);
        scene2 = new Scene(vbox2, 900, 600);


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