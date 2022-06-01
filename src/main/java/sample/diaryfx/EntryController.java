package sample.diaryfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EntryController extends Controller implements Initializable {

    @FXML
    private TextField titleFld;
    @FXML
    private TextField locationFld;
    @FXML
    private TextArea textFld;
    @FXML
    private RadioButton blod, italic;
    @FXML
    private DatePicker dateFld;
    @FXML
    private ComboBox<String> categoryComb;
    @FXML
    private ComboBox<String> starComb;
    @FXML
    private Image img1;
    @FXML
    private Image img2;
    @FXML
    private Image img3;
    @FXML
    private Button save;
    @FXML
    private Button back;

    DiaryEntry diaryEntry;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        starComb.getItems().addAll("1","2","3","4","5");
        categoryComb.getItems().addAll("Hotel","Restaurant");
    }

    @FXML
    public void radioClicked(ActionEvent event){

        String text = textFld.getText();

        if(blod.isSelected()){
            textFld.setFont(Font.font(text, FontWeight.BOLD,13));
        }
        else if(italic.isSelected()){
            textFld.setFont(Font.font(text, FontPosture.ITALIC,13));
        }
    }

    @FXML
     public void backClicked() throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
         Stage window = (Stage) back.getScene().getWindow();
         window.setScene(new Scene(root, 800, 500));
    }

    @FXML
    public void saveClicked() {

        String title = titleFld.getText();
        String location =locationFld.getText();
        LocalDate date = dateFld.getValue();
        String text = textFld.getText();
        String category = categoryComb.getValue();
        String star = starComb.getValue();

        Controller.diaryEntryList.add(new DiaryEntry(title,location,date,text,category,star));

        titleFld.clear();
        locationFld.clear();
        dateFld.setValue(null);
        textFld.clear();
        categoryComb.setValue(null);
        starComb.setValue(null);

    }


    @FXML
    private void handleOk() {

        selectedForUpdate.setTitle(titleFld.getText());
        selectedForUpdate.setLocation(locationFld.getText());
        selectedForUpdate.setDate(dateFld.getValue());
        selectedForUpdate.setText(textFld.getText());
        selectedForUpdate.setCategory(categoryComb.getValue());
        selectedForUpdate.setStar(starComb.getValue());
    }

    public void showDiaryEntry(DiaryEntry selectedForUpdate){

        titleFld.setText(selectedForUpdate.getTitle());
        locationFld.setText(selectedForUpdate.getLocation());
        dateFld.setValue(selectedForUpdate.getDate());
        textFld.setText(selectedForUpdate.getText());
        categoryComb.setValue(selectedForUpdate.getCategory());
        starComb.setValue(selectedForUpdate.getStar());

    }
    

}




