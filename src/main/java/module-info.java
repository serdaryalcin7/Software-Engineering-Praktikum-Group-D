module sample.diaryfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens sample.diaryfx to javafx.fxml;
    exports sample.diaryfx;
}