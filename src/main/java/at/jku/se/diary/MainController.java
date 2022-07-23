package at.jku.se.diary;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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

/**
 * @author Team-D
 * overview of the Diary
 * all Buttons to navigate to other scenes + map view
 * Overview of Entries
 * Filter options
 */
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
        private Button clearButton;
        @FXML
        private Button searchButton;
        @FXML
        private Button createButton;
        @FXML
        private Button showButton;
        @FXML
        private Button deleteButton;
        @FXML
        private Button showMapButton;
        @FXML
        private Button saveAsButton;
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

        public static ObservableList<DiaryEntry> diaryEntryList = FXCollections.observableArrayList();
        public static DiaryEntry selectedForUpdate;

        /**
         * Initializes the controller class.
         */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {


                entryTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

                titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
                locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
                dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
                textCol.setCellValueFactory(new PropertyValueFactory<>("text"));

                entryTableView.setItems(diaryEntryList);

                starsearch.getItems().addAll("1", "2", "3", "4", "5");
                categorysearch.getItems().addAll("Hotel", "Restaurant","Shopping");

                titlesearch.setText("");
                locationsearch.setText("");
                startsearch.setValue(LocalDate.of(2022, 01, 01));
                utilsearch.setValue(LocalDate.of(2023,01,01));
                textsearch.setText("");
                categorysearch.setValue("");
                descrsearch.setText("");
                starsearch.setValue("");

                FilteredList<DiaryEntry> filterList = new FilteredList<>(diaryEntryList);

                filterList.predicateProperty().bind(Bindings.createObjectBinding(()
                                -> Entries ->
                                (Entries.getTitle().toLowerCase().contains(titlesearch.getText().toLowerCase()))
                                        && ((Entries.getLocation().toLowerCase().contains(locationsearch.getText().toLowerCase())) || (locationsearch.getText().isEmpty()))
                                        && (Entries.getDate().isAfter(startsearch.getValue()) || (Entries.getDate().isEqual(startsearch.getValue())))
                                        && (Entries.getDate().isBefore(utilsearch.getValue()) || (Entries.getDate().isEqual(utilsearch.getValue())))
                                        && ((Entries.getText().toLowerCase().contains(textsearch.getText().toLowerCase())) || (textsearch.getText().isEmpty()))
                                        && (Entries.categoryFilter(Entries.getCategoryEntries(), categorysearch.getValue()) || (categorysearch.getValue().isEmpty()))
                                        && (Entries.descriptionFilter(Entries.getCategoryEntries(), descrsearch.getText())|| (descrsearch.getText().isEmpty()))
                                        && (Entries.starFilter(Entries.getCategoryEntries(), starsearch.getValue())|| (starsearch.getValue().isEmpty())),

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

        /**
         * This method will use different search terms
         * when the searchButton is pushed
         */
        @FXML
        public void searchButtonClicked(){

                titlesearch.setText(titlesearch.getText());
        }

        /**
         * This method will clear the search bar content
         * when the clearButton is pushed
         */
        @FXML
        public void clearButtonClicked(){

                titlesearch.setText("");
                locationsearch.setText("");
                startsearch.setValue(LocalDate.of(2022, 01, 01));
                utilsearch.setValue(LocalDate.of(2023,01,01));
                textsearch.setText("");
                categorysearch.setValue("");
                descrsearch.setText("");
                starsearch.setValue("");
        }

        /**
         * This method will switch to the createNewEntry scene
         * when the createButton is pushed
         * @throws IOException
         */
        @FXML
        public void createButtonClicked() throws IOException {

                Parent root = FXMLLoader.load(getClass().getResource("createNewEntry.fxml"));
                Stage window = (Stage) createButton.getScene().getWindow();
                window.setScene(new Scene(root, 1000, 700));

        }

        /**
         * If the showButton button is pushed,
         * pass the selected DiaryEntry to the createNewEntry and preload it with the data
         * @throws IOException
         */
        @FXML
        public void showButtonClicked() throws IOException {

                selectedForUpdate = entryTableView.getSelectionModel().getSelectedItem();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("createNewEntry.fxml"));
                Parent root = loader.load();
                Stage window = (Stage) showButton.getScene().getWindow();
                window.setScene(new Scene(root, 1000, 700));

                CreateNewEntryController controller = (CreateNewEntryController) loader.getController();
                controller.showDiaryEntry(selectedForUpdate);
        }

        /**
         * If the deleteButton button is pushed,
         * remove the selected DiaryEntry from the TableView
         */
        @FXML
        public void deleteButtonClicked(){
                
                selectedForUpdate = entryTableView.getSelectionModel().getSelectedItem();
                diaryEntryList.remove(selectedForUpdate);
                entryTableView.setItems(diaryEntryList);
        }

        /**
         * If the showMapButton button is pushed,
         * this method will open a new scene - showMap
         * Diary entries will be displayed on a map
         * @throws IOException
         */
        @FXML
        public void showMapButtonClicked() throws IOException {

                for (DiaryEntry item : entryTableView.getItems()) {

                        ShowMapController.locations.add(locationCol.getCellObservableValue(item).getValue());
                }

                FXMLLoader loader = new FXMLLoader(getClass().getResource("showMap.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(root,650,500));
                stage.show();
        }

        /**
         * If the saveAsButton button is pushed,
         * save the selected DiaryEntry as an XML file
         */
        @FXML
        public void saveAsButtonClicked(){

                try {
                        selectedForUpdate = entryTableView.getSelectionModel().getSelectedItem();
                        CreateNewEntryController.createXml();
                        CreateNewEntryController.createImagePath();

                }catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Could not save data! Please select an entry");
                        alert.showAndWait();
                }
        }


}
