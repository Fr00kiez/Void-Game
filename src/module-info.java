module voidGame {
    requires javafx.fxml;
    requires javafx.controls;
    requires kotlin.stdlib;
    requires javafx.media;

    opens sample;
    opens sample.controllers;
    exports sample.controllers;
}