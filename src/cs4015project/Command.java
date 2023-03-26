package cs4015project;

public interface Command
{
    void undo();
    boolean execute();
}
