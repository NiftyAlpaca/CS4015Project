package cs4015project;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Hyperlink;

import java.util.ArrayList;

public class Album {
    protected SimpleStringProperty titleProperty,publishDateProperty;
    protected SimpleObjectProperty<Artist> artistProperty;
    protected SimpleListProperty<Song> trackListProperty;

    protected Hyperlink link;

    public Album(String title, String publishDate, Artist artist){
        this.titleProperty = new SimpleStringProperty(title);
        this.publishDateProperty = new SimpleStringProperty(publishDate);
        this.artistProperty = new SimpleObjectProperty<Artist>(artist);

        ArrayList<Song> list = new ArrayList<>();
        ObservableList<Song> observableList = (ObservableList<Song>) FXCollections.observableArrayList(list);
        trackListProperty = new SimpleListProperty<Song>(observableList);

    }

    public SimpleListProperty<Song> trackListProperty() {return trackListProperty;}

    public SimpleObjectProperty<Artist> artistObjectProperty(){return artistProperty;};

    public String getAlbumInfo(){
        return artistProperty.get().nameProperty.get() + " - " + publishDateProperty.get() + " - " + trackListProperty().size() + " songs";
    }


}
