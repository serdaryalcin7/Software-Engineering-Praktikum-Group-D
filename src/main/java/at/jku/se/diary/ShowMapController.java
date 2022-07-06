package at.jku.se.diary;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ShowMapController extends Controller implements Initializable {

    @FXML
    private Button back;

    @FXML
    private WebView wv;

    private WebEngine engine;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.engine = this.wv.getEngine();
        this.engine.load("https://www.google.at/maps/dir/Wels/+/Linz/+/Salzburg/+/Wien/+/");

    }

    public void backClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

    public WebView getWv() {
        return wv;
    }

    public void setWv(WebView wv) {
        this.wv = wv;
    }

    public WebEngine getEngine() {
        return engine;
    }

    public void setEngine(WebEngine engine) {
        this.engine = engine;
    }

}
