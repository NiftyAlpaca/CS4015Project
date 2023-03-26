package cs4015project;

public class CommandAddArtist extends CommandArtist
{

    CommandAddArtist(Artist artist)
    {
        super(artist);
    }

    // command to remove artist on undo
    @Override
    public void undo()
    {
        model.removeArtist(backup);
    }

    // command to add the artist
    @Override
    public boolean execute()
    {
        getBackup();
        model.addArtist(artist);
        return true;
    }
}
