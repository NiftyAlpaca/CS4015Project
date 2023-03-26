package cs4015project;

public class CommandAddAlbum extends CommandAlbum
{
    CommandAddAlbum(Album album)
    {
        super(album);
    }

    @Override
    public void undo()
    {
        model.removeAlbum(backup);
    }

    @Override
    public boolean execute()
    {
        getBackup();
        model.addAlbum(album);
        return true;
    }
}
