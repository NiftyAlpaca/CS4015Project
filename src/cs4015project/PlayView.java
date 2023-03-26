package cs4015project;

import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class PlayView {
    private static SongIterator iterator;

    private static Stage popup;
    private static VBox content;

    private static final Button next = new Button("Next");
    private static final Button prev = new Button("Prev");
    private static final Button close = new Button("Stop");


    private static void changeSong(Song song){
        Text title = new Text("Title: " + song.getTitleProperty());
        Text artist = new Text("Artist: " + song.getArtistObjectProperty());
        Text album = new Text("Album: " + song.getAlbumObjectProperty());
        Text length = new Text("Length: " + song.getLengthProperty());

        BorderPane buttonPane = new BorderPane();
        if(iterator.hasNext()){
            BorderPane.setAlignment(next, Pos.CENTER);
            BorderPane.setMargin(next, new Insets(10,10,10,10));
            buttonPane.setRight(next);
        }
        if(iterator.hasPrev()){
            BorderPane.setAlignment(prev, Pos.CENTER);
            BorderPane.setMargin(prev, new Insets(10,10,10,10));
            buttonPane.setLeft(prev);
        }
        BorderPane.setAlignment(close, Pos.CENTER);
        buttonPane.setBottom(close);

        content.getChildren().setAll(title, artist, album, length, buttonPane);
    }

    public static void display(){
        popup = new Stage();
        popup.setTitle("Playing...");

        content = new VBox(10);
        content.setAlignment(Pos.CENTER);

        close.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                popup.close();
            }
        });

        if (Model.getInstance().getSongCollection().size() > 0){ //Dealing with at least one song
            iterator = new SongIterator();

            next.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    changeSong(iterator.next());
                }
            });

            prev.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    changeSong(iterator.prev());
                }
            });

            changeSong(iterator.getCurrentSong());
        }
        else{
            Text emptyPlaylist = new Text("Error: Empty Playlist");
            content.getChildren().setAll(emptyPlaylist, close);
        }

        Scene scene = new Scene(content, 300, 200);
        popup.setScene(scene);
        popup.showAndWait();

    }

}
