package cs4015project;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class RealSongCollection implements SongCollection{
    private SimpleListProperty<Song> songCollection;
    private int result;

    public RealSongCollection(){
        ArrayList<Song> list = new ArrayList<>();
        ObservableList<Song> observableList = (ObservableList<Song>) FXCollections.observableArrayList(list);
        songCollection = new SimpleListProperty<Song>(observableList);
    }

    public Song getSongByIndex(int index){
        return songCollection.get(index);
    }

    public int size(){
        return songCollection.size();
    }

    //Although this function doesn't do some crucial checks (e.g. check if song's album belongs to song's artist)
    //They will not be necessary because the addition of a song will be context specific so that you cannot add a song
    //where it doesn't belong
    public void addSong(Song song){
        if(songCollection.isEmpty()){
            song.AlbumObjectProperty().get().trackListProperty().add(song);
            song.ArtistObjectProperty().get().songListProperty().add(song);
            songCollection.add(song);
            result = 0;
        }
        else{
            for(Song s : songCollection){
                if(s.titleProperty.get().compareTo(song.titleProperty.get()) == 0){
                    result = -1;
                    return;
                }
            }
            song.AlbumObjectProperty().get().trackListProperty().add(song);
            song.ArtistObjectProperty().get().songListProperty().add(song);
            songCollection.add(song);
            result = 0;
        }
    }

    public int RemoveSong(Song song){
        if(songCollection.isEmpty()){
            return -1;
        }
        else if(song.albumObjectProperty.get().trackListProperty.get().size() == 1){
            song.ArtistObjectProperty().get().songListProperty().remove(song);
            song.AlbumObjectProperty().get().trackListProperty().remove(song);
            song.ArtistObjectProperty().get().albumListProperty().remove(song.AlbumObjectProperty().get());
            song.artistObjectProperty.get().albumListProperty().remove(song.AlbumObjectProperty().get());
            songCollection.remove(song);
        }
        song.ArtistObjectProperty().get().songListProperty().remove(song);
        song.AlbumObjectProperty().get().trackListProperty().remove(song);
        songCollection.remove(song);
        return 0;
    }

    public void EditSong(Song song, String newTitle, String newDate, String newLength){
        for(Song s : songCollection){
            if(newTitle.compareTo(song.titleProperty.get()) == 0){
                result = -1;
                return;
            }
        }
        song.setTitle(newTitle);
        song.setDate(newDate);
        song.setLength(newLength);
        result = 0;
    }

    //This wouldn't be a thing if I had it my way but to fill the main table of songs, we need the observable list to
    //apply to it. The single thing we want hidden is the kind of list the table wants in order to have it change values
    //on the spot. Please, try to forget this exists. VIP.
    public SimpleListProperty<Song> getList(){return songCollection;};
}
