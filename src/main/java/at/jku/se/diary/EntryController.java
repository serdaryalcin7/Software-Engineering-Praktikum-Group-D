package at.jku.se.diary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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
    private RadioButton bold, italic;
    @FXML
    private DatePicker dateFld;
    @FXML
    private ComboBox<String> categoryComb;
    @FXML
    private TextField addCategory;
    @FXML
    private ComboBox<String> starComb;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private Button zoom1,zoom2,zoom3;
    @FXML
    private Button back;

    FileChooser chooser = new FileChooser();
    static ImageView imageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        starComb.getItems().addAll("1","2","3","4","5");
        categoryComb.getItems().addAll("Hotel","Restaurant");

       // img1.setImage(new Image("src/main/java/at/jku/se/diary/addfoto.png"));

    }

    @FXML
    public void radioClicked(ActionEvent event){

        String text = textFld.getText();

        if(bold.isSelected() && italic.isSelected()){
            textFld.setFont(Font.font(text,FontWeight.BOLD, FontPosture.ITALIC,13));
        }
        else if(italic.isSelected()) {
            textFld.setFont(Font.font(text, FontPosture.ITALIC, 13));
        }
        else if(bold.isSelected()){
                textFld.setFont(Font.font(text, FontWeight.BOLD,13));
        }else{
            textFld.setFont(Font.font(text,13));
        }
    }

    @FXML
    public void addInputTOCombo(ActionEvent event){
        categoryComb.getItems().add(addCategory.getText());
        addCategory.clear();
    }
    @FXML
    public void removeComboBox(ActionEvent event){
        categoryComb.getItems().remove(categoryComb.getValue());
    }

    @FXML
    public void addFoto1(){
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.getExtensionFilters().clear();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpeg",".gif"));

        File file = chooser.showOpenDialog(null);
        if(file!=null){
            img1.setImage(new Image(file.toURI().toString()));
            imageView=img1;
        }else{
            System.out.println("...");
        }
    }

    @FXML
    public void addFoto2(ActionEvent event){
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.getExtensionFilters().clear();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpeg",".gif"));

        File file = chooser.showOpenDialog(null);
        if(file!=null){
            img2.setImage(new Image(file.toURI().toString()));
        }else{
            System.out.println("...");
        }
    }

    @FXML
    public void addFoto3(ActionEvent event){
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.getExtensionFilters().clear();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpeg",".gif"));

        File file = chooser.showOpenDialog(null);
        if(file!=null){
            img3.setImage(new Image(file.toURI().toString()));
        }else{
            System.out.println("...");
        }
    }

    @FXML
    public void deleteFoto1(ActionEvent event){
        img1.setImage(null);
    }
    @FXML
    public void deleteFoto2(ActionEvent event){
        img2.setImage(null);
    }
    @FXML
    public void deleteFoto3(ActionEvent event){
        img3.setImage(null);
    }

    public void imageZoom1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("imageview.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) zoom1.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

         ImageController controller = loader.getController();
         controller.getImage();
    }

    public void imageZoom2() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("imageview.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) zoom2.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

        ImageController controller = loader.getController();
        controller.getImage();
    }

    public void imageZoom3() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("imageview.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) zoom3.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));

        ImageController controller = loader.getController();
        controller.getImage();
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

        img1.setImage(null);
        img2.setImage(null);
        img3.setImage(null);

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




