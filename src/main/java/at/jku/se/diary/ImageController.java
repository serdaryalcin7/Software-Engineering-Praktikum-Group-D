package at.jku.se.diary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ImageController{
    @FXML
    private ImageView image;
    @FXML
    private Button back;

    @FXML
    public void getImage() {
        image.setImage(EntryController.imageView.getImage());
    }

    @FXML
    public void backClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addEntry.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root, 500, 650));
    }

}
