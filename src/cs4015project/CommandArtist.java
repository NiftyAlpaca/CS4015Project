package cs4015project;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandArtist implements Command
{
    public Model model = HelloApplication.model;
    public Artist backup;
    public Artist artist;
    public List<Song> songList = new ArrayList<>();

    CommandArtist(Artist artist)
    {
        this.artist = artist;
    }

    public void getBackup()
    {
        backup = artist;
        songList.addAll(artist.songListProperty().get());
    }
}
