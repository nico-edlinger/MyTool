module at.nicoedlinger.mytool {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.nicoedlinger.mytool to javafx.fxml;
    exports at.nicoedlinger.mytool;
}