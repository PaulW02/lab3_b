module com.example.lab3_b {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.lab3_b to javafx.fxml;
    exports com.example.lab3_b;
}