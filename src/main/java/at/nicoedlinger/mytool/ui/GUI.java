package at.nicoedlinger.mytool.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GUI {
    // static variables to simplify styling
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    public static final int H_SPACE = WINDOW_WIDTH / 32;
    public static final int V_SPACE = WINDOW_HEIGHT / 16;
    public static final String FONT_FAMILY = "Comic Sans MS";

    /**
     * Helper method to create the elements for the UI
     * @param root the root of the window
     * @param scene the scene of the window
     */
    public static void createElements(VBox root, Scene scene) {
        HBox headlineBox = new HBox(H_SPACE);

        HBox buttonBox = new HBox(H_SPACE);
        buttonBox.getChildren().addAll(Functions.getButtons(scene));

        Label headline = new Label("My Tool");
        headline.setFont(Font.font(FONT_FAMILY, FontWeight.BOLD, WINDOW_WIDTH / 20.0));

        root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(WINDOW_HEIGHT / 16.0, H_SPACE, V_SPACE, H_SPACE));

        root.setStyle("-fx-background-color: #8AA8A1;");

        root.getChildren().addAll(headline, buttonBox);
    }
}
