package cs4015project;

import javafx.beans.property.SimpleListProperty;

public class ProxySongCollection implements SongCollection{
    private SongCollection songCollection = new RealSongCollection();
    @Override
    public Song getSongByIndex(int index) {
        return songCollection.getSongByIndex(index);
    }

    @Override
    public int size() {
        return songCollection.size();
    }

    @Override
    public void addSong(Song song) {
        songCollection.addSong(song);
    }

    @Override
    public int RemoveSong(Song song) {
        return songCollection.RemoveSong(song);
    }

    @Override
    public void EditSong(Song song, String newTitle, String newDate, String newLength) {
        songCollection.EditSong(song,newTitle,newDate,newLength);
    }

    @Override
    public SimpleListProperty<Song> getList() {
        return songCollection.getList();
    }
}
