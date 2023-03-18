package cs4015project;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Artist {
    protected SimpleStringProperty nameProperty;
    private SimpleListProperty<Album> albumListProperty;
    private SimpleListProperty <Song> songListProperty;
    public Artist(String name){
        this.nameProperty = new SimpleStringProperty(name);

        ArrayList<Album> list = new ArrayList<>();
        ObservableList<Album> observableList = (ObservableList<Album>) FXCollections.observableArrayList(list);
        albumListProperty = new SimpleListProperty<Album>(observableList);

        ArrayList<Song> list2 = new ArrayList<>();
        ObservableList<Song> observableList2 = (ObservableList<Song>) FXCollections.observableArrayList(list2);
        songListProperty = new SimpleListProperty<Song>(observableList2);
    }

    public SimpleListProperty<Album> albumListProperty() {return albumListProperty;}
    public SimpleListProperty<Song> songListProperty() {return songListProperty;}


}
