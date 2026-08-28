package at.nicoedlinger.mytool.information;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Information {
    /**
     * The stage of the window
     */
    private static final Stage stage = new Stage();

    /**
     * Helper method to create the UI elements for the window
     *
     * @return a list with the elements
     */
    private static List<Control> createElements(String information_text) {
        List<Control> elements = new ArrayList<>();

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> stage.close());

        elements.add(new Label(information_text));
        elements.add(exitButton);

        return elements;
    }

    /**
     * Helper method to show a window to enter the username
     */
    public static void showInformationWindow(String information_text) {
        stage.setTitle("Information");

        VBox root = new VBox(10);
        root.getChildren().addAll(createElements(information_text));
        root.setOnMouseClicked(event -> root.requestFocus());

        Scene scene = new Scene(root, 300, 100);
        stage.setScene(scene);
        stage.showAndWait();
        stage.setResizable(false);

        root.requestFocus();
    }
}
