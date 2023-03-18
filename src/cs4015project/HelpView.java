package cs4015project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelpView {
    public static void display(){
        Stage popup = new Stage();
        popup.setTitle("Help");

        Label label = new Label("It's simple. Click links to view more info on an object. Before you add a song, you need to add an album. To add an album, you need to add an artist. Do File -> Refresh after editing a song.");
        label.setAlignment(Pos.CENTER);
        Scene scene = new Scene(label, 900,300);

        popup.setScene(scene);

        popup.showAndWait();
    }

}
