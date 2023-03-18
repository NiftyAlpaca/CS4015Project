package cs4015project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddSongView {

    public static void display(Album album){
        Stage popup = new Stage();
        popup.setTitle("Add Song");

        VBox newSongFields = new VBox();

        HBox title = new HBox();
        Label titleLabel = new Label("Title: ");
        TextField titleField = new TextField();
        title.getChildren().addAll(titleLabel, titleField);
        title.setSpacing(5);
        title.setAlignment(Pos.CENTER);

        HBox artist = new HBox();
        Label artistLabel = new Label("Artist: ");
        TextField artistField = new TextField(album.artistProperty.get().nameProperty.get());
        artistField.setDisable(true);
        artist.getChildren().addAll(artistLabel, artistField);
        artist.setSpacing(5);
        artist.setAlignment(Pos.CENTER);

        HBox releaseDate = new HBox();
        Label releaseLabel = new Label("Release Date (YYYY): ");
        TextField releaseField = new TextField(album.publishDateProperty.get());
        releaseField.setDisable(true);
        releaseDate.getChildren().addAll(releaseLabel,releaseField);
        releaseDate.setSpacing(5);
        releaseDate.setAlignment(Pos.CENTER);

        HBox length = new HBox();
        Label lengthLabel = new Label("Length (00:00): ");
        TextField lengthField = new TextField();
        length.getChildren().addAll(lengthLabel,lengthField);
        length.setSpacing(5);
        length.setAlignment(Pos.CENTER);

        HBox albumBox = new HBox();
        Label albumLabel = new Label("Album: ");
        TextField albumField = new TextField(album.titleProperty.get());
        albumField.setDisable(true);
        albumBox.getChildren().addAll(albumLabel, albumField);
        albumBox.setSpacing(5);
        albumBox.setAlignment(Pos.CENTER);

        Label error = new Label();

        Button add = new Button("Add");
        add.setOnAction(e -> HelloApplication.controller.addSong(titleField.getText(), album, lengthField.getText(),error, popup));

        newSongFields.getChildren().addAll(title, artist, albumBox, releaseDate, length, add, error);
        newSongFields.setSpacing(15);
        newSongFields.setAlignment(Pos.CENTER);

        Scene scene = new Scene(newSongFields, 600, 400);

        popup.setScene(scene);

        popup.showAndWait();
    }

}
