module fitnessTracker2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires lombok;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    opens fitnessTracker2 to javafx.fxml;
    exports fitnessTracker2;
}