package at.nicoedlinger.mytool.ui;

import at.nicoedlinger.mytool.clean_up.Desktop;
import at.nicoedlinger.mytool.clean_up.Downloads;
import at.nicoedlinger.mytool.recycle_bin.RecycleBin;
import at.nicoedlinger.mytool.screenshots.Screenshots;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Functions {
    // buttons to do the wanted operation
    private static final Button screenshotsButton = new Button("Delete\nScreenshots");
    private static final Button downloadsButton = new Button("Clean up\nDownloads");
    private static final Button desktopButton = new Button("Clean up\nDesktop");
    private static final Button recycleBinButton = new Button("Clean\nRecycle Bin");

    // static variables to arrange the buttons correctly
    private static final int AMOUNT_BUTTONS = 4;
    private static final int AMOUNT_ROWS = 1;

    // static variables with colors for the window
    private static final String BACKGROUND_COLOUR = "#EE7B30";
    private static final String FONT_COLOUR = "white";

    /**
     * Helper method to get the finished buttons
     * @param scene the scene of the window
     * @return a list of all buttons
     */
    protected static List<Button> getButtons(Scene scene) {
        configButton(screenshotsButton, scene);
        configButton(downloadsButton, scene);
        configButton(desktopButton, scene);
        configButton(recycleBinButton, scene);

        addFunctionToScreenshotsButton();
        addFunctionToDownloadsButton();
        addFunctionToDesktopButton();
        addFunctionToRecycleBinButton();

        List<Button> buttons = new ArrayList<>();
        buttons.add(screenshotsButton);
        buttons.add(downloadsButton);
        buttons.add(desktopButton);
        buttons.add(recycleBinButton);

        return buttons;
    }

    /**
     * Helper method for configuring each button
     * @param button the specific button
     * @param scene the scene of the window
     */
    private static void configButton(Button button, Scene scene) {
        // size
        button.prefWidthProperty().bind(scene.widthProperty().divide(AMOUNT_BUTTONS));
        button.prefHeightProperty().bind(scene.heightProperty().divide(AMOUNT_ROWS * 2));

        // style
        button.setStyle("-fx-border-color: black; -fx-border-width: 2px; -fx-font-family: '" + GUI.FONT_FAMILY + "'; -fx-background-color: " + BACKGROUND_COLOUR + "; -fx-text-fill: " + FONT_COLOUR + ";");

    }

    /**
     * Helper method to add the specific function to the button
     */
    private static void addFunctionToScreenshotsButton() {
        screenshotsButton.setOnAction(e -> Screenshots.deleteAll());
    }

    /**
     * Helper method to add the specific function to the button
     */
    private static void addFunctionToDownloadsButton() {
        downloadsButton.setOnAction(e -> Downloads.sort());
    }

    /**
     * Helper method to add the specific function to the button
     */
    private static void addFunctionToDesktopButton() {
        desktopButton.setOnAction(e -> Desktop.sort());
    }

    /**
     * Helper method to add the specific function to the button
     */
    private static void addFunctionToRecycleBinButton() {
        recycleBinButton.setOnAction(e -> RecycleBin.clean());
    }
}
