package cs4015project;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandAlbum implements Command
{
    public Model model = HelloApplication.model;
    public Album backup;
    public Album album;
    public List<Song> songList = new ArrayList<>();

    CommandAlbum(Album album)
    {
        this.album = album;
    }

    public void getBackup()
    {
        backup = album;
        songList.addAll(album.trackListProperty.get());
    }
}
