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
        model.getSongCollection().RemoveSong(backup);
    }

    @Override
    public boolean execute()
    {
        model.getSongCollection().addSong(song);
        getBackup();
        System.out.println(backup);
        return true;
    }
}
