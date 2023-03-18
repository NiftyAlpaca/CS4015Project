package cs4015project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AddAlbumView {

    public static void display(Artist artist){
        Stage popup = new Stage();
        popup.setTitle("Add Album");

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

        Label error = new Label();
        error.setTextFill(Color.color(1,0,0));


        newAlbumFields.getChildren().addAll(caption, title, publishDate, next2, error);
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

        Label error2 = new Label();

        newSongFields.getChildren().addAll(caption2, title2, releaseDate, length, add, error2);
        newSongFields.setSpacing(15);
        newSongFields.setAlignment(Pos.CENTER);

        Scene scene3 = new Scene(newSongFields,600,400);

        next2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean notDup = true;
                for(Album a : HelloApplication.model.albumList){
                    if(a.titleProperty.get().compareTo(titleField.getText()) == 0){
                        notDup = false;
                        error.setText("ERROR: Duplicate");
                    }
                }

                if(notDup){
                    popup.setScene(scene3);
                }
            }
        });
        add.setOnAction(e -> HelloApplication.controller.addAlbum(artist, titleField.getText(), publishField.getText(), titleField2.getText(), releaseField.getText(), lengthField.getText(), error2, popup));
        popup.setScene(scene2);

        popup.showAndWait();
    }

}
