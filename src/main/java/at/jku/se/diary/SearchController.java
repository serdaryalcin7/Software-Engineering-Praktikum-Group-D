package at.jku.se.diary;

import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController extends Controller implements Initializable {
    @FXML
    private TableView<DiaryEntry> searchTableView;
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
    private TextField titlesearch;
    @FXML
    private TextField locationsearch;
    @FXML
    private TextField textsearch;
    @FXML
    private DatePicker startsearch;
    @FXML
    private DatePicker utilsearch;
    @FXML
    private ComboBox<String> categorysearch;
    @FXML
    private ComboBox<String> starsearch;
    @FXML
    private Button back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        starsearch.getItems().addAll("1","2","3","4","5");
        categorysearch.getItems().addAll("Hotel","Restaurant");

        titleCol.setCellValueFactory(cellData -> cellData.getValue().titleProperty());
        locationCol.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        dateCol.setCellValueFactory(cellData -> cellData.getValue().dateProperty().asString());
        textCol.setCellValueFactory(cellData -> cellData.getValue().textProperty());
        categoryCol.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        starCol.setCellValueFactory(cellData -> cellData.getValue().starProperty());
        searchTableView.setItems(Controller.diaryEntryList);


        FilteredList<DiaryEntry> filterList = new FilteredList<>(diaryEntryList);

        titlesearch.textProperty().addListener((obsVal, oldValue, newValue) -> {
            filterList.setPredicate(entries -> entries.getTitle().contains(titlesearch.getText()));
        });
        locationsearch.textProperty().addListener((obsVal, oldValue, newValue) -> {
            filterList.setPredicate(entries -> entries.getLocation().contains(locationsearch.getText()));
        });
        startsearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
            filterList.setPredicate(entries -> entries.getDate().equals(startsearch.getValue()));
        });
        utilsearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
            filterList.setPredicate(entries -> entries.getDate().equals(utilsearch.getValue()));
        });
        textsearch.textProperty().addListener((obsVal, oldValue, newValue) -> {
            filterList.setPredicate(entries -> entries.getText().contains(textsearch.getText()));
        });
        categorysearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
            filterList.setPredicate(entries -> entries.getCategory().contains(categorysearch.getValue()));
        });
        starsearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
            filterList.setPredicate(entries -> entries.getStar().contains(starsearch.getValue()));
        });

        searchTableView.setItems(filterList);
    }


    @FXML
    public void backClicked() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("mainview.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(root, 800, 500));
    }

}
