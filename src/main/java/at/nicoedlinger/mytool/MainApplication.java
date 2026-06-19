package at.nicoedlinger.mytool;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Pane root = new Pane();
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.show();
    }
}
