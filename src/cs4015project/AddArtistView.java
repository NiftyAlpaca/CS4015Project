package cs4015project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//NEED TO FORCE NEW ALBUM AND SONG
public class AddArtistView {
    public static void display(){
        Stage popup = new Stage();
        popup.setTitle("Add Artist");

        //VBox for putting in Artist information
        VBox newArtistFields = new VBox(15);

        HBox name = new HBox();
        name.setAlignment(Pos.CENTER);
        Label nameLabel = new Label("Name: ");
        TextField nameField = new TextField();
        name.getChildren().addAll(nameLabel, nameField);
        name.setSpacing(5);

        Label error = new Label();
        error.setTextFill(Color.color(1,0,0));

        Button next1 = new Button("Next");

        newArtistFields.getChildren().addAll(name, next1, error);
        newArtistFields.setAlignment(Pos.CENTER);

        Scene scene = new Scene(newArtistFields, 600, 400);

        //VBox for putting new album information
        VBox newAlbumFields = new VBox(15);

        Label caption = new Label("Add Album to Artist");
        caption.setAlignment(Pos.CENTER);
        caption.setUnderline(true);

        HBox title = new HBox(5);
        Label titleLabel = new Label("Title: ");
        TextField titleField = new TextField();
        title.getChildren().addAll(titleLabel,titleField);
        title.setAlignment(Pos.CENTER);

        HBox publishDate = new HBox(5);
        Label publishTitle = new Label("Publish Date (YYYY): ");
        TextField publishField = new TextField();
        publishDate.getChildren().addAll(publishTitle, publishField);
        publishDate.setAlignment(Pos.CENTER);

        Button next2 = new Button("Next");
        next2.setAlignment(Pos.CENTER);

        newAlbumFields.getChildren().addAll(caption, title, publishDate, next2);
        newAlbumFields.setAlignment(Pos.CENTER);

        Scene scene2 = new Scene(newAlbumFields,600,400);

        //VBox for adding song to new album of new artist
        VBox newSongFields = new VBox();

        Label caption2 = new Label("Add Song to New Album");
        caption2.setAlignment(Pos.CENTER);
        caption2.setUnderline(true);

        HBox title2 = new HBox();
        Label titleLabel2 = new Label("Title: ");
        TextField titleField2 = new TextField();
        title2.getChildren().addAll(titleLabel2, titleField2);
        title2.setSpacing(5);
        title2.setAlignment(Pos.CENTER);

        HBox releaseDate = new HBox();
        Label releaseLabel = new Label("Release Date (YYYY): ");
        TextField releaseField = new TextField();
        releaseDate.getChildren().addAll(releaseLabel,releaseField);
        releaseDate.setSpacing(5);
        releaseDate.setAlignment(Pos.CENTER);

        HBox length = new HBox();
        Label lengthLabel = new Label("Length (00:00): ");
        TextField lengthField = new TextField();
        length.getChildren().addAll(lengthLabel,lengthField);
        length.setSpacing(5);
        length.setAlignment(Pos.CENTER);

        Button add = new Button("Add");
        add.setAlignment(Pos.CENTER);

        newSongFields.getChildren().addAll(caption2, title2, releaseDate, length, add, error);
        newSongFields.setSpacing(15);
        newSongFields.setAlignment(Pos.CENTER);

        Scene scene3 = new Scene(newSongFields,600,400);


        next1.setOnAction(e -> popup.setScene(scene2));
        next2.setOnAction(e -> popup.setScene(scene3));
        add.setOnAction(e -> HelloApplication.controller.addArtist(nameField.getText(), titleField.getText(), publishField.getText(), titleField2.getText(), releaseField.getText(), lengthField.getText(), error, popup));
        popup.setScene(scene);

        popup.showAndWait();
    }


}
