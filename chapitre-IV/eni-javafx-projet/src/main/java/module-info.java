module fr.eni.gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens fr.eni.gui to javafx.fxml;
    exports fr.eni.gui;
}