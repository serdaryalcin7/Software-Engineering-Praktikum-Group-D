package at.jku.se.diary;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;

/**
 * @author Team-D
 * this class helps zooming added photos
 */
public class FotoZoomInController {

    @FXML
    private ImageView fotoZoomIn;

    private String fotopath;

    /**
     * @param fotopath to set image path
     */
    public void setFotopath (String fotopath) {

        this.fotopath = fotopath;
    }

    /**
     * @param fotopath
     */
    public void setFotoZoomIn (String fotopath) {

        this.fotoZoomIn.setImage(new Image(fotopath));

    }

    /**
     * Initializes the controller class.
     */
    public void initialize() {

        SwingUtilities.invokeLater(() -> setFotoZoomIn(fotopath));
    }


}
