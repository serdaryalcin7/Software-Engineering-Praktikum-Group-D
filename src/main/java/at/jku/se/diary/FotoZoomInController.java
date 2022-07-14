package at.jku.se.diary;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

public class FotoZoomInController {

    @FXML
    private ImageView fotoZoomIn;

    private String fotopath;

    public void setFotopath (String fotopath) {

        this.fotopath = fotopath;
    }

    public void setFotoZoomIn (String fotopath) {

        this.fotoZoomIn.setImage(new Image(fotopath));

    }

    public void initialize() {

        SwingUtilities.invokeLater(() -> setFotoZoomIn(fotopath));
    }


}
