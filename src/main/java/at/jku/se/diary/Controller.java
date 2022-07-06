package at.jku.se.diary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private TableView<DiaryEntry> entryTableView;
    @FXML
    private TableColumn<DiaryEntry,String> titleCol;
    @FXML
    private TableColumn<DiaryEntry,String> locationCol;
    @FXML
    private TableColumn<DiaryEntry,String> dateCol;
    @FXML
    private TableColumn<DiaryEntry,String> textCol;
    @FXML
    private TableColumn<DiaryEntry,String> categoryCol;
    @FXML
    private TableColumn<DiaryEntry,String> descrCol;
    @FXML
    private TableColumn<DiaryEntry,String> starCol;
    @FXML
    private Button addEntry,update,delete, searchEntry, showMap,saveAS;

    static ObservableList<DiaryEntry> diaryEntryList = FXCollections.observableArrayList();
    static DiaryEntry selectedForUpdate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        loadData();
    }

    private void initCol() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        textCol.setCellValueFactory(new PropertyValueFactory<>("text"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        descrCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        starCol.setCellValueFactory(new PropertyValueFactory<>("star"));
    }

    private void loadData() {

        entryTableView.setItems(diaryEntryList);
    }

    @FXML
    public void getAddView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addEntry.fxml"));
        Stage window = (Stage) addEntry.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

    @FXML
    public void showMapClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("showMap.fxml"));
        Stage window = (Stage) showMap.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }
    @FXML
    public void getSearchView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("searchEntry.fxml"));
        Stage window = (Stage) searchEntry.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }

    @FXML
    private void deleteClicked() {
        ObservableList<DiaryEntry> allEntries, entrySelected;
        allEntries = entryTableView.getItems();
        entrySelected = entryTableView.getSelectionModel().getSelectedItems();
        entrySelected.forEach(allEntries::remove);
    }

    public void updateClicked() throws IOException{

        selectedForUpdate = entryTableView.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("addEntry.fxml"));
        Parent root = loader.load();
        Stage window = (Stage) update.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));

        EntryController controller = (EntryController) loader.getController();
        controller.showDiaryEntry(selectedForUpdate);
    }

    @FXML

    private void handleSaveAs() {
        Window stage = entryTableView.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }

            savePersonDataToFile(file);
        }
    }

    public void savePersonDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(MyWrapperForList.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            MyWrapperForList wrapper = new MyWrapperForList();
            wrapper.setDiaryEntries(diaryEntryList);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }


}