package at.jku.se.diary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * opens the window for creating a new entry
 * @author Team-D
 * This class opens the window for creating a new entry with several functions as editing the textfields
 * and adding pictures
 * also opening the map view
 * + creating new categories
 */
public class CreateNewEntryController implements Initializable {
    @FXML
    private TextField titleFld;
    @FXML
    private TextField locationFld;
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
    private Button mapButton;
    @FXML
    private Button backButton;

    static List<String> locationsList = new ArrayList<>();

    FileChooser chooser = new FileChooser();
    DiaryEntry newEntry = new DiaryEntry();
    private ArrayList<CategoryEntry> categoryEntryArrayList = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        starComb.getItems().addAll("1","2","3","4","5");
        categoryComb.getItems().addAll("Hotel","Restaurant","Shopping");

    }

    /**
     *  with this method can choose to use bold or italic to emphasize any paragraph of text
     */
    @FXML
    public void radioClicked(){

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

    /**
     *  this method will manage tags
     *  add new Category in category-Combobox
     */
    @FXML
    public void addInputTOCombo(){

        categoryComb.getItems().add(addCategory.getText());
        addCategory.clear();
    }

    /**
     *  this method will manage tags
     *  remove selected Category in category-Combobox
     */
    @FXML
    public void removeComboBox(){

        categoryComb.getItems().remove(categoryComb.getValue());
    }

    /**
     * If the addCategoryButton button is pushed,
     * add categoryEntry into the TableView
     */
    @FXML
    public void addCategoryButtonClicked(){

        CategoryEntry categoryEntry = new CategoryEntry(categoryComb.getValue(),descFld.getText(),starComb.getValue());
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

    /**
     * If the deleteCategoryButton button is pushed,
     * remove the selected categoryEntry from the TableView
     */
    @FXML
    public void deleteCategoryButtonClicked(){

        int selectedID = categoryTableView.getSelectionModel().getSelectedIndex();
        categoryTableView.getItems().remove(selectedID);
    }

    /**
     * When this button is pushed, a FileChooser object is launched to allow the user to browse for a new image file.
     * When that is complete, it will update the view with a new image
     */
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

    /**
     * When this button is pushed, a FileChooser object is launched to allow the user to browse for a new image file.
     * When that is complete, it will update the view with a new image
     */
    @FXML
    public void addFoto2(){

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

    /**
     * When this button is pushed, a FileChooser object is launched to allow the user to browse for a new image file.
     * When that is complete, it will update the view with a new image
     */
    @FXML
    public void addFoto3(){

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

    /**
     * When this button is pushed, delete the first image
     */
    @FXML
    public void deleteFoto1(){
        img1.setImage(null);
    }

    /**
     * When this button is pushed, delete the second image
     */
    @FXML
    public void deleteFoto2(){
        img2.setImage(null);
    }

    /**
     * When this button is pushed, delete the third image
     */
    @FXML
    public void deleteFoto3(){
        img3.setImage(null);
    }

    /**
     * If the zoomInButton is pushed,
     * this method will open a new scene - fotoZoomIn
     * zoom in on the first image
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
    @FXML
    public void zoomInButton1Clicked() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fotoZoomIn.fxml"));
        Parent root = loader.load();

        String fotopath = img1.getImage().getUrl();

        FotoZoomInController fotoController = loader.getController();
        fotoController.setFotopath(fotopath);

        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    /**
     * If the zoomInButton is pushed,
     * this method will open a new scene - fotoZoomIn
     * zoom in on the second image
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
    @FXML
    public void zoomInButton2Clicked() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fotoZoomIn.fxml"));
        Parent root = loader.load();

        String fotopath = img2.getImage().getUrl();

        FotoZoomInController fotoController = loader.getController();
        fotoController.setFotopath(fotopath);

        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    /**
     * If the zoomInButton is pushed,
     * this method will open a new scene - fotoZoomIn
     * zoom in on the third image
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
    @FXML
    public void zoomInButton3Clicked() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fotoZoomIn.fxml"));
        Parent root = loader.load();

        String fotopath = img3.getImage().getUrl();

        FotoZoomInController fotoController = loader.getController();
        fotoController.setFotopath(fotopath);

        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    /**
     * This method will switch to the mainview scene when the button is pushed
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
    @FXML
    public void backButtonClicked() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
        Stage window = (Stage) backButton.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

    /**
     * This method will try to create a new instance of a DiaryEntry.
     * If the saveButton is pushed, will switch to the mainview scene
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();

        }
    }

    /**
     * This method will show the Details of selected DiaryEntry
     * @param selectedForUpdate selected DiaryEntry from Tableview
     */
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

    /**
     * This method will read from the scene and try to modify the selected DiaryEntry
     * If the editButton is pushed, will switch to the mainview scene
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
    @FXML
    public void editButtonClicked() throws IOException {

        MainController.selectedForUpdate.setTitle(titleFld.getText());
        MainController.selectedForUpdate.setLocation(locationFld.getText());
        MainController.selectedForUpdate.setDate(dateFld.getValue());
        MainController.selectedForUpdate.setText(textFld.getText());

        //Muss alter Daten in CategoryTableView l??schen
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

    /**
     * If the showMapButton button is pushed,
     * this method will open a new scene - showMap
     * selected Diary Entry will be displayed on a map
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
    @FXML
    public void mapButtonClicked() throws IOException {

        String map = locationFld.getText();
        ShowMapController.locations.add(map);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("showMap.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root,650,500));
        stage.show();

    }

    /**
     * This method will create an Xml file
     * @throws ParserConfigurationException
     * @throws TransformerException
     */
    public static void createXml() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        document.setXmlStandalone(true);

        Element diaryEntry = document.createElement("diaryEntry");

        Element title = document.createElement("titile");
        title.setTextContent(MainController.selectedForUpdate.getTitle());
        diaryEntry.appendChild(title);

        Element location = document.createElement("location");
        location.setTextContent(MainController.selectedForUpdate.getLocation());
        diaryEntry.appendChild(location);

        Element date = document.createElement("date");
        date.setTextContent(MainController.selectedForUpdate.getDate().toString());
        diaryEntry.appendChild(date);

        Element text = document.createElement("text");
        text.setTextContent(MainController.selectedForUpdate.getText());
        diaryEntry.appendChild(text);

        if(MainController.selectedForUpdate.getCategoryEntries()!=null){
            for(int i=0; i<MainController.selectedForUpdate.getCategoryEntries().size();i++){
                Element categoryentry = document.createElement("categoryentry");
                Element category = document.createElement("category");
                category.setTextContent(MainController.selectedForUpdate.getCategoryEntries().get(i).getCategory());
                categoryentry.appendChild(category);

                Element descr = document.createElement("descr");
                descr.setTextContent(MainController.selectedForUpdate.getCategoryEntries().get(i).getDescription());
                categoryentry.appendChild(descr);

                Element star = document.createElement("star");
                star.setTextContent(MainController.selectedForUpdate.getCategoryEntries().get(i).getStar());
                categoryentry.appendChild(star);

                diaryEntry.appendChild(categoryentry);
            }
        }
        Element imagepath = document.createElement("imagepath");
        imagepath.setTextContent("imagePath.txt");
        diaryEntry.appendChild(imagepath);

        document.appendChild(diaryEntry);

        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");

        FileChooser fileChooser = new FileChooser();
        Stage primaryStage = new Stage();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showSaveDialog(primaryStage);
        tf.transform(new DOMSource(document), new StreamResult(file));
    }

    /**
     * This method will create a txt-file, to save the path of images
     * @throws IOException whenever an input or output operation is failed or interpreted
     */
    public static void createImagePath() throws IOException {

        File imagepath = new File("imagePath.txt");
        FileWriter writer = new FileWriter(imagepath);
        BufferedWriter output = new BufferedWriter(writer);

        String path = MainController.selectedForUpdate.getFotopath1()+"\n"
                +MainController.selectedForUpdate.getFotopath2()+"\n"
                +MainController.selectedForUpdate.getFotopath3();
        output.write(path);
        output.flush();
        output.close();

    }


}



