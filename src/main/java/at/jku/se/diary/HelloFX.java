/*
 * Source Code must not be used without permission of
 * Reinhold Plösch (reinhold.ploesch@gmail.com)
 * (c) Reinhold Plösch, 2020
 */
package at.jku.se.diary;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.scene.image.Image;

public class HelloFX extends Application {

    Button button;

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

        StackPane layout = new StackPane();

        Scene scene = new Scene(layout, 640, 480);
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
        button.setFont(Font.font("Arial", 40));
        layout.setAlignment(Pos.CENTER_RIGHT);
        layout.getChildren().addAll(button);
        stage.setScene(scene);

        stage.setTitle("DIARY_FX");
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
