package cs4015project;

public class CommandRemoveAlbum extends CommandAlbum
{
    CommandRemoveAlbum(Album album)
    {
        super(album);
    }

    @Override
    public void undo()
    {
        for (Song s : songList)
            model.getSongCollection().addSong(s);
        model.addAlbum(backup);
    }

    @Override
    public boolean execute()
    {
        getBackup();
        model.removeAlbum(album);
        return true;
    }
}
