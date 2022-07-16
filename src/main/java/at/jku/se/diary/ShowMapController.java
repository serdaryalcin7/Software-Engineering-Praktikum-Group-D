package at.jku.se.diary;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowMapController implements Initializable {

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


}