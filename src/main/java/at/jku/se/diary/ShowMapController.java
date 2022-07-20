package at.jku.se.diary;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShowMapController implements Initializable {

    @FXML
    private WebView webView;

    private WebEngine webEngine;
    public static List<String> locations = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.webEngine = this.webView.getEngine();
        this.webEngine.load(getMapString());
    }

    private String getMapString() {

        String map = "https://www.google.com/maps/dir/";

            for (int i = 0; i < getLocations().size(); i++) {
                map = map + getLocations().get(i) + "/+/";
            }

            locations.clear();
            return map;
        }



    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
