package cs4015project;

public class CommandRemoveSong extends CommandSong
{
    CommandRemoveSong(Song song)
    {
        super(song);
    }

    @Override
    public void undo()
    {
        model.getSongCollection().addSong(backup);
    }

    @Override
    public boolean execute()
    {
        getBackup();
        model.getSongCollection().getList().remove(song);
        return true;
    }
}
