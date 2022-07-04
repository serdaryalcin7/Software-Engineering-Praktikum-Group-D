module sample.diaryfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens at.jku.se.diary to javafx.fxml;
    exports at.jku.se.diary;
}