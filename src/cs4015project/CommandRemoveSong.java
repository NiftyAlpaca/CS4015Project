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
        model.addSong(backup);
    }

    @Override
    public boolean execute()
    {
        getBackup();
        model.getSongCollection().removeSong(song);
        return true;
    }
}
