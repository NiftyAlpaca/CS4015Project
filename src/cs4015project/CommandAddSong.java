package cs4015project;

public class CommandAddSong extends CommandSong
{
    CommandAddSong(Song song)
    {
        super(song);
    }

    @Override
    public void undo()
    {
        model.getSongCollection().removeSong(backup);
    }

    @Override
    public boolean execute()
    {
        model.addSong(song);
        getBackup();
        return true;
    }
}
