package at.jku.se.diary;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
        @FXML
        private TableView<DiaryEntry> entryTableView;
        @FXML
        private TableColumn<DiaryEntry, String> titleCol;
        @FXML
        private TableColumn<DiaryEntry, String> locationCol;
        @FXML
        private TableColumn<DiaryEntry, LocalDate> dateCol;
        @FXML
        private TableColumn<DiaryEntry, String> textCol;
        @FXML
        private Button createButton;
        @FXML
        private Button showButton;
        @FXML
        private Button deleteButton;
        @FXML
        private Button mapButton;
        @FXML
        private Button saveButton;
        @FXML
        private TextField titlesearch;
        @FXML
        private TextField locationsearch;
        @FXML
        private DatePicker startsearch;
        @FXML
        private DatePicker utilsearch;
        @FXML
        private TextField textsearch;
        @FXML
        private ComboBox<String> categorysearch;
        @FXML
        private TextField descrsearch;
        @FXML
        private ComboBox<String> starsearch;
        @FXML
        private Button searchButton;
        @FXML
        private Button clearButton;

        static ObservableList<DiaryEntry> diaryEntryList = FXCollections.observableArrayList();
        static DiaryEntry selectedForUpdate;

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
                locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text"));

                entryTableView.setItems(diaryEntryList);

                starsearch.getItems().addAll("1", "2", "3", "4", "5");
                categorysearch.getItems().addAll("Hotel", "Restaurant","Shopping");
/*
                FilteredList<DiaryEntry> filterList = new FilteredList<>(diaryEntryList);

                titlesearch.textProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.getTitle().toLowerCase().contains(titlesearch.getText().toLowerCase()));
                });
                locationsearch.textProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.getLocation().toLowerCase().contains(locationsearch.getText().toLowerCase()));
                });
                startsearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.getDate().equals(startsearch.getValue()) || entries.getDate().isAfter(startsearch.getValue()));
                });
                utilsearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.getDate().equals(utilsearch.getValue()) || entries.getDate().isBefore(utilsearch.getValue()));
                });
                textsearch.textProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.getText().toLowerCase().contains(textsearch.getText().toLowerCase()));
                });
                categorysearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.categoryFilter(entries.getCategoryEntries(), categorysearch.getValue()));
                });
                descrsearch.textProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.descriptionFilter(entries.getCategoryEntries(), descrsearch.getText()));
                });
                starsearch.valueProperty().addListener((obsVal, oldValue, newValue) -> {
                        filterList.setPredicate(entries -> entries.starFilter(entries.getCategoryEntries(), starsearch.getValue()));
                });

                entryTableView.setItems(filterList);


 */
        }

        @FXML
        void searchButtonClicked(ActionEvent event) throws IOException {

                FilteredList<DiaryEntry> filterList = new FilteredList<>(diaryEntryList);

                filterList.predicateProperty().bind(Bindings.createObjectBinding(() -> diaryEntry ->
                                ((diaryEntry.getTitle().toLowerCase().contains(titlesearch.getText().toLowerCase())) || (titlesearch.getText().isEmpty()))
                                        && ((diaryEntry.getLocation().toLowerCase().contains(locationsearch.getText().toLowerCase())) || (locationsearch.getText().isEmpty()))
                                        && (diaryEntry.getDate().isAfter(startsearch.getValue()) || (diaryEntry.getDate().isEqual(startsearch.getValue())) || (startsearch.getValue().equals(null)))
                                        && (diaryEntry.getDate().isBefore(utilsearch.getValue()) || diaryEntry.getDate().isEqual(utilsearch.getValue()) || (utilsearch.getValue().equals(null)))
                                        && ((diaryEntry.getText().toLowerCase().contains(textsearch.getText().toLowerCase())) || (textsearch.getText().isEmpty()))
                                        && (diaryEntry.categoryFilter(diaryEntry.getCategoryEntries(), categorysearch.getValue()) || (categorysearch.getValue().isEmpty())
                                        && ((diaryEntry.descriptionFilter(diaryEntry.getCategoryEntries(), descrsearch.getText())) || (descrsearch.getText().isEmpty()))
                                        && (diaryEntry.starFilter(diaryEntry.getCategoryEntries(), starsearch.getValue()) || (starsearch.getValue().isEmpty()))),

                        titlesearch.textProperty(),
                        locationsearch.textProperty(),
                        startsearch.converterProperty(),
                        utilsearch.converterProperty(),
                        textsearch.textProperty(),
                        categorysearch.converterProperty(),
                        descrsearch.textProperty(),
                        starsearch.converterProperty()
                ));

                entryTableView.setItems(filterList);

        }

        @FXML
        void clearButtonClicked(ActionEvent event) throws IOException {

                titlesearch.clear();
                locationsearch.clear();

        }

        @FXML
        void createButtonClicked(ActionEvent event) throws IOException {

                Parent root = FXMLLoader.load(getClass().getResource("createNewEntry.fxml"));
                Stage window = (Stage) createButton.getScene().getWindow();
                window.setScene(new Scene(root, 1000, 700));

        }

        @FXML
        void showButtonClicked(ActionEvent event) throws IOException {

                selectedForUpdate = entryTableView.getSelectionModel().getSelectedItem();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("createNewEntry.fxml"));
                Parent root = loader.load();
                Stage window = (Stage) showButton.getScene().getWindow();
                window.setScene(new Scene(root, 1000, 700));

                CreateNewEntryController controller = (CreateNewEntryController) loader.getController();
                controller.showDiaryEntry(selectedForUpdate);
        }

        @FXML
        void deleteButtonClicked(ActionEvent event) throws IOException {

                int selectedID = entryTableView.getSelectionModel().getSelectedIndex();
                entryTableView.getItems().remove(selectedID);

        }






}
