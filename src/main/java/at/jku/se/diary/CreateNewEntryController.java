package at.jku.se.diary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CreateNewEntryController implements Initializable {

    @FXML
    private TextField titleFld;
    @FXML
    private TextField locationFld;
    @FXML
    private Button mapButton;
    @FXML
    private TextArea textFld;
    @FXML
    private RadioButton bold;
    @FXML
    private RadioButton italic;
    @FXML
    private DatePicker dateFld;
    @FXML
    private ComboBox<String> categoryComb;
    @FXML
    private TextField addCategory;
    @FXML
    private TextArea descFld;
    @FXML
    private ComboBox<String> starComb;
    @FXML
    private Button addCategoryButton,deleteCategoryButton;
    @FXML
    private TableView<CategoryEntry> categoryTableView;
    @FXML
    private TableColumn<CategoryEntry, String> cateCol;
    @FXML
    private TableColumn<CategoryEntry, String> desCol;
    @FXML
    private TableColumn<CategoryEntry, String> ratCol;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private Button saveButton;
    @FXML
    private Button editButton;
    @FXML
    private Button backButton;

    @FXML
    private ShowMapController sm;

    FileChooser chooser = new FileChooser();
    DiaryEntry newEntry = new DiaryEntry();
    private ArrayList<CategoryEntry> categoryEntryArrayList = new ArrayList<>();

    public void initialize(URL url, ResourceBundle resourceBundle) {

        starComb.getItems().addAll("1","2","3","4","5");
        categoryComb.getItems().addAll("Hotel","Restaurant","Shopping");

    }

    @FXML
    public void radioClicked(ActionEvent event){

        String text = textFld.getText();

        if(bold.isSelected() && italic.isSelected()){
            textFld.setFont(Font.font(text, FontWeight.BOLD, FontPosture.ITALIC,13));
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
    public void addInputTOCombo(ActionEvent event) {

            categoryComb.getItems().add(addCategory.getText());
            addCategory.clear();
    }

    @FXML
    public void removeComboBox(ActionEvent event){

        categoryComb.getItems().remove(categoryComb.getValue());
    }

    @FXML
    public void addCategoryButtonClicked() throws EntryNullException {

            CategoryEntry categoryEntry = new CategoryEntry(categoryComb.getValue(), descFld.getText(), starComb.getValue());
            ObservableList<CategoryEntry> categoryEntries = categoryTableView.getItems();
            categoryEntries.add(categoryEntry);
            categoryTableView.setItems(categoryEntries);

            cateCol.setCellValueFactory(new PropertyValueFactory<>("category"));
            desCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            ratCol.setCellValueFactory(new PropertyValueFactory<>("star"));

            categoryEntryArrayList.add(categoryEntry);

            categoryComb.setValue(null);
            descFld.clear();
            starComb.setValue(null);
        }
    @FXML
    public void deleteCategoryButtonClicked(ActionEvent event){

        int selectedID = categoryTableView.getSelectionModel().getSelectedIndex();
        categoryTableView.getItems().remove(selectedID);
    }

    @FXML
    public void addFoto1(){

        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.getExtensionFilters().clear();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.png","*.jpeg",".gif"));

        File file = chooser.showOpenDialog(null);
        if(file!=null){
            img1.setImage(new Image(file.toURI().toString()));
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

    @FXML
    public void zoomInButton1Clicked(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fotoZoomIn.fxml"));
        Parent root = loader.load();

        String fotopath = img1.getImage().getUrl();

        FotoZoomInController fotoController = loader.getController();
        fotoController.setFotopath(fotopath);

        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    @FXML
    public void zoomInButton2Clicked(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fotoZoomIn.fxml"));
        Parent root = loader.load();

        String fotopath = img2.getImage().getUrl();

        FotoZoomInController fotoController = loader.getController();
        fotoController.setFotopath(fotopath);

        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    @FXML
    public void zoomInButton3Clicked(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fotoZoomIn.fxml"));
        Parent root = loader.load();

        String fotopath = img3.getImage().getUrl();

        FotoZoomInController fotoController = loader.getController();
        fotoController.setFotopath(fotopath);

        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    @FXML
    public void backButtonClicked() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

    @FXML
    public void saveButtonClicked() throws IOException {
        try {
            String foto1, foto2, foto3;

            if (img1.getImage() != null) {
                foto1 = img1.getImage().getUrl();
            } else {
                foto1 = "src/main/java/at/jku/se/diary/addfoto.png";
            }

            if (img2.getImage() != null) {
                foto2 = img2.getImage().getUrl();
            } else {
                foto2 = "src/main/java/at/jku/se/diary/addfoto.png";
            }

            if (img3.getImage() != null) {
                foto3 = img3.getImage().getUrl();
            } else {
                foto3 = "src/main/java/at/jku/se/diary/addfoto.png";
            }

            MainController.diaryEntryList.add(newEntry.createNewEntry(titleFld.getText(), locationFld.getText(), dateFld.getValue(),
                    textFld.getText(), categoryEntryArrayList,
                    foto1, foto2, foto3));

            Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
            Stage window = (Stage) saveButton.getScene().getWindow();
            window.setScene(new Scene(root, 1000, 700));
        } catch (EntryNullException e) {
            ErrorMessage.display("Error", e.getMessage());
        }
    }

    public void showDiaryEntry(DiaryEntry selectedForUpdate) {

        titleFld.setText(selectedForUpdate.getTitle());
        locationFld.setText(selectedForUpdate.getLocation());
        dateFld.setValue(selectedForUpdate.getDate());
        textFld.setText(selectedForUpdate.getText());

        categoryTableView.setItems(FXCollections.observableArrayList(selectedForUpdate.getCategoryEntries()));
        cateCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        desCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        ratCol.setCellValueFactory(new PropertyValueFactory<>("star"));

        img1.setImage(new Image(selectedForUpdate.getFotopath1()));
        img2.setImage(new Image(selectedForUpdate.getFotopath2()));
        img3.setImage(new Image(selectedForUpdate.getFotopath3()));

    }

    @FXML
    public void editButtonClicked() throws IOException {

        MainController.selectedForUpdate.setTitle(titleFld.getText());
        MainController.selectedForUpdate.setLocation(locationFld.getText());
        MainController.selectedForUpdate.setDate(dateFld.getValue());
        MainController.selectedForUpdate.setText(textFld.getText());

        //Muss alter Daten in CategoryTableView löschen
        MainController.selectedForUpdate.setCategoryEntries(categoryEntryArrayList);

        if(img1.getImage()!=null) {
            MainController.selectedForUpdate.setFotopath1(img1.getImage().getUrl());
        }else{
            MainController.selectedForUpdate.setFotopath1("src/main/java/at/jku/se/diary/addfoto.png");
        }

        if(img2.getImage()!=null) {
            MainController.selectedForUpdate.setFotopath2(img2.getImage().getUrl());
        }else{
            MainController.selectedForUpdate.setFotopath2("src/main/java/at/jku/se/diary/addfoto.png");
        }

        if(img3.getImage()!=null) {
            MainController.selectedForUpdate.setFotopath3(img3.getImage().getUrl());
        }else{
            MainController.selectedForUpdate.setFotopath3("src/main/java/at/jku/se/diary/addfoto.png");
        }

        Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
        Stage window = (Stage) editButton.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

    @FXML
    public void mapButtonClicked() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("showMap.fxml"));
        Parent root = loader.load();

        String map = MainController.selectedForUpdate.getLocation();

        ShowMapController showMapController = loader.getController();
        showMapController.setLocation(map);


        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();

    }


}


