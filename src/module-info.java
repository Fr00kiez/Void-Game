module voidGame {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.graphics;
    requires kotlin.stdlib;

    opens sample;
    opens sample.controllers;
    exports sample.controllers;
}