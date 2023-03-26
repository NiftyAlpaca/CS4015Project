package cs4015project;

import javafx.beans.property.SimpleListProperty;

import java.util.Iterator;

public class SongIterator implements Iterator {

    private int index;
    private final SongCollection songCollection;

    public SongIterator(SongCollection songCollection){
        this.songCollection = songCollection;
        index = 0;
    }

    public Song getCurrentSong(){
        return this.songCollection.getSongByIndex(index);
    }

    @Override
    public boolean hasNext(){
        return index < (songCollection.size() - 1);
    }

    public boolean hasPrev(){
        return index > 0;
    }

    @Override
    public Song next(){
        if(!hasNext()){ return null; }
        index++;
        return songCollection.getSongByIndex(index);
    }

    public Song prev(){
        if(!hasPrev()){ return null; }
        index--;
        return songCollection.getSongByIndex(index);
    }


}
