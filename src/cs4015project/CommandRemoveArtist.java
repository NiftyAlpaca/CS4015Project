package cs4015project;

import java.util.ArrayList;
import java.util.List;

public class CommandRemoveArtist extends CommandArtist
{
    CommandRemoveArtist(Artist artist)
    {
        super(artist);
    }

    // command to re-add artist on undo
    @Override
    public void undo()
    {
        model.addArtist(backup);
        for (Album album : backup.albumListProperty().toArray(new Album[0]))
            model.addAlbum(album);
        for (Song song : songList)
            model.getSongCollection().addSong(song);
    }

    // command to remove the artist
    @Override
    public boolean execute()
    {
        getBackup();
        model.removeArtist(artist);
        return true;
    }
}
