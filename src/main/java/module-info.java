module sample.diaryfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.prefs;
    requires javafx.web;


    opens at.jku.se.diary to javafx.fxml;
    exports at.jku.se.diary;
}