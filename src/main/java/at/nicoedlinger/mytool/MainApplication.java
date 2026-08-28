package at.nicoedlinger.mytool;

import at.nicoedlinger.mytool.ui.GUI;
import at.nicoedlinger.mytool.username.Username;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import static at.nicoedlinger.mytool.ui.GUI.*;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox(GUI.V_SPACE);
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        createElements(root, scene);

        if (!Username.usernameExists()) Username.createUsername();
    }
}
