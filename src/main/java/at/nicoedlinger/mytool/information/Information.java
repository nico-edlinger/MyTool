package at.nicoedlinger.mytool.information;

import at.nicoedlinger.mytool.ui.GUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Information {
    // The stage of the window
    private static final Stage stage = new Stage();
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_HEIGHT = 100;
    private static final int V_SPACE = 10;
    private static final String BACKGROUND_COLOUR = "#8AA8A1";
    private static final String BUTTON_COLOUR = "#EE7B30";
    private static final String FONT_COLOUR = "#FFFFFF";

    /**
     * Helper method to create the elements for the UI
     *
     * @param information_text the text which should be shown
     * @return a list with the elements
     */
    private static List<Control> createElements(String information_text) {
        List<Control> elements = new ArrayList<>();

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> stage.close());
        exitButton.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-font-family: '" + GUI.FONT_FAMILY + "'; -fx-background-color: " + BUTTON_COLOUR + "; -fx-text-fill: " + FONT_COLOUR + ";");

        Label informationTextLabel = new Label(information_text);
        informationTextLabel.setFont(Font.font(GUI.FONT_FAMILY, FontWeight.THIN, WINDOW_WIDTH / 20.0));
        informationTextLabel.setTextFill(Color.web("#FFFFFF"));

        elements.add(informationTextLabel);
        elements.add(exitButton);

        return elements;
    }

    /**
     * Helper method to show a window to enter the username
     */
    public static void showInformationWindow(String information_text) {
        stage.setTitle("Information");

        VBox root = new VBox(V_SPACE);
        root.getChildren().addAll(createElements(information_text));
        root.setOnMouseClicked(event -> root.requestFocus());
        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(V_SPACE, 0, 0, 0));

        root.setStyle("-fx-background-color: " + BACKGROUND_COLOUR + ";");

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.showAndWait();
        stage.setResizable(false);

        root.requestFocus();
    }
}
