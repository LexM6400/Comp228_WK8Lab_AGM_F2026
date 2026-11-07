package application;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
 * Name: Alexis "Lex" Morales
 * Date: 11/6/2026
 * Student Number: 301 130 521
 * Course: COMP 228 - Sec 004
 */

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // 1. TOP: HBox holds the title and favorite sport image horizontally.
        Label title = new Label("Employment Application");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        HBox header = new HBox(20, title);
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(15));
        header.setStyle("-fx-background-color: #dceeff;");

        // Put basketball.jpg inside src/application.
        URL imageURL = getClass().getResource("Centennial_College_Logo.jpg");

        if (imageURL != null) {
            ImageView sportImage = new ImageView(
                    new Image(imageURL.toExternalForm())
            );
            sportImage.setFitWidth(120);
            sportImage.setFitHeight(80);
            sportImage.setPreserveRatio(true);
            header.getChildren().add(sportImage);
        } else {
            header.getChildren().add(
                    new Label("Add basketball.jpg to src/application")
            );
        }

        // 2. LEFT: VBox stacks the navigation buttons vertically.
        Label menuTitle = new Label("MENU");
        menuTitle.setStyle("-fx-font-weight: bold;");

        Button dashboardButton = new Button("Dashboard");
        Button registrationButton = new Button("Registration");
        Button coursesButton = new Button("Courses");
        Button helpButton = new Button("Help");

        VBox navigation = new VBox(
                12,
                menuTitle,
                dashboardButton,
                registrationButton,
                coursesButton,
                helpButton
        );
        navigation.setPadding(new Insets(15));
        navigation.setPrefWidth(160);
        navigation.setStyle("-fx-background-color: #f1f3f5;");

        // 3. CENTER: GridPane arranges the employment form fields.
        Label formTitle = new Label("Applicant Information");
        formTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your full name");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Enter your phone number");

        TextField positionField = new TextField();
        positionField.setPromptText("Position applying for");

        DatePicker startDatePicker = new DatePicker();

        TextField educationField = new TextField();
        educationField.setPromptText("Highest level of education");

        TextArea experienceField = new TextArea();
        experienceField.setPromptText("Describe your work experience");
        experienceField.setPrefRowCount(3);
        experienceField.setWrapText(true);

        GridPane applicationForm = new GridPane();
        applicationForm.setHgap(12);
        applicationForm.setVgap(12);
        applicationForm.addRow(0, new Label("Full Name:"), nameField);
        applicationForm.addRow(1, new Label("Email:"), emailField);
        applicationForm.addRow(2, new Label("Phone:"), phoneField);
        applicationForm.addRow(3, new Label("Position:"), positionField);
        applicationForm.addRow(
                4, new Label("Available Start Date:"), startDatePicker
        );
        applicationForm.addRow(5, new Label("Education:"), educationField);
        applicationForm.addRow(
                6, new Label("Work Experience:"), experienceField
        );

        CheckBox confirmation = new CheckBox(
                "I confirm that the information above is correct."
        );

        Button sendButton = new Button("Send Application");

        // Clicking this button prints the required message in the Console.
        sendButton.setOnAction(event ->
                System.out.println("Application Sent")
        );

        VBox centerContent = new VBox(
                15,
                formTitle,
                applicationForm,
                confirmation,
                sendButton
        );
        centerContent.setPadding(new Insets(20));

        // 4. BOTTOM: HBox displays today's date.
        String today = LocalDate.now().format(
                DateTimeFormatter.ofPattern("MMMM d, yyyy")
        );

        Label dateLabel = new Label("Today's Date: " + today);

        HBox footer = new HBox(dateLabel);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(15));
        footer.setStyle("-fx-background-color: #dceeff;");

        // 5. BORDERPANE combines the sections into one application window.
        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setLeft(navigation);
        root.setCenter(centerContent);
        root.setBottom(footer);
        root.setStyle("-fx-background-color: white;");

        BorderPane.setMargin(navigation, new Insets(5));
        BorderPane.setMargin(centerContent, new Insets(5));

        Scene scene = new Scene(root, 950, 700);
        stage.setTitle("JavaFX Layout Managers Lab");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}