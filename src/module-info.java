module voidGame {
    requires javafx.fxml;
    requires javafx.controls;
    requires kotlin.stdlib;

    opens sample;
    opens sample.controllers;
    exports sample.controllers;
}