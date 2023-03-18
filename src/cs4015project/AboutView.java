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

public class AboutView {

    public static void display(){
        Stage popup = new Stage();
        popup.setTitle("About");

        Rectangle logo = new Rectangle(0,0,100,100);
        logo.setFill(Color.CRIMSON);

        Font header1 = Font.font(null, FontWeight.BOLD, null,20);
        Label name = new Label("Colton Coughlin");
        name.setFont(header1);

        Button exit = new Button("Close");
        exit.setOnAction(e-> popup.close());

        VBox vBox = new VBox(logo,name);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        VBox vBox2 = new VBox(vBox, exit);
        vBox2.setAlignment(Pos.CENTER);
        vBox2.setSpacing(50);


        Scene scene = new Scene(vBox2, 500, 500);

        popup.setScene(scene);

        popup.showAndWait();


    }

}
