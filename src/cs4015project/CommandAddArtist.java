package cs4015project;

public class CommandAddArtist implements Command
{
    public Model model = HelloApplication.model;
    private Artist backup;
    private final Artist artist;

    CommandAddArtist(Artist artist)
    {
        this.artist = artist;
    }

    public void getBackup()
    {
        backup = artist;
    }

    // command to remove artist on undo
    @Override
    public void undo()
    {
        model.removeArtist(backup);
        for (Artist value : model.artistList)
            System.out.println(value);
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
