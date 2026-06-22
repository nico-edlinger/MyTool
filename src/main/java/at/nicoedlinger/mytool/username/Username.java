package at.nicoedlinger.mytool.username;

import at.nicoedlinger.mytool.logger.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Username {
    /**
     * The path to the file where the username is saved
     */
    private static final String PATH = "src\\main\\resources\\username.txt";
    /**
     * The TextField where the username has to be entered
     */
    private static TextField usernameField;
    /**
     * The stage of the window
     */
    private static final Stage stage = new Stage();

    /**
     * Method to get the saved username
     *
     * @return the saved username
     */
    public static String getUsername() {
        if (!usernameExists()) createUsername();
        return readOutUsername();
    }

    /**
     * The user is required to enter a username, which is then saved to a file
     */
    public static void createUsername() {
        showWindow();
    }

    /**
     * Helper method to show a window to enter the username
     */
    private static void showWindow() {
        stage.setTitle("Username");

        VBox root = new VBox(10);
        root.getChildren().addAll(createElements());
        root.setOnMouseClicked(event -> root.requestFocus());

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.showAndWait();

        root.requestFocus();
    }

    /**
     * Method to save the entered username in a file
     */
    private static void saveUsername() {
        String username = usernameField.getText();

        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))) {
                writer.write(username);
                writer.newLine();
            }
        } catch (Exception e) {
            Logger.log(e.getMessage());
        }

        stage.close();
    }

    /**
     * Helper method to create the UI elements for the window
     *
     * @return a list with the elements
     */
    private static List<Control> createElements() {
        List<Control> elements = new ArrayList<>();

        usernameField = new TextField();
        usernameField.setPromptText("Your username...");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> saveUsername());

        elements.add(new Label("Enter your username:"));
        elements.add(usernameField);
        elements.add(saveButton);

        return elements;
    }

    /**
     * Helper method to check if a username is already saved in a file
     *
     * @return {@code true} or {@code false} whether the name is saved or not
     */
    public static boolean usernameExists() {
        return readOutUsername() != null;
    }

    /**
     * Helper method to read out the username from the file.
     *
     * @return {@code null} if the username doesn't exist <br>
     * the {@code username} if it exists
     */
    private static String readOutUsername() {
        String username = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            username = reader.readLine();
        } catch (Exception e) {
            // username doesn't exist -> null
        }

        return username;
    }
}
