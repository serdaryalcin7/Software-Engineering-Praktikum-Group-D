/*
 * Source Code must not be used without permission of
 * Reinhold Plösch (reinhold.ploesch@gmail.com)
 * (c) Reinhold Plösch, 2020
 */
package at.jku.se.diary;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
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
import java.util.Locale;

public class HelloFX extends Application {
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
    //----------------Scence: HOMEPAGE--------------------

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

        button1.setOnAction(e-> stage.setScene(scene1));

        layout.getChildren().addAll(button,button1, button2,button3,button4);
        layout.setPadding(new Insets(5,5,5,5));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        stage.setScene(scene);
        stage.show();

        //----------------Scence 1: New entry--------------------
        Label label1=new Label("Titel: ");
        Label label2=new Label("Date: ");
        Label label3=new Label("Location: ");
        Label label4=new Label("Text: ");

        TextField textField1 =new TextField();
        TilePane tilePane = new TilePane();
        TextField textField3 =new TextField();
        TextArea textArea = new TextArea();

        GridPane gridPane =new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        textField1.setPromptText("Titel...");
        gridPane.add(label1,0,0);
        gridPane.add(textField1,1,0);


        DatePicker d = new DatePicker();
        gridPane.add(label2,0,1);
        tilePane.getChildren().add(d);
        gridPane.add(tilePane,1,1);

        textField3.setPromptText("Location...");
        gridPane.add(label3,0,2);
        gridPane.add(textField3,1,2);

        ScrollPane scro = new ScrollPane(textArea);
        textArea.setPrefColumnCount(100);
        textArea.setPromptText("Text...");
        gridPane.add(label4,0,3);
        gridPane.add(scro, 1,3,10,10);

        Button addEntry = new Button("Add new Entry");
        gridPane.add(addEntry,0,40);
        //addEntry.setOnAction(e-> stage.setScene(scene2));

        Button back = new Button("go back");
        gridPane.add(back,1,40);
        back.setOnAction(e-> stage.setScene(scene));

        scene1 =new Scene(gridPane,1200,750);
        stage.setScene(scene);

        //----------------Scence 2: Overview--------------------

    }

}
