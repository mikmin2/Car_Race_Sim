module com.mikmin.car_race_sim {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mikmin.car_race_sim to javafx.fxml;
    exports com.mikmin.car_race_sim;
}
