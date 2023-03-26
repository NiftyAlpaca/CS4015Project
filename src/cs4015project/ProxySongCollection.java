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
    public int removeSong(Song song) {
        return songCollection.removeSong(song);
    }

    @Override
    public void editSong(Song song, String newTitle, String newDate, String newLength) {
        songCollection.editSong(song,newTitle,newDate,newLength);
    }

    @Override
    public SimpleListProperty<Song> getList() {
        return songCollection.getList();
    }
}
