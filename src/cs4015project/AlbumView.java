package cs4015project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AlbumView {
    public static void  display(Album album){
        Stage popup = new Stage();
        popup.setTitle(album.titleProperty.get());

        Label albumName = new Label(album.titleProperty.get());
        albumName.setFont(new Font(20));
        albumName.setStyle("-fx-font-weight: bold");
        Label info = new Label(album.getAlbumInfo());

        Button exit = new Button("Exit");
        Button add = new Button("Add Song");
        Button remove = new Button("Remove Album");

        HBox hBox = new HBox(exit, add, remove);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        TableView<Song> tracks = new TableView<Song>();
        tracks.setEditable(false);

        TableColumn titleCol = new TableColumn("TITLE");
        titleCol.setMinWidth(300);
        titleCol.setCellValueFactory(
                new PropertyValueFactory<>("titleProperty"));
        TableColumn artistCol = new TableColumn("ARTIST");
        artistCol.setMinWidth(100);
        artistCol.setCellValueFactory(
                new PropertyValueFactory<>("artistObjectProperty"));
        TableColumn lengthCol = new TableColumn("LENGTH");
        lengthCol.setMinWidth(100);
        lengthCol.setCellValueFactory(
                new PropertyValueFactory<>("lengthProperty"));
        TableColumn removeCol = new TableColumn("");
        removeCol.setMinWidth(100);
        removeCol.setCellValueFactory(
                new PropertyValueFactory<>("removeLinkProperty"));
        TableColumn editCol = new TableColumn("");
        editCol.setMinWidth(100);
        editCol.setCellValueFactory(
                new PropertyValueFactory<>("editLinkProperty"));

        tracks.getColumns().addAll(titleCol,artistCol,lengthCol,removeCol, editCol);
        tracks.setItems(album.trackListProperty());

        VBox vBox = new VBox(albumName,info, tracks, hBox);
        vBox.setSpacing(5);

        exit.setOnAction(e -> popup.close());
        add.setOnAction(e -> AddSongView.display(album));
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                HelloApplication.model.removeAlbum(album);
                popup.close();
            }
        });

        Scene scene = new Scene(vBox, 700, 600);

        popup.setScene(scene);

        popup.showAndWait();



    }

}
