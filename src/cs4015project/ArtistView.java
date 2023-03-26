package cs4015project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ArtistView {
    public static void display(Artist artist){
        ArrayList<Label> albumLinks = new ArrayList<Label>();
        for(Album a : artist.albumListProperty()){
            Label albumlink = new Label(a.titleProperty.get());
            albumLinks.add(albumlink);

        }

        ArrayList<Label> popular = new ArrayList<Label>();
        //Just pick first 5 songs in song list and present them as popular songs
        for(int i = 0; i < 5; i++){
            if(i == artist.songListProperty().get().size()){
                break;
            }
            Label curr = new Label(artist.songListProperty().get().get(i).titleProperty.get());
            popular.add(curr);
        }

        Font header1 = Font.font(null, FontWeight.BOLD, null,20);
        Font header2 = Font.font(null, FontWeight.BOLD, FontPosture.ITALIC,15);

        Stage popup = new Stage();
        VBox mainVBox = new VBox(5);

        Label artistName = new Label(artist.nameProperty.get());
        artistName.setFont(header1);
        artistName.setUnderline(true);

        Label songs = new Label("Popular: ");
        songs.setFont(header2);
        VBox popularSongs = new VBox(3);
        popularSongs.getChildren().addAll(popular);


        VBox albumHyperlinkList = new VBox(3);
        Label albums = new Label("Discography: ");
        albums.setFont(header2);
        albumHyperlinkList.getChildren().addAll(albumLinks);

        HBox buttons = new HBox(10);

        Button add = new Button("Add Album");
        add.setOnAction(e -> AddAlbumView.display(artist));

        Button remove = new Button("Remove Artist");
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Command removeArtist = new CommandRemoveArtist(artist);
                removeArtist.execute();
                HelloApplication.commandHistory.push(removeArtist);
                popup.close();
            }
        });

        buttons.getChildren().addAll(add,remove);
        buttons.setAlignment(Pos.CENTER);



        mainVBox.getChildren().addAll(artistName,songs,popularSongs, albums, albumHyperlinkList);
        mainVBox.setAlignment(Pos.TOP_LEFT);
        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(mainVBox, buttons);

        Scene scene = new Scene(vBox,500,500);


        popup.setScene(scene);

        popup.showAndWait();
    }

}
