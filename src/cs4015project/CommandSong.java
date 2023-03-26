package cs4015project;

public abstract class CommandSong implements Command
{
    public Model model = HelloApplication.model;
    public Song backup;
    public final Song song;

    CommandSong(Song song)
    {
        this.song = song;
    }

    public void getBackup()
    {
        for (Song s : model.getSongCollection().getList())
        {
            if (song.equals(s))
                backup = s;
        }
    }
}
