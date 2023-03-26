package cs4015project;

import javafx.beans.property.SimpleListProperty;

public interface SongCollection {
    public Song getSongByIndex(int index);

    public int size();

    public void addSong(Song song);

    public int RemoveSong(Song song);

    public void EditSong(Song song, String newTitle, String newDate, String newLength);

    public SimpleListProperty<Song> getList();
}
