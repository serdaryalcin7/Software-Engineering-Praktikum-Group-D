package at.jku.se.diary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
    private TableColumn<DiaryEntry,String> starCol;
    @FXML
    private Button addEntry,update,delete, searchEntry, showMap;

    static ObservableList<DiaryEntry> diaryEntryList = FXCollections.observableArrayList();
    static DiaryEntry selectedForUpdate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initCol();
        loadData();
    }

    private void initCol() {
        titleCol.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        locationCol.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty().asString());
        textCol.setCellValueFactory(cellData -> cellData.getValue().textProperty());
        categoryCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        starCol.setCellValueFactory(cellData -> cellData.getValue().starProperty());
    }

    private void loadData() {
        //diaryEntryList.add(new DiaryEntry("zoo", "Linz", LocalDate.of(1999, 2, 21), "eggdsafd", "zoo", "3"));
        entryTableView.setItems(diaryEntryList);
    }

    @FXML
    public void getAddView() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addEntry.fxml"));
        Stage window = (Stage) addEntry.getScene().getWindow();
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
    public void showMapClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("showMap.fxml"));
        Stage window = (Stage) showMap.getScene().getWindow();
        window.setScene(new Scene(root, 1000, 700));
    }


}