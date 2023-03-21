package cs4015project;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Model {
    private SimpleListProperty<Song> songCollection;

    private static Model instance;
    public SimpleListProperty<Artist> artistList;
    public SimpleListProperty<Album> albumList;

    public int result;

    private Model(){
        ArrayList<Song> list = new ArrayList<>();
        ObservableList<Song> observableList = (ObservableList<Song>) FXCollections.observableArrayList(list);
        songCollection = new SimpleListProperty<Song>(observableList);

        ArrayList<Artist> list2 = new ArrayList<>();
        ObservableList<Artist> observableList2 = (ObservableList<Artist>) FXCollections.observableArrayList(list2);
        artistList = new SimpleListProperty<Artist>(observableList2);

        ArrayList<Album> list3 = new ArrayList<>();
        ObservableList<Album> observableList3 = (ObservableList<Album>) FXCollections.observableArrayList(list3);
        albumList = new SimpleListProperty<Album>(observableList3);


    }

    public static Model getInstance(){
        if(instance==null){
            instance = new Model();
        }
        return instance;
    }


    public SimpleListProperty<Song> songCollection(){
        return songCollection;
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

    public int removeSong(Song song){
        if(songCollection.isEmpty()){
            return -1;
        }
        else if(song.albumObjectProperty.get().trackListProperty.get().size() == 1){
            song.ArtistObjectProperty().get().songListProperty().remove(song);
            song.AlbumObjectProperty().get().trackListProperty().remove(song);
            albumList.remove(song.AlbumObjectProperty().get());
            song.artistObjectProperty.get().albumListProperty().remove(song.AlbumObjectProperty().get());
            songCollection.remove(song);
        }
        song.ArtistObjectProperty().get().songListProperty().remove(song);
        song.AlbumObjectProperty().get().trackListProperty().remove(song);
        songCollection.remove(song);
        return 0;
    }

    public void addArtist(Artist artist){
        if(artistList.size() == 0){
            artistList.add(artist);
            result = 0;
        }
        else{
            for(Artist a: artistList){
                //Check for duplicates. Return -1 for error.
                if(a.nameProperty.get().compareTo(artist.nameProperty.get()) == 0){
                    result = -1;
                    return;
                }
            }
            artistList.add(artist);
            result = 0;
        }
    }

    public int removeArtist(Artist artist){
        if(artistList.isEmpty()){
            return -1;
        }
        for(Song s : artist.songListProperty()){
            songCollection.remove(s);
        }
        artist.songListProperty().removeAll();
        for(Album a : artist.albumListProperty()){
            albumList.remove(a);
        }
        artist.albumListProperty().removeAll();

        artistList.remove(artist);
        return 0;
    }

    public void addAlbum(Album album){
        if(albumList.size() == 0){
            albumList.add(album);
            album.artistObjectProperty().get().albumListProperty().add(album);
            result = 0;
        }
        else{
            for(Album a: albumList){
                //Check for duplicates. Return -1 for error.
                if(a.titleProperty.get().compareTo(album.titleProperty.get()) == 0){
                    result = -1;
                    return;
                }
            }
            albumList.add(album);
            album.artistObjectProperty().get().albumListProperty().add(album);
            result = 0;
        }
    }

    public void removeAlbum(Album album){
        if(albumList.isEmpty()){
            result = -1;
        }
        for(Song j : album.trackListProperty.get()){
            album.artistProperty.get().songListProperty().get().remove(j);
            songCollection.remove(j);
        }
        album.trackListProperty.get().removeAll();
        for(Artist a : artistList){
            if(a.nameProperty.get().compareTo(album.artistProperty.get().nameProperty.get()) == 0){
                a.albumListProperty().remove(album);
            }
        }
        albumList.remove(album);
        result = 0;
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


}
