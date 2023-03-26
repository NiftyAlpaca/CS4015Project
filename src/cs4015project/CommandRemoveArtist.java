package cs4015project;

public class CommandRemoveArtist implements Command
{
    public Model model = HelloApplication.model;
    private Artist backup;
    private final Artist artist;


    CommandRemoveArtist(Artist artist)
    {
        this.artist = artist;
    }

    public void getBackup()
    {
        for (Artist value : model.artistList)
        {
            if (artist.equals(value))
                backup = value;
        }
    }

    // command to re-add artist on undo
    @Override
    public void undo()
    {
        model.addArtist(backup);
        for (Album album : backup.albumListProperty().toArray(new Album[0]))
            model.addAlbum(album);
        for (Song song : backup.songListProperty().toArray(new Song[0]))
            model.addSong(song);
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
