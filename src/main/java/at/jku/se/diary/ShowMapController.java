package at.jku.se.diary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShowMapController implements Initializable {

    @FXML
    private Button back;
    @FXML
    private WebView webView;

    private WebEngine webEngine;
    static String location;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.webEngine = this.webView.getEngine();
        this.webEngine.load(getMapString());
    }

    private String getMapString() {

        String map = "https://www.google.at/maps/dir/";
        map += getLocation() + "/+/";
        return map;
    }


    public static String getLocation() {
        return location;
    }

    public static void setLocation(String location) {
        ShowMapController.location = location;
    }

    public void backClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

}
